package app;

import Interfaces.IData;

public class Dog extends Animal{

    private String Breed;
    private int Weight;
    private Boolean PDB;
    private Boolean Lishmania;

    //Constructor

    public Dog (String Name,String Sex, int Age, Boolean Behaviour, Boolean Patronage, String Breed, int Weight, Boolean PDB, Boolean Lishmania) {
        super(Name,Sex, Age, Behaviour, Patronage);
        this.Breed = Breed;
        this.Weight = Weight;
        this.PDB = PDB;
        this.Lishmania = Lishmania;

    }

    //Getters
    //We put it private because we only use it in this class
    private String getBreed(){
        return this.Breed;
    }

    public int  getWeight() {
        return this.Weight;
    }

    private Boolean getPDB(){
        return this.PDB;
    }

    private Boolean getLishmania(){
        return this.Lishmania;
    }
    
    //The override price to pay

    public int getPricePay(){
        int price=0;
        if(getPatronage()==false){
            if(getPDB()==true && getLishmania()==true){
                price = price + IData.PDB_Sedate + IData.Rabie + IData.Leishmania*12;
            }else if(getPDB()==true && getLishmania()==false){
                price = price + IData.PDB_Sedate + IData.Rabie;
            }else if(getPDB()==false && getLishmania()==true){
                price = price + IData.Rabie + IData.Leishmania*12;
            }else{
                 price = price + IData.Rabie;

            }

        }else{
            price = 0;
        }
    

        

        return price;

    }
    
    //toString
    
    public String toString() {
        return "\nThe Name is: " + getName() +"\nThe Sex is: " + getSex() + "\nThe Age is: " + getAge() + "\nGood Behaviour?: " + getBehaviour()+"\nHas Patronage?: "+getPatronage()+"\nThe Breed is: "+getBreed()+"\nThe Weight is: "+getWeight()+"\nHas PBD?: "+getPDB()+"\nHas Lishmania?: "+getLishmania()+"\n";
    }


}