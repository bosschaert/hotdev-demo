package com.adobe.granite.demo;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.http.context.ServletContextHelper;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardContext;

@Component(service = ServletContextHelper.class, scope = ServiceScope.BUNDLE)
@HttpWhiteboardContext(name = "my-context", path = "/content/myapp")
public class MyServletContextHelper extends ServletContextHelper {
    @Activate
    public MyServletContextHelper(BundleContext bc) {
        // This is needed to get the SCH to serve resources from the current bundle
        super(bc.getBundle());
    }
}