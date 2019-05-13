# local-grid-utility

This utility enables you to launch and shutdown a Selenium 2 Grid instance that manages five `HtmlUnit` sessions.

## Launch Local Grid

In one step, **`local-grid-utility`** launches a Selenium Grid server and a single node that supplies `HtmlUnit` sessions:

```bash
java -jar local-grid-utility.jar
```

### Example

The following is the output 

> $ java -jar local-grid-utility.jar  
> 14:40:17.122 [main] DEBUG com.nordstrom.automation.selenium.SeleniumConfig - hubConfig = C:\github\local-grid-utility\target\hubConfig.json  
> 14:40:18.955 [main] DEBUG com.nordstrom.automation.selenium.SeleniumConfig - nodeConfig = C:\github\local-grid-utility\target\nodeConfig-s2.json  
> 14:40:19.059 [main] DEBUG org.eclipse.jetty.util.log - Logging to Logger[org.eclipse.jetty.util.log] via org.eclipse.jetty.util.log.Slf4jLog  
> 14:40:19.063 [main] INFO org.eclipse.jetty.util.log - Logging initialized @5359ms  
> http://10.11.210.230:4444/wd/hub

