package app;

import Exceptions.*;
import Interfaces.IData;

public class Shelter {
    private Animal [] Animalarray = new Animal [15];
    //Constructor

    public Shelter(){

    }

    //Getter

    public Animal [] getArrayAnimal(){
        return Animalarray;
    }

    //Search for an Animal

    public Animal searchAnimal(String Name)throws NoAnimalFound{
        return getArrayAnimal()[lookForAnimal(Name)];
    }

    //To know which is the position of the animal depending on his name
    
    private int lookForAnimal(String Name)throws NoAnimalFound{
        int counter=0;
        for(int i=0; i<getArrayAnimal().length;i++){
            if((getArrayAnimal()[i].getName()).equalsIgnoreCase(Name)){
                counter = i;
            }
        }
        if (counter == 0){
            throw new NoAnimalFound();
        }
        return counter;
    }

    //Method to show all the toString
    //We initialize the String all with "" because I am not allowed to let it with a null value
    
    public String ShowAllInfo(){
        
        String all="";
        for(int i=0;i<getArrayAnimal().length;i++){
            if(getArrayAnimal()[i] == null){
                all += "";
            }else{
                all += getArrayAnimal()[i].toString();
            }
        }
        if(all.equals("")){
            all="There are no Animals in your file";
        }
        return all;
    }

    //We create this method to add new requests

    public void addRequestToAnimal(String Name, int Type, String Phone)throws NoAnimalFound, NoMoreRequestException{
        
        searchAnimal(Name).addRequest(Type, Phone);


    }

    //We create this method in order to fill our Animal Array using the File Reader class
    
    public void addAnimal(Animal animal,int position){
        getArrayAnimal()[position]=animal;
    }

    //Method which create a String with all the request depending the animal name

    public String consultAllRequestOfAnimal(String Name)throws NoAnimalFound{
        String info = "";

        info = searchAnimal(Name).checkAdoption() + searchAnimal(Name).checkFostering();
      

        return info;
    }

    //Total veterinary expenses (No the neutering expenses)

    public int calculateTotalExpenses(){
        int total=0;
        for(int i=0; i<getArrayAnimal().length; i++){
            total += getArrayAnimal()[i].getPricePay();
        }
        return total;
    }

    //Neutering expenses 

    public int calculateNeuteringCost(V_Clinic VC1){
        int price = 0;
        
        for(int i=0; i<getArrayAnimal().length; i++){
            if(getArrayAnimal()[i] instanceof Cat){
                if(((Cat) getArrayAnimal()[i]).getNeutured()== false && getArrayAnimal()[i].getSex().equalsIgnoreCase("h")){
                    price += VC1.getCost();
                    System.out.println(price);
                }
            }
        
        }

        return price;
    }

    //Council pay 

    public int calculateCouncilPay(T_Council TC1){
        return (TC1.getPay()*getArrayAnimal().length)  + IData.Fixed_Amount;

    }

    //Dogs food for a week

    public double calculateFoodAllDogs() throws NoAnimalFound{
        double food = 0.0;

        for(int i=0;i<getArrayAnimal().length;i++ ){
            if(getArrayAnimal()[i] instanceof Dog){
                if(getArrayAnimal()[i].getAge()<2){

                    food += 0.0;

                }else{
                    if(((Dog) getArrayAnimal()[i]).getWeight() <= 15) {
       
                       food += IData.SmallDogFood*7;
       
                      }else if(((Dog)getArrayAnimal()[i]).getWeight()>=25){
       
                       food += ((Dog)getArrayAnimal()[i]).getWeight() * 0.015 * 7;
       
                      }else{
       
                       food += IData.MediumDogFood*7;
                    }

                }

            }
           
        }

        return food;

    }
    
}
