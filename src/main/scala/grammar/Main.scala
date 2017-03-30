package grammar

import scala.io.Source

/**
  * Created by ShelbyCohen on 3/27/17.
  */
object Main {
  def main(args: Array[String]) {
    val fileContents = ". . myRobot ." toString()

    var lexemes: List[String] = List()
    lexemes = fileContents.split(" ").toList

    println(sentence(lexemes.head, lexemes))

  }

  val myMap = Map("." -> "END", "myRobot" -> "IDENT")

  def sentence(lexeme: String, lexemes: List[String]): List[String] = {
    // val file = "/Users/ShelbyCohen/Scala/grammar/src/sentences.txt"
    // val fileContents = Source.fromFile(file).getLines.mkString
    // lexemes = fileContents.split(" ")

    var tokens: List[String] = List()

    if (isMapValue(lexemes.head))
      tokens = getMapValue(lexemes.head) :: tokens
    else sentence(lexemes.head, lexemes.tail)
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
