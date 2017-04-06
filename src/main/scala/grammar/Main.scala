package grammar

import scala.io.Source

/**
  * Created by ShelbyCohen on 3/27/17.
  */
object Main {
  def main(args: Array[String]) {
    val statement = "set myRobot jump ." toString()

    // val file = "/Users/ShelbyCohen/Scala/grammar/src/sentences.txt"
    // val fileContents = Source.fromFile(file).getLines.mkString
    // var tokens: List[String] = List()
    // tokens = fileContents.split(" ").toList
    println(totalLex(statement))
  }

  val myTuple = List(("." -> "END"),
    ("myRobot" -> "IDENT"), ("set" -> "Set"), ("jump" -> "ACTION"))

  // calls nextLex
  // starts with string and ends with a list of tuples
  def totalLex(inputStr: String): ((String, String), (String, String), (String, String)) = {

    newListofTuples = List(String, String)
    // add whatever nextLex returns to new list of tuples
    if(!inputStr.isEmpty)
      newListofTuples += nextLex(inputStr, index)
    // return entire list of tuples
    else newListofTuples

  }

  def nextLex(inputStr: String, index: Int): (String, String) = {
    if(inputStr.charAt(index).isLetter) ident(inputStr, index)
    if(inputStr.charAt(index).isDigit) intLiteral(inputStr, index)
    if(!inputStr.charAt(index).isLetterOrDigit) symbols(inputStr, index)
  }

  // checks if lexeme is mapped to a token
  def lookup(lexeme: String): String = {
    if (lexeme.isEmpty) return "Error, token is empty"
    if (isMapValue(lexeme)) getMapValue(lexeme)
    else return "Error, lexeme is invalid"
  }

  // ident takes a String lexeme and returns a lexeme, token, and the rest of the statement
  // assume first char is a letter
  def ident(lexeme: String, index: Int): (String, String, String) = {
    token = lookup(lexeme)

    if(lexeme.isEmpty) return (lexeme, token, theRest)
    if(!lexeme.charAt(index).isLetter) return (lexeme, token, theRest)
    else ident(lexeme.getChars(index, index++), index++)
  }

  // intLiteral takes a String lexeme and returns a lexeme, and the rest of the statement
  // assume first char is a number
  def intLiteral(lexeme: String, index: Int): (String, String, String) = {

  }

  // symbols takes a String lexeme and returns a lexeme, and the rest of the statement
  // assume first char is a symbol
  def symbols(lexeme: String, index: Int): (String, String) = {

  }

  //there is no concept of null pointer
  def isMapValue(s: String): Boolean = {
    myTuple get s match {
      case Some(nb) => true
      case None => false
    }
  }

  def getMapValue(s: String): String = {
    myTuple get s match {
      case Some(nb) => nb
      case None => "No value found"
    }
  }
}
