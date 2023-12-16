package app;

import Exceptions.NoMoreRequestException;

public abstract class Animal {
    private String Name;
    private String Sex;
    private int Age;
    private Boolean Behaviour;
    private Boolean Patronage;
    private Request [] RequestArray = new Request [10];

    //Constructor 

    public Animal(String Name,String Sex, int Age, Boolean Behaviour, Boolean Patronage){
        this.Name = Name;
        this.Sex = Sex;
        this.Age = Age;
        this.Behaviour = Behaviour;
        this.Patronage = Patronage;

    }

    //Getters

    public Request [] getArrayRequest (){
        return RequestArray;
    }

    public String getName (){
        return Name;
    }

    public String getSex (){
        return Sex;
    }

    public int getAge(){
        return Age;
    }

    public Boolean getBehaviour(){
        return Behaviour;
    }
    
    public Boolean getPatronage(){
        return Patronage;
    }

    //I create this method in order to fill our Requests Array with given parameters

    public void addRequest(int Type,String Phone) throws NoMoreRequestException {
        boolean stop=false;
        for (int i = 0; i < getArrayRequest().length && !stop ; i++) {
            if (getArrayRequest()[i] == null) {
                getArrayRequest()[i] = new Request (Type, Phone);
                stop =true;
            }else if(i==(getArrayRequest().length)-1){  //If it reaches 9 it will throw the exception created by me "NoMoreRequestException"
                                            //It will only reach 9 if all the previous request had been made
                throw new NoMoreRequestException();
            }
        }
    }

    //Whith this method I get all the fostering requests

    public String checkFostering(){
        String info="";
        int counter=0;
        for(int i = 0; i < getArrayRequest().length; i++){
            if(getArrayRequest()[i] == null){
                info += "";
            }else if (getArrayRequest()[i].getType() == 0){
                info += getArrayRequest()[i].toString();
                counter++;
            }
        }
        info += "\nthe number of fostering requests is:"+counter;
        return info;
    }

    //Whith this method I get all the adooption requests
    
    public String checkAdoption(){
        String info="";
        int counter=0;
        for(int i = 0; i < getArrayRequest().length; i++){
            if(getArrayRequest()[i] == null){
                info += "";
            }else if (getArrayRequest()[i].getType() == 1){
                info += getArrayRequest()[i].toString();
                counter++;
            }
        }
        info += "\nthe number of adoption requests is:"+counter;
        return info;
    }


    abstract public String toString();
    abstract public int getPricePay();
    

}