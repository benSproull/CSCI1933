public class Train extends Vehicle{
    private double mpg;

    public Train(double milePer) {
        mpg = milePer;
        Vehicle.nVehicles += 1;
    }
    @Override
    public void movingForward() {
        String ans = "Train Moving Forward";
        System.out.println(ans);
    }

    @Override
    public void movingBackward() {
        String ans = "Train Moving Forward";
        System.out.println(ans);

    }
    public double setMPG(){
        return mpg = 470.0;
    }

    @Override
    public double getMPG() {
        return mpg;
    }

    public void enteringStation(){
        String ans = "Train Entering Station";
        System.out.println(ans);
    }
    public void leavingStation(){
        String ans = "Train Leaving Station";
        System.out.println(ans);
    }
    public String toString(){
        return "Train: " + mpg;
    }
}
