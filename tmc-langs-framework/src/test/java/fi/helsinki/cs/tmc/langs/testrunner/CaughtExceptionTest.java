package fi.helsinki.cs.tmc.langs.testrunner;

import org.junit.Test;
import static org.junit.Assert.*;

public class CaughtExceptionTest {

    @Test
    public void testCloneCreatesIdenticalClass() {
        try {
            ArrayIndexOutOfBoundsException exception = new ArrayIndexOutOfBoundsException("test");
        } catch (Exception e) {
            CaughtException ce = new CaughtException(e);
            CaughtException ceClone = ce.clone();

            assertEquals(ceClone.toString(), ce.toString());
        }

    }
}