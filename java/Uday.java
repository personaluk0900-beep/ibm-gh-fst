package fst123;


class Activity1{
	String color;
	String transmission;
    int make;
    int tyres;
    int doors;
    Activity1() {
    	tyres=4;
    	doors=4;
    }
    
    public void displayCharacteristics() {
    	System.out.println("Color:"+color+"\nTransmission:"+transmission+"\nMake:"+make+"\nTyres:"+" "+tyres+"\nDoors:"+doors);
    }
    public void accelarate() {
    	System.out.println("Car is moving forward.");
    }
    public void brake() {
    	System.out.println("Car has stopped.");
    }
}
public class Uday {
    public static void main(String[] args) {
    	Activity1 Car=new Activity1();
    	Car.make=2014;
    	Car.color="Black";
    	Car.transmission="Mannual";
    	Car.accelarate();
    	Car.brake();
    	Car.displayCharacteristics();
    }
}