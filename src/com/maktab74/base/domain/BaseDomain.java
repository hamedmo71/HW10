package com.maktab74.base.domain;

public abstract class BaseDomain<ID> {

    private ID id;

    public BaseDomain(ID id) {
        this.id = id;
    }

    public BaseDomain() {
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
