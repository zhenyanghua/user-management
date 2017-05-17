package io.hua.um.web.controller;

import io.hua.common.persistence.service.IRawService;
import io.hua.common.util.QueryConstants;
import io.hua.common.web.controller.AbstractController;
import io.hua.common.web.controller.ISortingController;
import io.hua.um.persistence.model.Privilege;
import io.hua.um.service.IPrivilegeService;
import io.hua.um.service.IRoleService;
import io.hua.um.util.UmMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = UmMapping.PRIVILEGES)
public class PrivilegeController extends AbstractController<Privilege> implements ISortingController<Privilege> {

    @Autowired
    private IPrivilegeService privilegeService;

    public PrivilegeController() {
        super(Privilege.class);
    }

    // API

    @Override
    @RequestMapping(
        params = {QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY, QueryConstants.SORT_ORDER},
        method = RequestMethod.GET
    )
    @ResponseBody
    public List<Privilege> findAllPaginatedAndSorted(
        @RequestParam(value = QueryConstants.PAGE) final int page,
        @RequestParam(value = QueryConstants.SIZE) final int size,
        @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
        @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        return findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
    }

    @Override
    @RequestMapping(
        params = {QueryConstants.PAGE, QueryConstants.SIZE},
        method = RequestMethod.GET
    )
    @ResponseBody
    public List<Privilege> findAllPaginated(final int page, final int size) {
        return findAllPaginatedInternal(page, size);
    }

    @Override
    @RequestMapping(
        params = {QueryConstants.SORT_BY, QueryConstants.SORT_ORDER},
        method = RequestMethod.GET
    )
    @ResponseBody
    public List<Privilege> findAllSorted(final String sortBy, final String sortOrder) {
        return findAllSortedInternal(sortBy, sortOrder);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Privilege> findAll(final HttpServletRequest request) {
        return findAllInternal(request);
    }

    // find - one
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Privilege findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    // create
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Privilege resource) {
        createInternal(resource);
    }

    // update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody final Privilege resource) {
        updateInternal(id, resource);
    }

    // delete
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        deleteInternal(id);
    }

    // Spring

    @Override
    protected IPrivilegeService getService() {
        return privilegeService;
    }
}
