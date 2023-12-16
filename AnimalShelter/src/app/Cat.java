package app;

import Interfaces.IData;

public class Cat extends Animal {
    private Boolean Neutured;
    
    //Constructor

    public Cat(String Name,String Sex, int Age, Boolean Behaviour, Boolean Patronage, Boolean Neutured ){
        super(Name,Sex, Age, Behaviour, Patronage);
        this.Neutured = Neutured;

    }

    //Getters
    //We put it private because we only use it in this class
    public Boolean getNeutured(){
        return this.Neutured;

    }

    //The override price to pay

    public int getPricePay(){
        int price;
        if (getNeutured()==false && getSex().equalsIgnoreCase("h") && getPatronage()==false){
            price = IData.Neutering * 12;
        }else{
            price = 0;
        }

        return price;

    }


    //toString
    public String toString() {
        return "\nThe Name is: " + getName() +"\nThe Sex is: " + getSex() + "\nThe Age is: " + getAge() + "\nGood Behaviour?: " + getBehaviour()+"\nHas Patronage?: "+getPatronage()+"\nIs Neutured?: "+getNeutured()+"\n";
    }







}