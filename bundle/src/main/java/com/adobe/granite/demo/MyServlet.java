package com.adobe.granite.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardContextSelect;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardServletPattern;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@HttpWhiteboardServletPattern("/myservlet") // overridden via configuration
@HttpWhiteboardContextSelect("(" + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME +"=my-context)")
@Component(service = Servlet.class, scope = ServiceScope.PROTOTYPE)
@Designate(ocd=MyServlet.Config.class)
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String bgColor;

    @Activate
    protected void activate(Config config) {
        bgColor = config.background();

        System.out.println("*** Activated: " + config.background());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType("text/html");
        writer.write("<body style=\"background-color:" + bgColor +
            ";\"><img src=\"www/trees.png\" style=\"border: none; width: 100%;\"></img></body>");
    }

    @ObjectClassDefinition(name="Site settings")
    public static @interface Config {
        @AttributeDefinition(name="Background colour")
        String background();
    }
}
