package io.hua.um.service.impl;

import io.hua.common.persistence.service.AbstractService;
import io.hua.um.persistence.dao.IPrivilegeJpaDao;
import io.hua.um.persistence.model.Privilege;
import io.hua.um.service.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrivilegeServiceImpl extends AbstractService<Privilege> implements IPrivilegeService {

    @Autowired
    private IPrivilegeJpaDao dao;

    public PrivilegeServiceImpl() {
        super();
    }

    // API

    @Override
    public Privilege findByName(final String name) {
        return getDao().findByName(name);
    }


    // Spring

    @Override
    protected final IPrivilegeJpaDao getDao() {
        return dao;
    }

    @Override
    protected JpaSpecificationExecutor<Privilege> getSpecificationExecutor() {
        return dao;
    }
}
