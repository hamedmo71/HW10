package com.maktab74.util;

import com.maktab74.repository.CustomerRepository;
import com.maktab74.repository.HotelsServicesRepository;
import com.maktab74.service.CustomerService;
import com.maktab74.service.HotelsServicesService;

import java.util.Scanner;

public class ApplicationContext {
    public static CustomerService costumerService =
            new CustomerService(new CustomerRepository());

    public static HotelsServicesService hotelsServicesService =
            new HotelsServicesService(new HotelsServicesRepository());

    private static Scanner numberScanner;
    private static Scanner stringScanner;

    public static Scanner getNumberScanner() {
        if (numberScanner==null){
            numberScanner=new Scanner(System.in);
        }
        return numberScanner;
    }

    public static Scanner getStringScanner() {
        if (stringScanner==null){
            stringScanner=new Scanner(System.in);
        }
        return stringScanner;
    }
}
