package app;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FileReader {
    //We create a method in order to read the file, it's a common file reader
    public void readTxT(String pathname, Shelter shelter) {
        //We create the objects File,Scanner and Animal
        File f = new File(pathname);
        Scanner sc;
        Animal n;
        int counter=0;
        //Now we use a While loop in order to read all the file
        try{
            sc = new Scanner(f);
            while(sc.hasNext()){
                //We create some variables that will be the parameters for the Animal's constructor
                char type = sc.next().charAt(0);
                String Name = sc.next();
                String Sex = sc.next();
                int Age = sc.nextInt();
                Boolean Behaviour = sc.nextBoolean();
                Boolean Patronage = sc.nextBoolean();
                //With this if we know if the Animal is a Dog or a cat
                if (type == 'p'){
                    String Breed = sc.next();
                    int Weight = sc.nextInt();
                    Boolean PDB = sc.nextBoolean();
                    Boolean Lishmania = sc.nextBoolean();
                    n = new Dog(Name, Sex, Age, Behaviour, Patronage, Breed, Weight, PDB, Lishmania);
                }else{
                    Boolean Neutured = sc.nextBoolean();
                    n = new Cat(Name, Sex, Age, Behaviour, Patronage, Neutured);
                }
                //Now we add the Animal to the Animals array that has a fixed length
                shelter.addAnimal(n,counter);
                counter++;
            }
            //With our Try and Catch we are controlling the FileNotFoundException
        } catch (FileNotFoundException e){
            System.out.println("Don't move the file from the project's folder");
        }
    }
}


