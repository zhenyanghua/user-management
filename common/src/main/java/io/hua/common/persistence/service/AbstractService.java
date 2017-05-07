package io.hua.common.persistence.service;

import io.hua.common.persistence.model.INameableEntity;

public abstract class AbstractService<T extends INameableEntity> extends AbstractRawService<T> implements IService<T> {
    public AbstractService() {
        super();
    }
}
