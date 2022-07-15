package com.maktab74.base.service;

import com.maktab74.base.domain.BaseDomain;
import com.maktab74.base.repsitory.BaseRepository;

public interface BaseService<T extends BaseDomain<ID>, ID > {

    void save(T t);

    T findById(ID id);
}
