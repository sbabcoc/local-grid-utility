# local-grid-utility

This utility enables you to launch and shutdown a Selenium 2 Grid instance that manages five `HtmlUnit` sessions.

## Launch Local Grid

In one step, **`local-grid-utility`** launches a Selenium Grid server and a single node that supplies `HtmlUnit` sessions:

```bash
java -jar local-grid-utility.jar
```

### Example

The following is the output from launching a local Grid collection:

> $ java -jar local-grid-utility.jar  
> 15:21:04.063 [main] INFO  org.eclipse.jetty.util.log - Logging initialized @5864ms  
> http://10.18.32.105:4444/wd/hub

Note that the last line of the output provides the URL from which to request remote driver sessions.

## Shut Down Local Grid

To shut down the local Grid collection, specify the `-shutdown` option:

```bash
java -jar local-grid-utility.jar -shutdown
```

This command shuts down the Grid hub and all attached nodes.

## Command Line Options

* `-port` : specify port for local hub server (default = 4444)
* `-shutdown` : shut down active local Grid collection

## Notes

The port used by the node server that supplies **`HtmlUnit`** sessions is auto-selected via the [PortProber.findFreePort()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/net/PortProber.html#findFreePort--) method of the **`selenium-remote-driver`** library.

**`local-grid-utility`** redirects the output of the hub and node servers to log files in a `logs` folder under the current working directory. Each log file contains the output from a single launch of its associated server. Log file names are auto-incremented to avoid overwriting or appending to the output of previous launches.

* `grid-hub*.log` for hub server output
* `grid-node*.log` for node server output
