package com.nordstrom.utility;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeoutException;

import org.apache.commons.configuration2.ex.ConfigurationException;

import com.beust.jcommander.JCommander;
import com.nordstrom.automation.selenium.AbstractSeleniumConfig.SeleniumSettings;
import com.nordstrom.automation.selenium.SeleniumConfig;
import com.nordstrom.automation.selenium.core.GridUtility;
import com.nordstrom.automation.selenium.core.SeleniumGrid;

public class Main {
    public static void main(String... args) throws InterruptedException, ConfigurationException, IOException, TimeoutException {
        LocalGridOptions opts = new LocalGridOptions();
        new JCommander(opts, args);
        
        if (opts.getPort() != null) {
            System.setProperty(SeleniumSettings.HUB_PORT.key(), opts.getPort().toString());
        }
        
        SeleniumConfig config = new SeleniumConfig();
        
        URL hubUrl = config.getHubUrl();
        boolean isActive = GridUtility.isHubActive(hubUrl);
        
        if (opts.doShutdown() && isActive) {
            SeleniumGrid.create(config, hubUrl).shutdown(true);
        } else {
            if (!isActive) {
                SeleniumGrid.create(config, hubUrl);
            }
            System.out.println(hubUrl);
        }
    }
}
