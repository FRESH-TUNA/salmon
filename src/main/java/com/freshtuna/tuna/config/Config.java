package com.freshtuna.tuna.config;

/**
 *  Configuration class
 */
public class Config {
    /**
     * this class is util
     */
    private Config() {}

    /**
     * Default port, timeout, document roots
     */
    private static Integer DEFAULT_PORT = 9000;
    private static Integer DEFAULT_TIMEOUT = 10;
    private static Integer DEFAULT_MAX_THREADS = 4;
    private static String DEFAULT_DOCUMENT_ROOT = "./document-root";

    /**
     * default cli argument descriptions
     */
    private static String DEFAULT_PORT_ARUGMENT_DESCRIPTION =
            "Port to bind the web server to. Can be any unused port in the range 0-65535";
    private static String DEFAULT_TIMEOUT_ARUGMENT_DESCRIPTION =
            "Request timeout (in seconds). Requests which take longer than this will be terminated";
    private static String DEFAULT_MAX_THREADS_ARUGMENT_DESCRIPTION =
            "Maximum number of worker threads that may be spawned to service client requests";
    private static String DEFAULT_HELP_DESCRIPTION = "Display help/usage information";

    public static String getDefaultHelpDescription() {
        return DEFAULT_HELP_DESCRIPTION;
    }

    public static Integer getDefaultMaxThreads() {
        return DEFAULT_MAX_THREADS;
    }

    public static String getDefaultMaxThreadsArugmentDescription() {
        return DEFAULT_MAX_THREADS_ARUGMENT_DESCRIPTION;
    }

    private static String DEFAULT_DOCUMENT_ROOT_ARUGMENT_DESCRIPTION =
            "Path to the document root containing the files the server will serve";

    public static Integer getDefaultPort() {
        return DEFAULT_PORT;
    }

    public static Integer getDefaultTimeout() {
        return DEFAULT_TIMEOUT;
    }

    public static String getDefaultDocumentRoot() {
        return DEFAULT_DOCUMENT_ROOT;
    }

    public static String getDefaultPortArugmentDescription() {
        return DEFAULT_PORT_ARUGMENT_DESCRIPTION;
    }

    public static String getDefaultTimeoutArugmentDescription() {
        return DEFAULT_TIMEOUT_ARUGMENT_DESCRIPTION;
    }

    public static String getDefaultDocumentRootArugmentDescription() {
        return DEFAULT_DOCUMENT_ROOT_ARUGMENT_DESCRIPTION;
    }
}
