package grammar

/**
  * Created by ShelbyCohen on 4/26/17.
  */
case class Nonterminal(title2: String, children2: List[Node]) extends Node{

  val title = title2
  val children = children2



  /**
    *
    * @param space
    * @return calls toStringStub to return a string of whitespace
    */
  def toString(space: String): String = {
    space + "\t" + title + toStringStub(children)
    //recursion or list comprehension

  }


}
