package grammar;

import org.junit.Test;
import scala.Tuple2;
import scala.Tuple3;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ShelbyCohen on 4/13/17.
 */
public class LexerTest {

    @Test
    public void testLookup() throws Exception {
        String token = Lexer.lookup(".");
        assertEquals("END", token);
    }

    @Test
    public void testErrorLookup() throws Exception {
        String token = Lexer.lookup(",");
        assertEquals("Error", token);
    }

    @Test
    public void testIdent() throws Exception {
        Tuple3<String, String, String> identTuple = Lexer.ident("set.set", 0);

        assertEquals("set", identTuple._1());
        assertEquals("Set", identTuple._2());
        assertEquals(".", identTuple._3());
    }

    @Test
    public void testIntLiteral() throws Exception {
        Tuple3<String, String, String> intTuple = Lexer.intLiteral("2 2 2", 0);

        assertEquals("2", intTuple._1());
        assertEquals("INTLITERAL", intTuple._2());
        assertEquals("2 2", intTuple._3());
    }

    @Test
    public void testSymbols() throws Exception {
        Tuple3<String, String, String> symbolTuple = Lexer.symbols(". . 2 test", 0);

        assertEquals(".", symbolTuple._1());
        assertEquals("END", symbolTuple._2());
        assertEquals(". 2 test", symbolTuple._3());
    }

    @Test
    public void testNextLex() throws Exception {

        Tuple3<String, String, String> identTuple = Lexer.nextLex("set myRobot right .");
        assertEquals("set", identTuple._1());
        assertEquals("Set", identTuple._2());
        assertEquals("myRobot right .", identTuple._3());
    }
}