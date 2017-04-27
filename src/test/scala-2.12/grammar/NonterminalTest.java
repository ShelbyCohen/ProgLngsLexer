package grammar;

import org.junit.Test;
import scala.Tuple2;

import static org.junit.Assert.*;

/**
 * Created by ShelbyCohen on 4/26/17.
 */
public class NonterminalTest {

    Nonterminal testClass = new Nonterminal(Node, Node);


    @Test
    public void testExpression() throws Exception {

    }

    @Test
    public void testAction_stmt() throws Exception {

    }

    @Test
    public void testSet_stmt() throws Exception {
        Tuple2<String, String> token_lexeme = testClass.set_stmt((".", "END"), (" ","test"));

        testClass.toString(token_lexeme);

    }

    @Test
    public void testStmt() throws Exception {

    }

    @Test
    public void testStmts() throws Exception {

    }

    @Test
    public void testList_of_nodes() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testToString1() throws Exception {

    }
}