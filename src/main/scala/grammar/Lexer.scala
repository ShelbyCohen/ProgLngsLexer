package grammar

/**
  * Created by ShelbyCohen on 3/27/17.
  */

import scala.io.Source

object Lexer {

  def defineTokenLexemePairs(): Map[String, String] = {
//    val tokenFile = "/Users/ShelbyCohen/Scala/grammar/src/tokens.txt"
//    val lexemeFile = "/Users/ShelbyCohen/Scala/grammar/src/lexemes.txt"
//    var tokens: List[String] = List()
//
//    for (token <- Source.fromFile(tokenFile).getLines) {
//      print(token)
//    }

//     val pair = ("IDENT", "myRobot") // type: (String, String)
//     val (label, value) = pair // label = "answer", value = 42

    val myMap = Map("IDENT" -> "myRobot", "test" -> 0)

    //there is no concept of null pointer
    def getMapValue(s: String): String = {
      myMap get s match {
        case Some(nb) => "Value found: " + nb
        case None => "No value found"
      }
    }
    def getMapValue2(s: String): String =
      myMap.get(s).map("Value found: " + _).getOrElse("No value found")
  }

}
