
package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

// import org.example.entitites.Train;
import org.example.entitites.User;
import org.example.services.UserBookingService;
import org.example.utils.UserServiceUtil;

public class App {
    public static void main(String[] args) {
        System.out.println("Running Train Booking System");
        
        int option = 0;
        UserBookingService userBookingService;
        try {
            userBookingService = new UserBookingService();
        } catch (IOException ex) {
            System.out.println(ex);
            return;
        }
        while (option != 7) {
            System.out.println("Select from Menu");
            System.out.println("1.SignUp");
            System.out.println("2.Login");
            System.out.println("3.Fetch Bookings");
            System.out.println("4.Search Trains");
            System.out.println("5.Book a Seat");
            System.out.println("6.Cancel My Booking");
            System.out.println("7.Exit the App");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            // Train trainSelectedForBooking = new Train();
            switch (option) {
                case 1:
                    System.out.println("Name :");
                    String nameToSignUp = scanner.next();
                    System.out.println("Password :");
                    String passwordToSignUp = scanner.next();
                    User userToSignUp = new User(nameToSignUp, passwordToSignUp, UserServiceUtil.hashPassword(passwordToSignUp),
                            new ArrayList<>(), UUID.randomUUID().toString());
                    userBookingService.signUp(userToSignUp);
                    break;

                default:
                    break;
            }
            scanner.close();
        }
        
    }
}
