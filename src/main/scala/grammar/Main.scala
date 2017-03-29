package grammar

import scala.io.Source

/**
  * Created by ShelbyCohen on 3/27/17.
  */
object Main {
  def main(args: Array[String]) {
    val file = "/Users/ShelbyCohen/Scala/grammar/src/sentences.txt"
    var lexemes: List[String] = List()

//    for (token <- Source.fromFile(file).getLines) {
//      tokens = tokens :+ (token)
//      println(tokens.split(" "))
//    }

    val fileContents = Source.fromFile(file).getLines.mkString
    lexemes = fileContents.split(" ")
    print(array.head)

    println(sentence(lexemes))

  }

  val myMap = Map("." -> "END", "myRobot" -> "IDENT")

  def sentence(lexemes: List[String]): List[String] = {
    var tokens: List[String] = List()
    tokens = sentence(lexemes.head)

    println(getMapValue(array.head)) // "Value found: IDENT"
    println(getMapValue("error")) // "No value found"
  }

  //there is no concept of null pointer
  def getMapValue(s: String): String = {
    myMap get s match {
      case Some(nb) => "Value found: " + nb
      case None => "No value found"
    }
  }
  //    def getMapValue2(s: String): String =
  //      val myMap = Map("IDENT" -> "myRobot", "test" -> 0)
  //
  //      myMap.get(s).map("Value found: " + _).getOrElse("No value found")

}
