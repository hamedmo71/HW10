package com.maktab74.service;

import com.maktab74.base.service.BaseService;
import com.maktab74.base.service.BaseServiceImpl;
import com.maktab74.entity.HotelsServices;
import com.maktab74.repository.HotelsServicesRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelsServicesService extends BaseServiceImpl<HotelsServices, Long, HotelsServicesRepository>
        implements BaseService<HotelsServices, Long> {
    public HotelsServicesService(HotelsServicesRepository repository) {
        super(repository);
    }

    @Override
    public void save(HotelsServices hotelsServices) {
        try {
            repository.save(hotelsServices);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public HotelsServices findById(Long id) {
        HotelsServices hotelServices=null;
        try {
            hotelServices = repository.findById(id);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return hotelServices;
    }

    public List<HotelsServices> findServiceByNationalCode(String nationalCode){
        List<HotelsServices> serviceByNationalCode=null;
        try {
            serviceByNationalCode = repository.findServiceByNationalCode(nationalCode);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return serviceByNationalCode;
    }
}
