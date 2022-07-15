package com.maktab74.base.repsitory;

import com.maktab74.base.domain.BaseDomain;
import com.maktab74.entity.Customer;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface BaseRepository<T extends BaseDomain<ID>, ID> {

    void save(T t) throws IOException;

    T findById(ID id) throws FileNotFoundException;


}
