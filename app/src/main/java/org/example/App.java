/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.example;

import java.io.IOException;
import java.util.Scanner;

import org.example.services.UserBookingService;

public class App {
    public static void main(String[] args) {
        System.out.println("Running Train Booking System");
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        UserBookingService userBookingService;
        try{
            userBookingService = new UserBookingService();
        }catch(IOException ex){
            System.out.println("There is something wrong");
            return;
        }
        while(option!=7){
            System.out.println("Select from Menu");
            System.out.println("1.SignUp");
            System.out.println("2.Login");
            System.out.println("3.Fetch Bookings");
            System.out.println("4.Search Trains");
            System.out.println("5.Book a Seat");
            System.out.println("6.Cancel My Booking");
            System.out.println("7.Exit the App")
            option = scanner.nextInt();
            
        }
    }
}
