package grammar

object Main {

  /**
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {


    val statement = "set myRobot head right ."
    val expression = "2 * 2"
    val action_stmt = "walk myRobot forward 3 * 2 ."


    val lexer_parser = Lexer.totalLex(action_stmt)
    println(Lexer.totalLex(action_stmt))

    //val to_print = Parser.set_stmt(lexer_parser)

    // val to_print = Parser.expression(lexer_parser)
    val to_print = Parser.action_stmt(lexer_parser)

    val termNode1:Node = Terminal("set", "SET")
    val termNode2:Node = Terminal("myRobot", "IDENT")
    val termNode3:Node = Terminal("head", "PART")

    val termList = List(termNode1, termNode2, termNode3)

    println(to_print._1.toString(""))

   //println(termNode.printListOfNodes(termList, "\t"))

    //check that to_print._2 is empty

    // test expression function to see if its printing
    // check to see if list is empty when done
    // OR if it has more tokens then print the pairs with whatever is after the valid statement

  }
}

