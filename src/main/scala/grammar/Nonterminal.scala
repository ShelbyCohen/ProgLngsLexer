package grammar

/**
  *
  * @param title2
  * @param children2
  */
case class Nonterminal(title2: String, children2: List[Node]) extends Node {

  val title = title2
  val children = children2

  /**
    *
    * @param tabs
    * @return calls toStringStub to return a string of whitespace
    */
  def toString(tabs: String): String = {
    //tabs + "\t" + title + toStringStub(children, tabs)
    tabs + title + "\n" + printListOfNodes(children, tabs+"\t")
  }

  /**
    * calls function that prints a single node
    *
    * @return
    */
  def printListOfNodes(children: List[Node], tabs:String): String = {
    if (children.isEmpty) ""
    else {
      val return_str = children.head.toString(tabs)
      val term_list = printListOfNodes(children.tail, tabs)
      return_str + "\n"+ term_list
    }
  }
}
