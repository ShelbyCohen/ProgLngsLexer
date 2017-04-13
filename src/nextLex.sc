
def nextLex(inputStr: String): (String, String, String) = {

  def nextLexStub(inputStr1: String, index: Int): (String, String, String) = {
    if (inputStr.charAt(index).isLetter) ident(inputStr, index)
    else ("error", "", "")
  }
  nextLexStub(inputStr, 0)
}



// ident takes a String lexeme and returns a lexeme, token, and the rest of the statement
// assume first char is a letter
def ident(inputStr: String, index: Int): (String, String, String) = {
  if(index >= inputStr.length) (inputStr, "IDENT", "")
  else if(!inputStr.charAt(index).isLetter) (inputStr.substring(0, index), "IDENT", inputStr.substring(index + 1, inputStr.length))
  else ident(inputStr, index + 1)
}

def addingList(currentList: List[(String, String)]) : List[(String, String)] = {
  val inputStr = "test input"
  val emptyList = List()

  // add whatever nextLex returns to new list of tuples
  if (inputStr.isEmpty) currentList
  else {
    val toAdd = nextLex(inputStr)
    val newPair = (toAdd._1, toAdd._2)
    newPair :: List(currentList.head, currentList.tail)
    //addingList(currentList ++ emptyList)
  }

}
// val test = List([("test", "IDENT", "the rest of things"), ("", "", "")])
// val test = ("test", "IDENT", "the rest of things")
 var test = List(("test", "test"))
println(addingList(test))

