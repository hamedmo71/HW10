package com.maktab74.entity;

import com.maktab74.base.domain.BaseDomain;
import com.maktab74.enums.HotelServices;

public class HotelsServices extends BaseDomain<Long> {

    private static final int serialVersionUID = 1;

    private HotelServices hotelServices;

    private int cost;

    private String customerNationalCode;


    public HotelsServices(HotelServices hotelServices, int cost, String customerNationalCode) {
        this.hotelServices = hotelServices;
        this.cost = cost;
        this.customerNationalCode = customerNationalCode;
    }


    public HotelsServices() {
    }

    public HotelServices getHotelServices() {
        return hotelServices;
    }

    public void setHotelServices(HotelServices hotelServices) {
        this.hotelServices = hotelServices;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public String getCustomerNationalCode() {
        return customerNationalCode;
    }

    public void setCustomerNationalCode(String customerNationalCode) {
        this.customerNationalCode = customerNationalCode;
    }

    @Override
    public String toString() {
        return "HotelsServices{" +
                "hotelServices=" + hotelServices +
                ", cost=" + cost +
                '}';
    }
}
