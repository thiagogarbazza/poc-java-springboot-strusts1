package com.github.thiagogarbazza.pocs.app.web.configuration;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CommonsLog
public class StrutsExceptionHandler extends ExceptionHandler {

    @Override
    public ActionForward execute(Exception ex, ExceptionConfig ae, ActionMapping mapping, ActionForm formInstance, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        return super.execute(ex, ae, mapping, formInstance, request, response);
    }
}
