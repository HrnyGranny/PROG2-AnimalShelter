package app;

public class V_Clinic{
    private String Name;
    private String Phone;
    private int Cost;
    
    //Constructor
    
    public V_Clinic (String Name, String Phone, int Cost){
        Phone = this.Phone;
        Name = this.Name;
        this.Cost = Cost;
    
    }
    
    //Cost for each female not neutered cat
    
    public int getCost(){
        return Cost;
    
    }

}