
import scala.io.Source

val tokenFile = "/Users/ShelbyCohen/Scala/grammar/src/tokens.txt"
val lexemeFile = "/Users/ShelbyCohen/Scala/grammar/src/lexemes.txt"
var tokens : List[String] = List()

for (token <- Source.fromFile(tokenFile).getLines) {
  tokens = tokens :+ (token)
  print(tokens)
}

// Source.fromFile("tokenFile.txt").getLines.toList

/*  //example fucntion that would finish lexing a string literal
  val stringLiteral lexSoFar str =
//TODO: continue processing lexSoFar and str so that they return the correct values
lexSoFar, LITERAL, str


//progStr is a parameter
//returns SET, set, and the rest of what didn't get processed yet
//recursive process until string is empty
//every program that gets lexed has a separate data structure

val nextLex progStr = match progStr with
|"" -> failwith "Can't lex an empty string"
| _ ->
  val currChar = progStr.[0]
  val currStr = string currChar
  val rest = progStr.[1..]
//find which arrow to follow in the FSM...
match currChar with
|'"' -> stringLiteral currStr rest
|_ -> currStr, ERROR, rest

val testLexer program =
  val rec testLexerHelper remainingProgram currLexList =
    val token, lexeme, rest = nextLex remainingProgram
match rest with
|"" ->List.rev ((token, lexeme)::currLexList)
|_ -> testLexerHelper rest ((token, lexeme)::currLexList)
testLexerHelper program []

val progString = "???"
//for loading from file...note that path is absolute, not relative
Source.fromFile("tokenFile.txt").getLines.toList

//ans is a list of token-lexeme tuples
val ans = testLexer progString
  print(ans)*/



val pair = ("IDENT", "myRobot")   // type: (String, String)
val (label, value) = pair   // label = "answer", value = 42
pair._1 // "IDENT"
pair._2 // "myRobot"
val myMap = Map("IDENT" -> "myRobot", "test" -> 0)
//there is no concept of null pointer
def getMapValue(s: String): String = {
  myMap get s match {
    case Some(nb) => "Value found: " + nb
    case None => "No value found"
  }
}
getMapValue("IDENT")  // "Value found: IDENT"
getMapValue("error")  // "No value found"
def getMapValue2(s: String): String =
  myMap.get(s).map("Value found: " + _).getOrElse("No value found")

