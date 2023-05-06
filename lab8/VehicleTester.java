public class VehicleTester {
    public static void main(String[] args){
       /* Bike b = new Bike();
        b.movingForward();
        b.movingBackward();
        Scooter s = new Scooter();
        s.movingForward();
        s.movingBackward();*/

        Car car = new Car(30.0);
        System.out.println(car);
        car.movingForward();
        car.movingBackward();
        System.out.println("Total Number of Vehicles: " + Vehicle.getNumVehicles());

    }
}
