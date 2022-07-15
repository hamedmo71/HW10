package com.maktab74.main;

import com.maktab74.entity.Customer;
import com.maktab74.entity.HotelsServices;
import com.maktab74.enums.Gender;
import com.maktab74.enums.HotelServices;
import com.maktab74.repository.CustomerRepository;
import com.maktab74.repository.HotelsServicesRepository;
import com.maktab74.util.ApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) throws IOException {



        Boolean flag = true;

        while (flag) {
            System.out.println("Choose from following options:\n" +
                    "1. Insert guest\n" +
                    "2. Choose service\n" +
                    "3. Show bill\n" +
                    "4. Exit");
            int selectedNumber = ApplicationContext.getNumberScanner().nextInt();
            switch (selectedNumber) {
                case 1:
                    insertGuest();
                    break;
                case 2:
                    insertService();
                    break;
                case 3:
                    showBill();
                    break;
                case 4:
                    flag=false;
                    break;
            }
        }
    }

    private static void showBill() {
        int totalPrice=0;
        System.out.print("Enter national code: ");
        String nationalCode=ApplicationContext.getStringScanner().nextLine();
        List<HotelsServices> serviceByNationalCode =
                ApplicationContext.hotelsServicesService.findServiceByNationalCode(nationalCode);
        if (serviceByNationalCode!=null){
            for (HotelsServices h:serviceByNationalCode) {
                totalPrice+=h.getCost();
                System.out.println(h);
            }
            System.out.println("==================\n" +
                    "Total= " +
                    totalPrice);

        }else System.out.println("There is no bill for this ntional code.");
    }

    private static void insertService() throws FileNotFoundException {

        File file=new File(
                "C:\\Users\\hamed\\Desktop\\HW10\\HotelReservationSystem\\src\\com\\maktab74\\service_price.txt");

        Boolean flag = true;

        List<HotelServices> hotelServices = new ArrayList<>();

        while (flag) {

            System.out.println("choose service:\n" +
                    "1. Room\n" +
                    "2. Pool\n" +
                    "3. Restaurant\n" +
                    "4. Conference Hall\n" +
                    "5. Cafe\n" +
                    "6. back");
            int selectedNum = ApplicationContext.getNumberScanner().nextInt();
            switch (selectedNum) {
                case 1:
                    hotelServices.add(HotelServices.Room);
                    break;
                case 2:
                    hotelServices.add(HotelServices.Pool);
                    break;
                case 3:
                    hotelServices.add(HotelServices.Restaurant);
                    break;
                case 4:
                    hotelServices.add(HotelServices.ConferenceHall);
                    break;
                case 5:
                    hotelServices.add(HotelServices.cafe);
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }


        System.out.print("enter Customer national code: ");
        String nationalCode = ApplicationContext.getStringScanner().nextLine();


        for (HotelServices h : hotelServices) {

            int price=0;
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                String[] str=scanner.nextLine().split(", ");
                if (str[0].equals(h.toString()))
                price=Integer.parseInt(str[1]);
            }

            HotelsServices hotelsServices = new HotelsServices(h, price, nationalCode);
            ApplicationContext.hotelsServicesService.save(hotelsServices);
        }
    }


    private static void insertGuest() {
        System.out.println("Enter first name:");
        String firstName = ApplicationContext.getStringScanner().next();
        System.out.println("Enter last name:");
        String lastName = ApplicationContext.getStringScanner().next();
        System.out.println("Enter national code:");
        String nationalCode = ApplicationContext.getStringScanner().next();
        System.out.println("Enter Gender:\n" +
                "1. Male\n" +
                "2. Female");
        Gender gender = null;
        try {
            int nextInt = ApplicationContext.getNumberScanner().nextInt();
            if (nextInt == 1) {
                gender = Gender.Male;
            } else if (nextInt == 2) {
                gender = Gender.Female;
            } else throw new InputMismatchException();

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        Customer customer = new Customer(firstName, lastName, nationalCode, gender);
        ApplicationContext.costumerService.save(customer);
    }
}
