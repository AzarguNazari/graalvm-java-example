package com.examples.graalvm;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        name = "dockercli",
        version = "1.0.0",
        description = "A Docker-inspired CLI built with picocli and GraalVM native-image"
)
public class DockerCli implements Runnable {

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version and exit")
    private boolean versionInfoRequested;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message")
    private boolean usageHelpRequested;

    @Parameters(paramLabel = "<args>", description = "Additional arguments")
    private String[] args;

    @Override
    public void run() {
        if (!usageHelpRequested && !versionInfoRequested) {
            System.out.println("Docker CLI - GraalVM native image");
            System.out.println("Use --help to see available options.");
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new DockerCli()).execute(args);
        System.exit(exitCode);
    }
}
