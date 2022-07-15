package com.maktab74.entity;

import com.maktab74.enums.Gender;
import com.maktab74.base.domain.BaseDomain;

import java.io.Serializable;

public class Customer extends BaseDomain<Long> {

    private static final int serialVersionUID = 1;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private Gender gender;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String nationalCode, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", gender=" + gender +
                '}';
    }
}
