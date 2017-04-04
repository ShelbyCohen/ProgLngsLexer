package grammar

import scala.io.Source

/**
  * Created by ShelbyCohen on 3/27/17.
  */
object Main {
  def main(args: Array[String]) {
    val statement = "set myRobot jump ." toString()

    // var tokens: List[String] = List()
    // tokens = fileContents.split(" ").toList

    println(totalLex(statement))

  }
  val myMap = Map("." -> "END",
                  "myRobot" -> "IDENT",
                  "set" -> "Set",
                  "jump" -> "ACTION")

  // calls nextLex
  // starts with string and ends with a list of tuples
  def totalLex(statement: String): ((String, String), (String, String), (String, String) = {


  }

  def nextLex(s: String): String = {

  }

  def lookup(tokens: List[String]): Map[String, String] = {
    // val file = "/Users/ShelbyCohen/Scala/grammar/src/sentences.txt"
    // val fileContents = Source.fromFile(file).getLines.mkString
    // lexemes = fileContents.split(" ")
    var lexemes: List[String] = List()
    var newMap = Map("test" -> "new")

    if (!tokens.isEmpty) {
      //if (myMap.valuesIterator.exists(_.contains(tokens.head)))
      if (isMapValue(tokens.head)) {
        println(tokens.head, getMapValue(tokens.head))
        // lexemes = tokens.head :: lexemes
        newMap += (tokens.head -> getMapValue(tokens.head))
      }
      else {
        newMap += (tokens.head -> "ERROR")
        println(newMap.get(tokens.head))
        lookup(tokens.tail)
      }
    }
    else newMap
  }

  // ident takes a String lexeme and returns a lexeme, token, and the rest of the statement
  // assume first char is a letter
  def ident(lexeme: String, index: Int): (String, String, String) = {

    token = lookup(lexeme)

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
