package com.freshtuna.tuna;

import java.io.IOException;
import java.io.OutputStream;

public interface CommandLineOptions {
    Integer getPort();

    Integer getTimeout();

    Integer getMaxThreads();

    boolean help();

    void printHelpOn(OutputStream sink) throws IOException;
}
