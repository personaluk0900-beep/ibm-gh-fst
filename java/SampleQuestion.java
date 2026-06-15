package fst123;
import java.util.*;

class count{
	int boys;
	int girls;
	int robots;
	
	count(int boys,int girls,int robots){
		this.boys=boys;
		this.girls=girls;
		this.robots=robots;
	}
	public void displayPopulations() {
		System.out.println("Total Boys:"+boys);
		System.out.println("Total Girls:"+girls);
		System.out.println("Total Robots:"+robots);
		int pop=boys+girls;
		System.out.println("Total Population is :"+pop);
	}
}
class Human extends count{
	Human(int boys,int girls,int robots){
		super(boys,girls,robots);
	}
	public void walking() {
		System.out.println("Walking!");
	}
	public void talking() {
		System.out.println("Talking!");
	}
}
class Boy extends count{
	Boy(int boys,int girls,int robots){
		super(boys,girls,robots);
	}
	public void walking() {
		System.out.println("Walking!");
	}
	public void talking() {
		System.out.println("Talking!");
	}
}
class Girl extends count{
	Girl(int boys,int girls,int robots){
		super(boys,girls,robots);
	}
	public void walking() {
		System.out.println("Walking!");
	}
	public void talking() {
		System.out.println("Talking!");
	}
}
class Robot extends count{
	Robot(int boys,int girls,int robots){
		super(boys,girls,robots);
	}
	public void walking() {
		System.out.println("Walking!");
	}
	public void talking() {
		System.out.println("Talking!");
	}
}
public class SampleQuestion {

	public static void main(String[] args) {
		count c= new count(3,3,3);
		Boy b=new Boy(3,3,3);
		Girl g=new Girl(3,3,3);
		Robot r=new Robot(3,3,3);
		
		b.talking();
		b.walking();
		
		g.talking();
		g.walking();
		
		r.talking();
		r.walking();
		
		c.displayPopulations();
		
	}

}
