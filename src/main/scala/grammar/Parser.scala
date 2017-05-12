package grammar

/**
  * Created by ShelbyCohen on 4/27/17.
  *
  * object Parser
  * The rules for this programming language are inside the functions in this Parser object
  *
  * Rules:
  * <program> → START <stmts> END
  * <stmts> → <stmt> | 𝞊
  * <stmt> → <action_stmt><stmts> | <set_stmt><stmts>

  * <action_stmt> → ACTION IDENT DIRECTION <expression> END
  * <set_stmt> → SET IDENT PART DIRECTION END

  * <expression> → INT <the_rest>
  * <the_rest> → OPERATOR <expression> | 𝞊
  *
  *
  */
object Parser {

    /**
      * stmt either is an action stmt and more stmts OR a set stmt and more stmts
      *
      * @param token_lexeme_pairs
      * @return
      */
    def stmt(token_lexeme_pairs: List[(String, String)]): (Node, List[(String, String)]) = {
      val node_list = List[Node]()

      if (token_lexeme_pairs.head._2.equals("ACTION")) {
        val more_stmts = action_stmt(token_lexeme_pairs)
        val newList = more_stmts._1 :: node_list
        println("stmt ", more_stmts._2)

        val stmtsReturns = stmts(more_stmts._2)
        val newList1 = stmtsReturns._1 :: newList

        val nonTermNode = Nonterminal("<stmt>", newList1.reverse)
        return (nonTermNode, stmtsReturns._2)
      }

      else if (token_lexeme_pairs.head._2.equals("SET")) {
        val more_stmts = set_stmt(token_lexeme_pairs)
        val newList = more_stmts._1 :: node_list
        val stmtsReturns = stmts(more_stmts._2)
        val newList1 = stmtsReturns._1 :: newList

        val nonTermNode = Nonterminal("<stmt>", newList1.reverse)
        return (nonTermNode, stmtsReturns._2)
      }

      else {
        val nonTermNode = Nonterminal("ERROR", List[Node]())
        return (nonTermNode, List())
      }
    }

    /**
      * stmts calls stmt OR nothing
      *
      * @param token_lexeme_pairs
      * @return
      */
    def stmts(token_lexeme_pairs: List[(String, String)]): (Node, List[(String, String)]) = {
      val node_list = List[Node]()

      if (token_lexeme_pairs.isEmpty) {
        val nonTermNode = Nonterminal("", List[Node]())
        return (nonTermNode, token_lexeme_pairs)
      } else {
        val stmtReturn = stmt(token_lexeme_pairs)
        val newList = stmtReturn._1 :: node_list
        val nonTermNode = Nonterminal("<stmts>", newList)
        if (!token_lexeme_pairs.isEmpty){
          val nonTermNode = Nonterminal("<stmts>", newList)
          return (nonTermNode, List())
        }
        return (nonTermNode, stmtReturn._2)
      }
    }

  /**
    * set_stmt is for a non-terminal that starts with "set"
    * it takes in a list of token_lexeme_pairs that the Lexer Class has returned
    *
    * @param token_lexeme_pairs
    * @return List of Nodes and the rest of the list of token_lexeme_pairs
    */
  def set_stmt(token_lexeme_pairs: List[(String, String)]): (Node, List[(String, String)]) = {
    val node_list = List[Node]()

    if (token_lexeme_pairs.head._2.equals("SET")) {
      val termNode = Terminal((token_lexeme_pairs.head._1, "SET"))
      val newList = termNode :: node_list
      val rest_of_list = token_lexeme_pairs.tail
      if (rest_of_list.head._2.equals("IDENT")) {
        val termNode = Terminal((rest_of_list.head._1, "IDENT"))
        val newList1 = termNode :: newList
        if (rest_of_list.tail.head._2.equals("PART")) {
          val termNode = Terminal((rest_of_list.tail.head._1, "PART"))
          val newList2 = termNode :: newList1
          if (rest_of_list.tail.tail.head._2.equals("DIRECTION")) {
            val termNode = Terminal((rest_of_list.tail.tail.head._1, "DIRECTION"))
            val newList3 = termNode :: newList2
            if (rest_of_list.tail.tail.tail.head._2.equals("END")) {
              val termNode = Terminal((rest_of_list.tail.tail.tail.head._1, "END"))
              val newList4 = termNode :: newList3
              val nonTermNode = Nonterminal("<set_stmt>", newList4.reverse)
              return (nonTermNode, rest_of_list.tail.tail.tail.tail)

            }
          }
        }
      }
    }

    val nonTermNode = Nonterminal("ERROR--", List[Node]())
    (nonTermNode, token_lexeme_pairs)
  }

