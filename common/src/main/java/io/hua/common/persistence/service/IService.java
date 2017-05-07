package io.hua.common.persistence.service;

import io.hua.common.interfaces.IByNameApi;
import io.hua.common.persistence.model.INameableEntity;

public interface IService<T extends INameableEntity> extends IRawService<T>, IByNameApi<T> {
}
