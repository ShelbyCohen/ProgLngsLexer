package grammar

import scala.io.Source

/**
  * Created by ShelbyCohen on 3/27/17.
  */
object Main {
  def main(args: Array[String]) {
    // println(defineTokenLexemePairs())

    val file = "/Users/ShelbyCohen/Scala/grammar/src/sentences.txt"
    var tokens: List[String] = List()

    for (token <- Source.fromFile(file).getLines) {
      tokens = tokens :+ (token)
      print(token)
    }

    println(getMapValue("IDENT"))  // "Value found: IDENT"
    println(getMapValue("error"))  // "No value found"
  }

  val myMap = Map("END" -> ".", "IDENT" -> "myRobot", "test" -> 0)

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
