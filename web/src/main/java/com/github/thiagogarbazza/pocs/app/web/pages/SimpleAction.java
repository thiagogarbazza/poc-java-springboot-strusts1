package com.github.thiagogarbazza.pocs.app.web.pages;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class SimpleAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/plain");
        try (PrintWriter writer = response.getWriter()) {
            writer.write(LocalDateTime.now().toString());
            writer.write("\n");
            writer.write("Simple example of a Struts Action");
        }

        return null;
    }
}
