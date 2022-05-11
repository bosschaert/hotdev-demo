# hotdev-demo

This demo has a content package which contains an OSGi bundle that renders a sample
website page. The location of the website page can be controlled via an OSGi configuration.

## Building

To build, execute:

    mvn clean install

## Running

Deploy the content package: `all/target/hotdev.demo.ui.apps.all-1.0.0-SNAPSHOT.zip`

This deploys a bundle in AEM called `com.adobe.granite.hotdev.demo`, which registers a servlet that can be accessed via `http://host:port/content/myapp/ms`.

Then, to control the location of the servlet, change the following configuration

```
{
  "com.adobe.granite.demo.MyServlet": {
    "osgi.http.whiteboard.servlet.pattern": "/xyz"
  }
}
```

After this, the servlet can be accessed from `http://host:port/content/myapp/xyz`.
