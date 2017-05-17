package io.hua.um.service.impl;

import io.hua.common.persistence.service.AbstractService;
import io.hua.um.persistence.dao.IRoleJpaDao;
import io.hua.um.persistence.model.Role;
import io.hua.um.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements IRoleService {

    @Autowired
    private IRoleJpaDao dao;

    public RoleServiceImpl() {
        super();
    }

    // API

    @Override
    public Role findByName(final String name) {
        return getDao().findByName(name);
    }

    @Override
    public Role create(final Role entity) {
        return super.create(entity);
    }

    // Spring

    @Override
    protected final IRoleJpaDao getDao() {
        return dao;
    }

    @Override
    protected JpaSpecificationExecutor<Role> getSpecificationExecutor() {
        return dao;
    }
}
