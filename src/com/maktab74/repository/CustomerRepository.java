package com.maktab74.repository;

import com.maktab74.base.repsitory.BaseRepository;
import com.maktab74.entity.Customer;
import com.maktab74.enums.Gender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomerRepository implements BaseRepository<Customer,Long> {
    protected File file = new File(
            "C:\\Users\\hamed\\Desktop\\HW10\\HotelReservationSystem\\src\\com\\maktab74\\customer.txt");

    @Override
    public void save(Customer customer) throws IOException {
        Scanner scanner = new Scanner(file);
        long id = 0;
        while (scanner.hasNextLine()) {
            id =Long.parseLong(scanner.nextLine().split("; ")[0]);
        }

        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(String.valueOf(++id) + "; " + customer.getFirstName() +
                " " + customer.getLastName() + "; " + customer.getNationalCode() + "; "
                + customer.getGender()+"\n");
        fileWriter.close();

    }

    @Override
    public Customer findById(Long id) throws FileNotFoundException {
        Customer customer=null;
        Scanner scanner=new Scanner(file);
        while (scanner.hasNext()){
            String[] customerInfo=scanner.nextLine().split("; ");
            if (Long.parseLong(customerInfo[0])==id){
                customer=new Customer(customerInfo[1],customerInfo[2],
                        customerInfo[3], Gender.valueOf(customerInfo[4]));
            }
        }
        return customer;
    }
}
