public class Helicopter extends Vehicle{
    private double mpg;

    public Helicopter(double milePer) {
        mpg = milePer;
        Vehicle.nVehicles += 1;

    }

    @Override
    public void movingForward() {
        String ans = "Helicopter Moving Forward";
        System.out.println(ans);
    }

    @Override
    public void movingBackward() {
        String ans = " Helicopter Moving Backward";
        System.out.println(ans);

    }

    public void movingUp(){
        String ans = "Helicopter Moving Up";
        System.out.println(ans);
    }
    public void movingDown(){
        String ans = "Helicopter Moving Down";
        System.out.println(ans);
    }

    public double setMPG(){
        return mpg = 0.3;
    }

    @Override
    public double getMPG() {
        return mpg;
    }
    public String toString(){
        return "Helicopter: " + mpg;
    }
}
