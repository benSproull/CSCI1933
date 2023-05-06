import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;


    public int populateData() throws FileNotFoundException {
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while (scanner.hasNextLine()) {
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);
//        System.out.println(scanner.next());
//        System.out.println(s);
//        data[0] = new Owl("jimmy", 6, 2);
        for (int i = 0; i < numLines; i++) {
            String[] owlEntry = scanner.nextLine().split(",");
            data[i] = new Owl(owlEntry[0], Integer.parseInt(owlEntry[1]), Double.parseDouble(owlEntry[2]));
        }
        return data.length;
    }

    public OwlPopulation(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        populateData();
    }

    public double averageAge() {
        double sumAges = 0;
        for (int i = 0; i < data.length; i++){
            sumAges += data[i].getAge();
        }
        return sumAges/data.length;
    }

    public Owl getYoungest() {
        int indexOfYoungest = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i].getAge() < data[indexOfYoungest].getAge()){
                indexOfYoungest = i;
            }
        }
        return data[indexOfYoungest];
    }

    public Owl getHeaviest() {
        double heaviest = 0;
        int indexOfHeaviest = 0;

        for (int i = 0; i < data.length; i++){
            if (data[i].getWeight() > data[indexOfHeaviest].getWeight()){
                indexOfHeaviest = i;
            }
        }
        return data[indexOfHeaviest];
    }

    public String toString() {
        String output = "";
        Owl youngest = this.getYoungest();
        Owl heaviest = this.getHeaviest();

        output += "Average age: " + averageAge() + "\n";
        output += "Name and weight of heaviest: " + heaviest.getName() + " " + heaviest.getWeight() + "\n";
        output += "Name and age of youngest: " + youngest.getName() + " " + youngest.getAge() + "\n";
        return output;
    }

    public boolean containsOwl(Owl other) {
        boolean sameOwl = false;
        Owl owl;
        if (data.length != 0){
            for (int i = 0; i < data.length; i++){
                owl = data[i];
                if (owl.equals(other)){
                    sameOwl = true;
                }
            }
        }
        return sameOwl;
    }

    public void merge(OwlPopulation other) {
        Owl[] newData;
        Owl[] otherData = other.data;
        int numOwls = otherData.length;
        for (int i = 0; i < data.length; i++){
            if (! other.containsOwl(data[i])){
                numOwls ++;
            }
        }

        newData = new Owl[numOwls];
        int entry = 0;

        for (int i = 0; i < data.length; i++){
            if (! other.containsOwl(data[i])){
                newData[entry] = data[i];
                entry ++;
            }
        }
        for (int i = 0; i < otherData.length; i++){
            newData[entry] =otherData[i];
            entry ++;
        }
        this.data = newData;
    }
    //1) determine (and store) the distinct owls in the other population.

    //2) make a new data array to hold the correct number of owls for the merged population

    //3) copy over the distinct owls from each population to the data array

    //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)


    public int popSize() {
        return data.length;
    }

    public static void main(String[] args) {
        try {

            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println(pop1);
//            System.out.println("Population size of OwlPopulation1 is: " + pop1.popSize());


            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println(pop2);


            pop1.merge(pop2);
            System.out.println("Merged population size: " + pop1.popSize());
            System.out.println(pop1.toString());
//            System.out.println(pop1.popSize());
        }
        catch(FileNotFoundException f){
            System.out.println("File not found.");
        }
    }

}

