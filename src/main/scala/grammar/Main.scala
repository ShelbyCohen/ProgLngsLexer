package grammar

object Main extends Lexer{

  def main(args: Array[String]): Unit = {
    val statement = "set myRobot jump" toString()
    println(totalLex(statement))
  }



}

