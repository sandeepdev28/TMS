package com.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheaterReservationMain {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter the theater layout and reservation absolute File path: ");
        String filePath = reader.next();

        List<String> layoutRows =  new ArrayList<>();
        List<String> reservationRows =  new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String rowString;
            while ((rowString = br.readLine()) != null) {
                if (rowString.trim().length() == 0) {
                    continue;
                }
                try
                {
                    Integer.parseInt(rowString.substring(0,1));
                    layoutRows.add(rowString);
                }
                catch(NumberFormatException nfe)
                {
                    reservationRows.add(rowString);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TheaterManager manager = new TheaterManager(layoutRows);

        for(String request : reservationRows) {
            String[] requestArray= request.split(" ");
            String name = requestArray[0];
            int partySize = Integer.parseInt(requestArray[1]);
            System.out.println(name + " " + manager.reserve(partySize) + "\n");
        }
        reader.close();
    }
}
