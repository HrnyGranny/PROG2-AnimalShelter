package app;


public class Request {
    private int Type; //0=Fostering; 1=Adoption
    private String Phone;
    
    // Constructor
    public Request(int Type, String Phone) {
        this.Type = Type;
        this.Phone = Phone;
    }

    //Setters and getters

    public int getType() {
        return Type;
    }

 

    public String getPhone() {
        return Phone;
    }


 
    //toString 
    
    @Override
    public String toString() {
        
        String cadena = "\nRequest [Type = ";
        cadena+= Type == 0 ? "fostering" : "adoption" ; 
        cadena+= ", Telephone = " + Phone + "]";
        return cadena;
        
    }
}