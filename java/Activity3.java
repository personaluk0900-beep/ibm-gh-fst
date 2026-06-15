package fst123;

public class Activity3 {

	public static void main(String[] args) {
		double seconds = 1000000000;
		double EarthSeconds = 31557600;
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;

		System.out.println("Earth Seconds:"+seconds/EarthSeconds);
		System.out.println("Mars Seconds:"+seconds/EarthSeconds/MarsSeconds);
		System.out.println("Mercury Seconds:"+seconds/EarthSeconds/MercurySeconds);
		System.out.println("Venus Seconds:"+seconds/EarthSeconds/VenusSeconds);
		System.out.println("Jupiter Seconds:"+seconds/EarthSeconds/JupiterSeconds);
		System.out.println("Saturn Seconds:"+seconds/EarthSeconds/SaturnSeconds);
		System.out.println("Uranus Seconds:"+seconds/EarthSeconds/UranusSeconds);
		System.out.println("Neptune Seconds:"+seconds/EarthSeconds/NeptuneSeconds);
	}

}
