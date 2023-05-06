public class Bike implements Drivable{
    @Override
    public void movingForward() {
        String ans = "Bike moving Forward";
        System.out.println(ans);
    }

    @Override
    public void movingBackward() {
        String ans = "Bike moving Backward";
        System.out.println(ans);
    }
}
