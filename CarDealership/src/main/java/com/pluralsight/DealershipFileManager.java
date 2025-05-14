package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public Dealership getDealership(  ) {
        //read inventory.csv file
        //read the first line which has the dealership data
        //take the line of dealership data and split by | which returns a string array of each piece of dealership data
        //take each column/piece of data and pass it into the constructor of our Dealership to create a specific dealership object
        Dealership dealership = null;

        try {
            FileReader fileReader = new FileReader("data/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            String[] dealerShipFields = line.split("\\|");
             dealership= new Dealership(dealerShipFields[0],dealerShipFields[1], dealerShipFields[2]);

            while ((line = bufferedReader.readLine()) != null) {

                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }




        return dealership;
    }


    public void saveDealership(Dealership dealership){

    }

}
