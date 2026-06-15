package fst123;
import java.util.*;

class Plane{
	public List<String> passengers;
	public int maxPassengers;
	public Date LastTimeTookof;
	public Date LastTimeLanded;
	
	public Plane(int maxPassengers) {
		this.maxPassengers=maxPassengers;
		this.passengers = new ArrayList<>();
	}
	public void onboard(String passengerName) {
		if(passengers.size()<maxPassengers) {
			this.passengers.add(passengerName);
		} else {
			System.out.println("Plane if full");
		}
	}
	public Date takeOff() {
		this.LastTimeTookof=new Date();
		return LastTimeTookof;
	}
	public void land() {
		this.LastTimeLanded=new Date();
		this.passengers.clear();
	}
	public Date getLastTimeLanded() {
		return LastTimeLanded;
	}
	public List<String> getPassengers(){
		return passengers;
	}
}
public class Activity6 {

	public static void main(String[] args) {
		Plane plane = new Plane(10);
		plane.onboard("john");
		plane.onboard("Steve");
		plane.onboard("Anna");
		
		System.out.println("Plane took off: "+plane.takeOff());
		System.out.println("People on the plane: "+plane.getPassengers());
		plane.land();
		System.out.println("Plane landed at: "+plane.getLastTimeLanded());
		System.out.println("People on the plane after landing: "+plane.getPassengers());
		}

}
