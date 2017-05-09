package grammar

/**
  * Created by ShelbyCohen on 4/26/17.
  */
case class Terminal(token_lexeme2: (String, String)) extends Node{

  val token_lexeme = token_lexeme2

  /**
    *
    * @param inputStr
    * @return return a string of whitespace
    */
  def toString(inputStr: String): String = {
    inputStr + token_lexeme.toString()

  }

}