  /**
    *
    * action_stmt makes a recursive call to nonterminal function (i.e. action_stmt)
    * which returns a node and a list of token lexeme pairs
    * //<action_stmt> → ACTION IDENT DIRECTION <expression> END
    *

    * @param token_lexeme_pairs
    * @return
    */
  def action_stmt(token_lexeme_pairs: List[(String, String)]): (Node, List[(String, String)]) = {
    val node_list = List[Node]()

    if (token_lexeme_pairs.isEmpty) {
      val nonTermNode = Nonterminal("<the_rest>", List[Node]())
      return (nonTermNode, token_lexeme_pairs)
    }
    if (token_lexeme_pairs.head._2.equals("ACTION")) {
      val termNode = Terminal((token_lexeme_pairs.head._1, "ACTION"))
      val newList = termNode :: node_list
      val rest_of_list = token_lexeme_pairs.tail
      if (rest_of_list.head._2.equals("IDENT")) {
        val termNode = Terminal((rest_of_list.head._1, "IDENT"))
        val newList1 = termNode :: newList
        if (rest_of_list.tail.head._2.equals("DIRECTION")) {
          val termNode = Terminal((rest_of_list.tail.head._1, "DIRECTION"))
          val newList2 = termNode :: newList1
          val exp = expression(rest_of_list.tail.tail)
          val newList3 = exp._1 :: newList2
          if (exp._2.head._2.equals("END")) {
            val termNode = Terminal((exp._2.head._1, "END"))
            val newList4 = termNode :: newList3
            val nonTermNode = Nonterminal("<action_stmt>", newList4.reverse)
            return (nonTermNode, exp._2.tail)
          }
        }
      }
    }
    val nonTermNode = Nonterminal("ERROR", List[Node]())
    return (nonTermNode, token_lexeme_pairs)
  }

  def expression(token_lexeme_pairs: List[(String, String)]): (Node, List[(String, String)]) = {
    val node_list = List[Node]()
    if (token_lexeme_pairs.isEmpty) {
      val nonTermNode = Nonterminal("", List[Node]())
      return (nonTermNode, token_lexeme_pairs)
    }
    if (token_lexeme_pairs.head._2.equals("INT")) {
      val termNode = Terminal((token_lexeme_pairs.head._1, "INT"))
      val newList = termNode :: node_list
      val theRest = the_rest(token_lexeme_pairs.tail)
      val newList1 = theRest._1 :: newList
      val nonTermNode = Nonterminal("<expression>", newList1.reverse)
      return (nonTermNode, theRest._2)
    }else{
      val nonTermNode = Nonterminal("ERROR", List[Node]())
      return (nonTermNode, token_lexeme_pairs)

    }
  }


  def the_rest(token_lexeme_pairs: List[(String, String)]): (Node, List[(String, String)]) = {
    val node_list = List[Node]()
    if (token_lexeme_pairs.isEmpty) {
      val nonTermNode = Nonterminal("<the_rest>", List[Node]())
      return (nonTermNode, token_lexeme_pairs)
    }

    if (token_lexeme_pairs.head._2.equals("OPERATOR")) {
      val termNode = Terminal((token_lexeme_pairs.head._1, "OPERATOR"))
      val newList = termNode :: node_list
      val nextExpr = expression(token_lexeme_pairs.tail)
      val newList1 = nextExpr._1 :: newList
      val nonTermNode = Nonterminal("<the_rest>", newList1.reverse)
      return (nonTermNode, nextExpr._2)
    } else {
      val nonTermNode = Nonterminal("<the_rest>", List[Node]())
      return (nonTermNode, token_lexeme_pairs)
    }

  }
}