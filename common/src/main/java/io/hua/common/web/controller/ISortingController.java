package io.hua.common.web.controller;

import io.hua.common.persistence.model.IEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ISortingController<T extends IEntity> {
    List<T> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder);
    List<T> findAllPaginated(final int page, final int size);
    List<T> findAllSorted(final String sortBy, final String sortOrder);
    List<T> findAll(final HttpServletRequest request);
}
