package app;

public class T_Council {
private String Phone;
private int Pay;

//Constructor

public T_Council(String Phone, int Pay){
    Phone = this.Phone;
    this.Pay = Pay;

}

//This pay is for each animal in the shelter

public int getPay(){
    return Pay;

}

}