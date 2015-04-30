package fi.helsinki.cs.tmc.langs.make;

import fi.helsinki.cs.tmc.langs.ExerciseDesc;
import fi.helsinki.cs.tmc.langs.RunResult;
import fi.helsinki.cs.tmc.langs.TestDesc;
import fi.helsinki.cs.tmc.langs.TestResult;
import fi.helsinki.cs.tmc.langs.utils.TestUtils;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class MakePluginTest {

   
    private MakePlugin makePlugin;
    private Path classDir;
    
    public MakePluginTest() {
        makePlugin = new MakePlugin();
        classDir = Paths.get("./src", "test", "resources", "makefile");
    }

    @Test
    public void testGetLanguageName() {
        assertEquals("C/C++/Fortran", makePlugin.getLanguageName());
    }
    
    @Test
    public void testScanExerciseReturnExerciseDesc() {
        String name = "Make Test";
        ExerciseDesc description = makePlugin.scanExercise(classDir, name);
        assertEquals(name, description.name);
        assertEquals(1, description.tests.size());
    }
    
    @Test
    public void testScanExerciseReturnsCorrectTests() {
        String name = "Make Test";
        ExerciseDesc description = makePlugin.scanExercise(classDir, name);
        assertEquals(1, description.tests.size());
        
        TestDesc test = description.tests.get(0);
        assertEquals("test_source test_sum", test.name);
        assertEquals("1", test.points.get(0));
        assertEquals("2", test.points.get(1));
    }
    
    @Test
    public void testScanExerciseReturnsNullWhenWrongProjectType() {
        assertNull(makePlugin.scanExercise(Paths.get("./src", "test", "resources", "non-make-project"), "Dummy"));
    }
    
}
