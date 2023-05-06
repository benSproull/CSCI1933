public class Histogram {
    int histogram[];
    int lowerbound;
    int upperbound;

    public Histogram(int lowerbound, int upperbound){
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
        histogram = new int[upperbound - lowerbound + 1];
    }
    public boolean add(int i){
        if (i >= lowerbound && i <= upperbound){
            histogram[i - lowerbound]++;
            return true;
        }
        else {
            return false;
        }
    }
    public String toString() {
        String s = "";
        for (int i = lowerbound; i <= upperbound; i++) {
            s = s + String.format("%3s",i) + ":";
            for(int x = 0; x < histogram[i - lowerbound]; x++) {
                s = s + "*";
            }
            s = s + "\n";
        }
        return s;
    }
    public static void main(String args[]){
        Histogram histo = new Histogram(0, 5);
        histo.add(3);
        histo.add(2);
        histo.add(1);
        histo.add(2);
        histo.add(4);
        histo.add(0);
        histo.add(1);
        histo.add(5);
        histo.add(3);
        System.out.println(histo);
    }
}
