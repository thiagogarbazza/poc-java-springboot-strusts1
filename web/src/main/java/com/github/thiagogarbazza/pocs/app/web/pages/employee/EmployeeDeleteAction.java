package com.github.thiagogarbazza.pocs.app.web.pages.employee;

import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeDeleteService;
import com.github.thiagogarbazza.pocs.app.web.utils.RequestParameterUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class EmployeeDeleteAction extends Action {

    @Autowired
    private EmployeeDeleteService employeeDeleteService;

    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final UUID id = RequestParameterUtils.getOptionalUUID(request, "id")
                .orElseThrow(() -> new IllegalArgumentException("Atributo ID não informado"));
        employeeDeleteService.delete(id);

        return mapping.findForward("page-employee-search");
    }
}
