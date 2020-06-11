package carsdata;

import carsconnection.carsConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CarsData {

    public static void main(String[] args) {
        carsConnection cdb = new carsConnection();
        CarDB carData = new CarDB();
        Scanner input = new Scanner(System.in);
        cdb.toString(); //Connect to "Cars" database
        
        int       modelNo =   0;
        String  modelName =  "";
        double modelPrice = 0.0;
        int modelQuantity =   0;
        
        int choice = 0;
        
        while(choice!=6){
            System.out.format("----------------------\n"
                        + "|1.Insert data.      |\n"
                        + "|2.Update data.      |\n"
                        + "|3.Delete data.      |\n"
                        + "|4.Select data by id.|\n"
                        + "|5.Select all data.  |\n"
                        + "|6.Exit.             |\n"
                        + "----------------------\n\n"
                        + "Choose a number: ");
        
            choice = input.nextInt();
            System.out.println("");
            
        switch(choice)
        {
            case 1: 
                System.out.print("Enter model no.: ");
                modelNo = input.nextInt();
                System.out.print("Enter model name: ");
                modelName = input.nextLine();
                System.out.print("Enter model price: ");
                modelPrice = input.nextDouble();
                System.out.print("Enter model quantity: ");
                modelQuantity = input.nextInt();
                carData.insertData(modelNo, modelName, modelPrice, modelQuantity);
                break;
                
            case 2: 
                System.out.print("Enter model no.:");
                modelNo = input.nextInt();
                System.out.print("Enter model price:");
                modelPrice = input.nextDouble();
                System.out.print("Enter model quantity:");
                modelQuantity = input.nextInt();
                carData.updateData(modelNo, modelPrice, modelQuantity);
                break;
                
            case 3:
                System.out.print("Enter model no.:");
                modelNo = input.nextInt();
                carData.deleteData(modelNo);
                break;
            
            case 4:
                System.out.print("Enter model no.:");
                modelNo = input.nextInt();
                carData.selectById(modelNo);
                break;
                
            case 5:
                carData.selectAll();
                break;
                
            case 6:
                break;
                
        }
        }
        
        
        
    }
    
}
