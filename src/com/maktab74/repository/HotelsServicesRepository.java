package com.maktab74.repository;

import com.maktab74.base.repsitory.BaseRepository;
import com.maktab74.entity.Customer;
import com.maktab74.entity.HotelsServices;
import com.maktab74.enums.Gender;
import com.maktab74.enums.HotelServices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelsServicesRepository implements BaseRepository<HotelsServices,Long> {

    protected File serviceFile = new File(
            "C:\\Users\\hamed\\Desktop\\HW10\\HotelReservationSystem\\src\\com\\maktab74\\hotelservices.txt");

    @Override
    public void save(HotelsServices hotelsServices) throws IOException {
        FileWriter writer=new FileWriter(serviceFile,true);

        Scanner scanner = new Scanner(serviceFile);
        long id = 0;
        while (scanner.hasNextLine()) {
            id = Long.parseLong(scanner.nextLine().split("; ")[0]);
        }

        writer.write(String.valueOf(++id) + "; " + hotelsServices.getHotelServices() +
                "; " + hotelsServices.getCost() + "; " + hotelsServices.getCustomerNationalCode() + "\n");
        writer.close();
    }

    @Override
    public HotelsServices findById(Long id) throws FileNotFoundException {
        HotelsServices hotelsServices=null;
        Scanner scanner=new Scanner(serviceFile);
        while (scanner.hasNext()){
            String[] serviceInfo=scanner.nextLine().split("; ");
            if (Long.parseLong(serviceInfo[0])==id){
                hotelsServices=new HotelsServices(HotelServices.valueOf(serviceInfo[1]),
                        Integer.parseInt(serviceInfo[2]),
                        serviceInfo[3]);
            }
        }

        return hotelsServices;
    }

    public List<HotelsServices> findServiceByNationalCode(String nationalCode) throws FileNotFoundException {
        List<HotelsServices> hotelsServicesList=new ArrayList<>();
        HotelsServices hotelsServices=new HotelsServices();
        Scanner scanner=new Scanner(serviceFile);
        while (scanner.hasNextLine()){
            String[] service=scanner.nextLine().split("; ");
            if (service[3].equals(nationalCode)){
                hotelsServices=new HotelsServices(HotelServices.valueOf(service[1]),
                        Integer.parseInt(service[2]),service[3]);
                hotelsServicesList.add(hotelsServices);
            }
        }
        return hotelsServicesList;
    }
}
