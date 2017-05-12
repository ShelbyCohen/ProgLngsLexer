package grammar

object Main {

  /**
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {

    val statement = "set myRobot head right ."
    val expression = "2 * 2"
    val action_stmt = "walk myRobot right 3 * 2 * 2 . set myRobot head up . set myRobot head down ."

    val lexer_parser = Lexer.totalLex(action_stmt)
    println(Lexer.totalLex(action_stmt))

    //val to_print = Parser.set_stmt(lexer_parser)
    // val to_print = Parser.expression(lexer_parser)
    // val to_print = Parser.action_stmt(lexer_parser)
    val to_print = Parser.stmts(lexer_parser)


    println(to_print._1.toString(""))
  }
}

