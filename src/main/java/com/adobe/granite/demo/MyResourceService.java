package com.adobe.granite.demo;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardContextSelect;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardResource;

@Component(service = MyResourceService.class)
@HttpWhiteboardContextSelect("(" + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME +"=my-context)")
@HttpWhiteboardResource(pattern = "/www/*", prefix = "/www")
public class MyResourceService {}
