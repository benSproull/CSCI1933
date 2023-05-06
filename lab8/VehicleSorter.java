import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VehicleSorter {
	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();

		//TODO: add vehicle objects of different types to your list
		//	e.g. vehicles.add(new Vehicle());
		vehicles.add(new Car(30.0));
		vehicles.add(new Train(470.0));
		vehicles.add(new Helicopter(0.3));



		Collections.sort(vehicles);
		for (Vehicle v : vehicles) {
			System.out.println(v);
		}
	}
}
