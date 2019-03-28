package com.nordstrom.utility;

import com.beust.jcommander.Parameter;

public class LocalGridOptions {

    @Parameter(names = "-port", description = "Port for local hub server")
    private Integer port;
    
    @Parameter(names = "-shutdown", description = "Shutdown active local Grid")
    private boolean shutdown = false;

    public Integer getPort() {
        return port;
    }

    public boolean doShutdown() {
        return shutdown;
    }
}
