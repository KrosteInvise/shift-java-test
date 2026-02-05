package com.myachin.commandline;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.nio.file.Path;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArgumentsConfig {

    List<Path> filesToParse;
    Path outputDirectory;
}
