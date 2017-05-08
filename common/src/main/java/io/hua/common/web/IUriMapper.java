package io.hua.common.web;

import io.hua.common.persistence.model.IEntity;

public interface IUriMapper {
    <T extends IEntity> String getUriBase(final Class<T> clazz);
}
