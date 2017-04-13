package grammar;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ShelbyCohen on 4/13/17.
 */
public class LexerTest {
    Lexer testClass = new Lexer();

    @Test
    public void testLookup() throws Exception {
        String token = testClass.lookup(".");
        assertEquals("END", token);
    }

    @Test
    public void testMyMap() throws Exception {

    }

    @Test
    public void testIntLiteral() throws Exception {

    }

    @Test
    public void testSymbols() throws Exception {

    }

    @Test
    public void testTotalLex() throws Exception {

    }

    @Test
    public void testNextLex() throws Exception {

    }

    @Test
    public void testIdent() throws Exception {

    }

    @Test
    public void testGetMapValue() throws Exception {

    }

    @Test
    public void testIsMapValue() throws Exception {

    }
}