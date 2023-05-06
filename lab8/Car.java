public class Car extends Vehicle{
    private double mpg;

    public Car(double milePer){
        mpg = milePer;
        Vehicle.nVehicles += 1;
    }

    @Override
    public void movingForward() {
        String ans = "Car Moving Forward";
        System.out.println(ans);

    }

    @Override
    public void movingBackward() {
        String ans = "Car Moving Backward";
        System.out.println(ans);

    }

    public double setMPG(){
        return mpg = 30.0;
    }

    @Override
    public double getMPG() {
        return mpg;
    }

    public String toString(){
        return "Car: " + mpg;
    }

}
