package fi.helsinki.cs.tmc.langs.make;

import fi.helsinki.cs.tmc.langs.*;
import fi.helsinki.cs.tmc.langs.RunResult.Status;
import fi.helsinki.cs.tmc.langs.utils.TestResultParser;
import java.io.File;
import java.nio.file.Path;
import java.util.logging.Logger;

public class MakePlugin extends AbstractLanguagePlugin {

    @Override
    protected boolean isExerciseTypeCorrect(Path path) {
        return new File(path.toString() + File.separatorChar + "Makefile").exists();
    }

    @Override
    public String getLanguageName() {
        return "C/C++/Fortran";
    }

    @Override
    public ExerciseDesc scanExercise(Path path, String exerciseName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RunResult runTests(Path path) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
