package com.freshtuna.tuna.impls;

import com.freshtuna.tuna.CommandLineOptions;
import com.freshtuna.tuna.config.Config;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class CommandLineOptionsUsingJOPT implements CommandLineOptions {
    private final OptionParser parser;
    private final OptionSet options;

    private final OptionSpec<Integer> timeout;
    private final OptionSpec<Integer> maxThreads;
    private final OptionSpec<Void> help;
    private final OptionSpec<Integer> port;
    private final OptionSpec<String> root;

    private CommandLineOptionsUsingJOPT(OptionParser parser,
                                        OptionSet options,
                                        OptionSpec<Integer> timeout,
                                        OptionSpec<Integer> maxThreads,
                                        OptionSpec<Void> help,
                                        OptionSpec<Integer> port,
                                        OptionSpec<String> root) {
        this.options = options;
        this.parser = parser;
        this.timeout = timeout;
        this.maxThreads = maxThreads;
        this.help = help;
        this.port = port;
        this.root = root;
    }

    public static CommandLineOptionsUsingJOPT of(String... args) {
        OptionParser parser = new OptionParser();

        return new CommandLineOptionsUsingJOPT(
                parser,
                parser.parse(args),
                withTimeoutParserArugment(parser),
                withMaxThreadsArugment(parser),
                withHelpArugment(parser),
                withPort(parser),
                withRoot(parser)
        );
    }


    @Override
    public Integer getPort() {
        return options.valueOf(port);
    }

    @Override
    public Integer getTimeout() {
        return options.valueOf(timeout);
    }

    @Override
    public Integer getMaxThreads() {
        return options.valueOf(maxThreads);
    }

    @Override
    public boolean help() {
        return options.has(help);
    }

    @Override
    public void printHelpOn(OutputStream sink) throws IOException {
        parser.printHelpOn(sink);
    }


    /**
     * field parser
     * port, docroot, timeout, maxthread, help
     */

    /**
     * adds "port" option
     */
    private static OptionSpec<Integer> withPort(OptionParser parser) {
        return parser.acceptsAll(Arrays.asList("port", "p"),
                        Config.getDefaultPortArugmentDescription())
                .withRequiredArg()
                .ofType(Integer.class)
                .defaultsTo(Config.getDefaultPort());
    }

    /**
     * adds the "docroot" option
     */
    private static OptionSpec<String> withRoot(OptionParser parser) {
        return parser.acceptsAll(Arrays.asList("docroot", "d"),
                        Config.getDefaultDocumentRoot())
                .withRequiredArg()
                .defaultsTo(Config.getDefaultDocumentRoot());
    }

    /**
     * adds the "timeout" option
     */
    private static OptionSpec<Integer> withTimeoutParserArugment(OptionParser parser) {
        return parser.acceptsAll(Arrays.asList("timeout", "t"),
                        Config.getDefaultTimeoutArugmentDescription())
                .withRequiredArg()
                .ofType(Integer.class)
                .defaultsTo(Config.getDefaultTimeout());
    }

    /**
     * adds the "maxthreads" option
     */
    private static OptionSpec<Integer> withMaxThreadsArugment(OptionParser parser) {
        return parser.acceptsAll(Arrays.asList("maxthreads", "m"),
                Config.getDefaultMaxThreadsArugmentDescription())
                .withRequiredArg()
                .ofType(Integer.class)
                .defaultsTo(Config.getDefaultMaxThreads());
    }

    /**
     * adds the "help" (usage) option
     */
    private static OptionSpec<Void> withHelpArugment(OptionParser parser) {
        return parser.acceptsAll(Arrays.asList("help", "h"),
                        Config.getDefaultHelpDescription())
                .forHelp();
    }
}
