package com.freshtuna.tuna.impls;

import com.freshtuna.tuna.CommandLineOptions;
import com.freshtuna.tuna.RequestHandler;
import com.freshtuna.tuna.WebServer;

import java.util.List;

public class WebServerImpl implements WebServer {
    private final Integer PORT;
    private final Integer TIMEOUT;
    private final Integer MAX_THREADS;
    private final List<RequestHandler> requestHandlers;

    /**
     * private constructor
     * @param PORT
     * @param TIMEOUT
     * @param MAX_THREADS
     * @param requestHandlers
     */
    private WebServerImpl(Integer PORT, Integer TIMEOUT, Integer MAX_THREADS, List<RequestHandler> requestHandlers) {
        this.PORT = PORT;
        this.TIMEOUT = TIMEOUT;
        this.MAX_THREADS = MAX_THREADS;
        this.requestHandlers = requestHandlers;
    }

    public static WebServer of(CommandLineOptions options, List<RequestHandler> requestHandlers) {
        return null;
    }

    @Override
    public void run() {
        
    }
}
