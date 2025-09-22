package com.github.thiagogarbazza.pocs.app.web.pages;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class SimpleSpringAction extends Action {

    @Autowired
    private Environment environment;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/plain");
        try (PrintWriter writer = response.getWriter()) {
            writer.write(LocalDateTime.now().toString());
            writer.write("\n");
            writer.write("Simple example of a Struts Action with Spring integration");
            writer.write("\n\n");
            writer.write("Value of spring.datasource.driver-class-name: " + environment.getProperty("spring.datasource.driver-class-name"));
        }

        return null;
    }
}
