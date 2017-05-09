package io.hua.common.web.controller;

import io.hua.common.persistence.model.IEntity;
import io.hua.common.web.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController<T extends IEntity> extends AbstractReadOnlyController<T> {

    @Autowired
    public AbstractController(Class<T> clazzToSet) {
        super(clazzToSet);
    }

    protected final void createInternal(final T resource) {
        RestPreconditions.checkRequestElementNotNull(resource);
        RestPreconditions.checkRequestState(resource.getId() == null);

        getService().create(resource);
    }

    protected final void updateInternal(final long id, final T resource) {
        RestPreconditions.checkRequestElementNotNull(resource);
        RestPreconditions.checkRequestElementNotNull(resource.getId());
        RestPreconditions.checkRequestState(resource.getId() == id);
        RestPreconditions.checkNotNull(getService().findOne(resource.getId()));

        getService().update(resource);
    }

    protected final void deleteInternal(final long id) {
        getService().delete(id);
    }
}
