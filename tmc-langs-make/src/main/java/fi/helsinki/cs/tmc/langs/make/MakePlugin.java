package fi.helsinki.cs.tmc.langs.make;

import com.google.common.base.Throwables;
import fi.helsinki.cs.tmc.langs.*;
import fi.helsinki.cs.tmc.langs.RunResult.Status;
import fi.helsinki.cs.tmc.langs.utils.TestResultParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class MakePlugin extends AbstractLanguagePlugin {

    private TestResultParser resultParser = new TestResultParser();
    
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
        if (!isExerciseTypeCorrect(path)) {
            return null;
        }
        
        
        List<String> output = startProcess(buildTestScannerArgs(), path);
        String outputString = "";
        for (String line : output) {
            outputString += line;
        }
        
        return resultParser.parseScannerOutput(outputString.trim(), exerciseName);
    }

    @Override
    public RunResult runTests(Path path) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private List<String> buildTestScannerArgs() {
        return Arrays.asList("make", "test", "-s");
    }
    
    /**
     * Start a process using ProcessBuilder.
     *
     * @param args Arguments for starting the process.
     * @param path Path of the project
     * @return Possible output of the process.
     */
    private List<String> startProcess(List<String> args, Path path) {
        try {
            ProcessBuilder pb = new ProcessBuilder(args);
            pb.directory(path.toFile());
            Process process =  pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            List<String> results = new ArrayList<>();

            while ((line = br.readLine()) != null && !line.equals("")) {
                results.add(line);
            }

            return results;
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }
}
