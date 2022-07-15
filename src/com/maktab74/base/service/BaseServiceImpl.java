package com.maktab74.base.service;

import com.maktab74.base.domain.BaseDomain;
import com.maktab74.base.repsitory.BaseRepository;

public abstract class BaseServiceImpl<T extends BaseDomain<ID>, ID, R extends BaseRepository<T, ID>>
        implements BaseService<T, ID> {

    protected R repository;

    public BaseServiceImpl() {
    }

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }
}
