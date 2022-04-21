package com.examples.graalvm;

public class DockerCli {

    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            System.err.println("Please give some argument");
            System.exit(1);
        }

        System.out.printf("given argument %s%n", args[0]);
    }
}
