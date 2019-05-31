package com.nordstrom.utility;

import java.nio.file.Path;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.PathConverter;
import com.nordstrom.automation.selenium.AbstractSeleniumConfig.SeleniumSettings;

public class LocalGridOptions {

    @Parameter(names = "-port", description = "Port for local hub server")
    private Integer port;
    
    @Parameter(names = "-shutdown", description = "Shutdown active local Grid")
    private boolean shutdown = false;

    @Parameter(names = "-workingDir", description = "Working directory for servers", converter = PathConverter.class)
    private Path workingDir;

    @Parameter(names = "-logsFolder", description = "Server output logs folder", converter = PathConverter.class)
    private Path logsFolder;

    @Parameter(names = "-noRedirect", description = "Disable server output redirection")
    private Boolean noRedirect;

    @Parameter(names = { "-help", "-?" }, description = "Display supported options and exit", help = true)
    private boolean help = false;
    
    public Integer getPort() {
        return port;
    }

    public boolean doShutdown() {
        return shutdown;
    }
    
    public Path getWorkingDir() {
        return workingDir;
    }
    
    public Path getLogsFolder() {
        return logsFolder;
    }
    
    public boolean noRedirect() {
        return (noRedirect != null) ? noRedirect : false;
    }
    
    public void setHelp() {
        help = true;
    }
    
    public boolean isHelp() {
        return help;
    }
    
    public void injectSettings() {
        if (port != null) {
            System.setProperty(SeleniumSettings.HUB_PORT.key(), port.toString());
        }
        if (workingDir != null) {
            System.setProperty(SeleniumSettings.GRID_WORKING_DIR.key(), workingDir.toString());
        }
        if (logsFolder != null) {
            System.setProperty(SeleniumSettings.GRID_LOGS_FOLDER.key(), logsFolder.toString());
        }
        if (noRedirect != null) {
            System.setProperty(SeleniumSettings.GRID_NO_REDIRECT.key(), noRedirect.toString());
        }
    }
}
