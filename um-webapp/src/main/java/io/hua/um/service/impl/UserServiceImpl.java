package io.hua.um.service.impl;

import io.hua.common.persistence.service.AbstractService;
import io.hua.um.persistence.dao.IUserJpaDao;
import io.hua.um.persistence.model.User;
import io.hua.um.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {
    @Autowired
    private IUserJpaDao dao;

    public UserServiceImpl() {
        super();
    }

    // API

    @Override
    public User findByName(final String name) {
        return getDao().findByName(name);
    }

    // Spring

    @Override
    protected IUserJpaDao getDao() {
        return dao;
    }

    @Override
    protected JpaSpecificationExecutor<User> getSpecificationExecutor() {
        return dao;
    }
}
