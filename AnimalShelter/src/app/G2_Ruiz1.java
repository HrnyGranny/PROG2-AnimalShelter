package app;

import Exceptions.NoMoreRequestException;
import Exceptions.NoAnimalFound;
import Exceptions.InvalidRangeCaracter;
import Exceptions.InvalidRangeRequest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class G2_Ruiz1 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        //Creating a boolean variable "Exit" in order to stop the loop and finish the program if the user wants it
        boolean Exit = true;
        //Creating The objects that are going to be used
        FileReader F1 = new FileReader();
        Shelter S1 = new Shelter();
        V_Clinic VC1 = new V_Clinic("Greenpeace", "914441400", 20);
        T_Council TC1 = new T_Council("66559400", 15);
        //We read the txt file
        F1.readTxT("Animales.txt",S1);
        //Creating a switch
        int n = 0;
        do {
            try{n=printMenu();
            switch (n) {
                case 1:
                    
                        System.out.println(S1.ShowAllInfo());
                
                    break;
                case 2:
                    
                        S1.addRequestToAnimal(askForName(), askForType(), askForPhone());
                    
                    break;
                case 3:
                    
                        System.out.println(S1.consultAllRequestOfAnimal(askForName()));
                    
              
                    break;
                case 4:
                    
                        System.out.println("The veterinary expenses are: " + S1.calculateTotalExpenses()+ " €");
                    
               
                    break;
                case 5:
                    
                        System.out.println("The cost of the neutering programme is: " + S1.calculateNeuteringCost(VC1) + " €");
                    
                
                    break;
                case 6:
                    
                        System.out.println("The total food is:"+S1.calculateFoodAllDogs() + " Kg");
                    
                    break;
                case 7:
                    
                        System.out.println("The funding provided by the Town Council is: " + S1.calculateCouncilPay(TC1) + " €");
                    
                    break;
                case 8:
                   
                        Exit = false;
                        System.out.println("Thank you for use this manager\nHope to see you soon");
                    
                    break;
            }
            }catch(InputMismatchException e){System.out.println("\nYou can't type that, please try again"); sc.reset(); sc.next();}catch(InvalidRangeCaracter e){System.out.println("\nYou have to type a number between 1 and 8, please try again");}catch(NoAnimalFound e){System.out.println("\nWe can't find the Animal");}catch(NoMoreRequestException e){System.out.println("\nYou cant enter more requests");}catch(InvalidRangeRequest e){System.out.println("\nYou can only choose between 0-1. Please do the request again");}
        } while (Exit);
        sc.close();
    }

    private static int printMenu()throws InputMismatchException, InvalidRangeCaracter{
        int option;
        System.out.println("");
        System.out.println("-------------------------------------");
        System.out.println("Welcome to my Animal Shelter manager.");
        System.out.println("-------------------------------------");
        System.out.println("");
        System.out.println("**************OPTIONS****************");
        System.out.println("");
        System.out.println("1.Show all information about Animals");
        System.out.println("2.Make a request");
        System.out.println("3.Consult the list of requests");
        System.out.println("4.Calculate the veterinary expenses");
        System.out.println("5.Calculate the cost of the neutering programme");
        System.out.println("6.Food for all adult dog");
        System.out.println("7.Calculate the funding provided by the Town Council");
        System.out.println("8.Exit the manager");
        System.out.println("");
        System.out.println("Please choose an option");
        option = sc.nextInt();
        
        if(option<1 || option>8){
            throw new InvalidRangeCaracter();
        }

        return option;
    }

    private static String askForName()throws InputMismatchException{
        System.out.println("Please introduce the Name of the Animal:");
        sc.nextLine();
        return sc.nextLine();
    }

    private static int askForType()throws InputMismatchException, InvalidRangeRequest{
        int opt;
        System.out.println("Please tell me the Type of Request(0-fostering or 1-adoption");
        opt = sc.nextInt();
        if(opt<0 || opt>1){
            throw new InvalidRangeRequest();
        }
        return opt;
    }

    private static String askForPhone()throws InputMismatchException{
        System.out.println("Please introduce the Phone to the request:");
        sc.nextLine();
        return sc.nextLine();
    }
        
}
