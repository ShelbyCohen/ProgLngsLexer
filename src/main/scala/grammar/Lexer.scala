package grammar

/**
  * The Lexer program implements an application that generates a list of Token, Lexeme tuples from an input statement
  *
  * @author  Shelby Cohen
  * @since   3/27/17
  *
  *
  Keywords: (Lexemes, Tokens):
             DIRECTION → right, left, forward, backward
             IDENT → myRobot
             ACTION → walk, jog, run, sprint
             PART → head, feet, arms, legs, hands
             FACEPART → eyes, mouth
             INT → 1, 2, 3, 4, 5, 6...
             OPERATOR → *, +, -, /
             ERROR
  */

  object Lexer {

    val myMap = Map(("." -> "END"), ("myRobot" -> "IDENT"), ("set" -> "SET"), ("head" -> "PART"),
      ("2" -> "INT"), ("walk" -> "ACTION"), ("right", "DIRECTION"),("forward", "DIRECTION"),("eyes", "FACEPART"), ("*", "OPERATOR"), ("3", "INT"))

    /**
      * totalLex reads in the statement and uses the function nextLex to recursively make a list of token lexeme pairs
      * for the entire statement
      *
      * @param inputStr
      * @return List[(String, String)]
      *         List of tuples (token, lexeme pairs)
      */
    def totalLex(inputStr: String): List[(String, String)] = {

      def totalLexStub(inputStr1: String, currentList: List[(String, String)]): List[(String, String)] = {

        if (inputStr1.isEmpty) currentList
        else {
          val (lexeme, token, theRest) = nextLex(inputStr1)
          val newPair = (lexeme, token)
          val updatedCurrentList = newPair :: currentList
          // reverse list of tuples in functional style
          totalLexStub(theRest, updatedCurrentList)
        }
      }
      val reverseList = totalLexStub(inputStr, List[(String, String)]())
      reverseList.reverse
    }

    /**
      * nextLex reads in the statement and uses the functions ident, intLiteral, and symbols depending on the character
      * in the input string. It returns the lexeme, token pair found along with the rest of the string that has not been
      * parsed yet
      *
      * @param inputStr : String
      * @return (String, String, String)
      *         lexeme, token, the rest of the input string
      */
    def nextLex(inputStr: String): (String, String, String) = {

      def nextLexStub(inputStr1: String, index: Int): (String, String, String) = {
        if (inputStr1.charAt(index) == ' ') nextLexStub(inputStr1.substring(index + 1, inputStr1.length), 0)
        else if (inputStr1.charAt(index).isLetter) ident(inputStr1, index)
        else if (inputStr1.charAt(index).isDigit) intLiteral(inputStr1, index)
        else symbols(inputStr1, index)
      }
      nextLexStub(inputStr, 0)
    }

    /**
      * lookup checks is the lexeme found is mapped to a token in the map with predetermined lexeme, token pairs (myMap)
      *
      * @param lexeme : String
      * @return String
      *         myMap value for the lexeme if found which is the token
      */
    def lookup(lexeme: String): String = {
      if (lexeme.isEmpty) "Empty"
      else if (isMapValue(lexeme)) getMapValue(lexeme)
      else "IDENT"
    }

    /**
      * ident reads in the statement and returns a lexeme, token, and the rest of the statement
      * ident is only called if the character being parsed is a letter
      *
      * @param inputStr : String
      * @param index    : Int
      * @return (String, String, String)
      *         lexeme, token, the rest of the input string
      */
    def ident(inputStr: String, index: Int): (String, String, String) = {
      if (index >= inputStr.length) (inputStr, lookup(inputStr), "")
      else if (!inputStr.charAt(index).isLetter && !inputStr.charAt(index).isDigit) (inputStr.substring(0, index), lookup(inputStr.substring(0, index)), inputStr.substring(index, inputStr.length))
      else ident(inputStr, index + 1)
    }

    /**
      * intLiteral reads in the statement and returns a lexeme, token, and the rest of the statement
      * intLiteral is only called if the character being parsed is a number
      *
      * @param inputStr
      * @param index : Int
      * @return (String, String, String)
      *         lexeme, token, the rest of the input string
      */
    def intLiteral(inputStr: String, index: Int): (String, String, String) = {
      if (index >= inputStr.length) (inputStr, lookup(inputStr), "")
      else if (!inputStr.charAt(index).isDigit) (inputStr.substring(0, index), lookup(inputStr.substring(0, index)), inputStr.substring(index, inputStr.length))
      else intLiteral(inputStr, index + 1)
    }

    /**
      * symbols reads in the statement and returns a lexeme, token, and the rest of the statement
      * symbols is only called if the character being parsed is a symbol
      *
      * @param inputStr
      * @param index : Int
      * @return (String, String, String)
      *         lexeme, token, the rest of the input string
      */
    def symbols(inputStr: String, index: Int): (String, String, String) = {
      (inputStr.charAt(index).toString(), lookup(inputStr.charAt(index).toString()), inputStr.substring(index + 1, inputStr.length()))

      // else if (inputStr.charAt(index).isLetterOrDigit) (inputStr.substring(0, index), lookup(inputStr.substring(0, index)), inputStr.substring(index, inputStr.length))
      // else symbols(inputStr, index + 1)
    }

    def isMapValue(s: String): Boolean = {
      myMap get s match {
        case Some(nb) => true
        case None => false
      }
    }

    def getMapValue(s: String): String = {
      myMap get s match {
        case Some(nb) => nb
        case None => "No value found"
      }
    }


}
