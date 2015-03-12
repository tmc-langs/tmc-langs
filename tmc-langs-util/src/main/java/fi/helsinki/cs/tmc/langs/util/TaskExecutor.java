package fi.helsinki.cs.tmc.langs.util;

import com.google.common.base.Optional;
import fi.helsinki.cs.tmc.langs.LanguagePlugin;
import fi.helsinki.cs.tmc.stylerunner.validation.ValidationResult;

import java.nio.file.Path;

public class TaskExecutor {

    /**
     * Run checkstyle check for the project at the given path.
     * @param path to the required project.
     * @return ValidationResult if checkstyle check was successful, otherwise absent optional.
     */
    public static Optional<ValidationResult> runCheckCodeStyle(Path path) {
        Optional<LanguagePlugin> languagePluginOptional = ProjectTypeHandler.getLanguagePlugin(path);

        if (languagePluginOptional.isPresent()) {
            return Optional.of(languagePluginOptional.get().checkCodeStyle(path));
        }

        return Optional.absent();
    }
}