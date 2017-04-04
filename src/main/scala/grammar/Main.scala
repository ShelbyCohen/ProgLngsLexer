package grammar

import scala.io.Source

/**
  * Created by ShelbyCohen on 3/27/17.
  */
object Main {
  def main(args: Array[String]) {
    val fileContents = ". . myRobot ." toString()

    var tokens: List[String] = List()
    tokens = fileContents.split(" ").toList

    println(sentence(tokens))

  }

  val myMap = Map("." -> "END", "myRobot" -> "IDENT")
  // val myMap = Map("END" -> ".", "IDENT" -> "myRobot")

  def sentence(tokens: List[String]): Map[String, String] = {
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
        sentence(tokens.tail)
      }
    }
    else newMap
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
