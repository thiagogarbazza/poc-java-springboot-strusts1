package com.github.thiagogarbazza.pocs.app.web.pages.employee;

import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeDetailService;
import com.github.thiagogarbazza.pocs.app.web.utils.RequestParameterUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class EmployeeDetailAction extends Action {

    @Autowired
    private EmployeeDetailService employeeDetailService;

    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final UUID id = RequestParameterUtils.getOptionalUUID(request, "id")
                .orElseThrow(() -> new IllegalArgumentException("Atributo ID não informado"));
        final var item = employeeDetailService.detail(id);

        request.setAttribute("item", item);

        return mapping.findForward("page-employee-detail");
    }
}
