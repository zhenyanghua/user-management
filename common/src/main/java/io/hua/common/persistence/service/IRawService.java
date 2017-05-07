package io.hua.common.persistence.service;

import io.hua.common.interfaces.IOperations;
import io.hua.common.persistence.model.IEntity;
import org.springframework.data.domain.Page;

public interface IRawService<T extends IEntity> extends IOperations<T> {
    Page<T> findAllPaginationAndSortedRaw(final int page, final int size, final String sortBy, final String sortOrder);
}
