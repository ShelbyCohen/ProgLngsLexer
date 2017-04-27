package grammar

object Main extends Lexer{

  def main(args: Array[String]): Unit = {
    val statement = "set my3RobotTwo jump 23..."
    println(totalLex(statement))
  }
}

