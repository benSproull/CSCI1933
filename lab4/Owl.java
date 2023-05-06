import java.util.Objects;

public class Owl {
    public Owl[] data;
    String nam;
    int a;
    double w;
    public Owl(String name, int age, double weight){
        nam = name;
        a = age;
        w = weight;


    }
    public String getName(){
        return nam;

    }
    public void setName(String name){
        nam = name;
    }
    public int getAge(){
        return a;
    }
    public void setAge(int age){
        a = age;
    }
    public double getWeight(){
        return w;
    }
    public void setWeight(double weight){
        w = weight;
    }
    public boolean equals(Owl other){
        if (this.a == other.a && this.nam.equals(other.nam) && this.w == other.w){
            return true;
        } else {
            return false;
        }

    }
    public static void main(String[] args){
        Owl owl1 = new Owl("owl1", 5, 12.0);
        Owl owl2 = new Owl("owl2", 5, 12.0);
        Owl owl3 = new Owl("owl1", 5, 12.0);
        System.out.println(owl1.equals(owl2));
        System.out.println(owl1.equals(owl3));

    }
}
