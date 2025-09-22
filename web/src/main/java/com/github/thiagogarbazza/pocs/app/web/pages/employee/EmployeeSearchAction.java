package com.github.thiagogarbazza.pocs.app.web.pages.employee;

import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchFilterDTO;
import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchResultDTO;
import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchService;
import com.github.thiagogarbazza.pocs.app.web.utils.RequestParameterUtils;
import org.apache.struts.action.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeSearchAction extends Action {

    @Autowired
    private EmployeeSearchService employeeSearchService;

    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final EmployeeSearchFilterDTO searchFilter = createSearchFilter(request);
        setForm((DynaActionForm) form, searchFilter);

        return mapping.findForward("page-employee-search");
    }

    private void setForm(final DynaActionForm form, EmployeeSearchFilterDTO searchFilter) {
        final Page<EmployeeSearchResultDTO> itens = employeeSearchService.search(searchFilter);

        form.set("itens", itens.getContent());
    }

    private static EmployeeSearchFilterDTO createSearchFilter(final HttpServletRequest request) {
        return EmployeeSearchFilterDTO.builder()
                .pn(RequestParameterUtils.getInteger(request, "pn"))
                .ps(RequestParameterUtils.getInteger(request, "ps"))
                .sort(RequestParameterUtils.getStrings(request, "sort"))
                .build();
    }
}
