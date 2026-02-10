package com.myachin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.nio.file.Path;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArgumentsConfig {
    List<Path> filesToParse;
    Path outputDirectory;
    String prefix;
    boolean shortStats;
    boolean fullStats;
    boolean appendMode;
}