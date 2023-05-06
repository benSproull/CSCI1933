// Written by Ben Sproull & Luke Zaki
public class ArrayList<T extends Comparable<T>> implements List<T> {
    private T[] array;
    private int count;
    private boolean isSorted;

    public ArrayList(){
        array = (T[]) new Comparable[2];
        isSorted = true;
    }
    @Override
    public boolean add(T element) {
        if (size() == array.length){
            resize();
        }
        if (element == null){
            return false;
        }
        int i = 0;
        while (array[i] != null){
            i++;
        }
        array[i] = element;
        isSorted = false;


        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (element == null || index < 0 || index > size()){
            return false;
        }
        if (size() == array.length){
            resize();
        }
        int ptr;
        ptr = index;
        T temp;
        while (array[ptr] != null){
            temp = array[ptr];
            array[ptr] = element;
            element = temp;
            ptr++;
        }
        array[ptr] = element;
        isSorted = false;
        return true;
    }

    @Override
    public void clear() {
        array = (T[]) new Comparable[2];
        isSorted = true;

    }

    @Override
    public T get(int index) {

        if (index < 0 || index >= size()) {
            return null;
        }
        return array[index];
    }

    @Override
    public int indexOf(T element) {
        if (element == null){
            return -1;
        }
        for (int i = 0; i < size(); i++){
            if (element.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if(array[0] == null){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == null){
                return size;
            }
            size++;
        }
        return size;
    }

    @Override
    public void sort() {
        T temp;
        if(isSorted == true){
            return;
        }
        int j;
        for (int i = 1; i < size(); i++){
            temp = array[i];
            for (j = i - 1; j >= 0 && temp.compareTo(array[j]) < 0; j--){
                array[j+1] = array[j];



            }
            array[j+1] = temp;
        }
        isSorted = true;

    }

    @Override
    public T remove(int index) {
        T pop;
        if (index < 0 || index >= size()){
            return null;
        }
        pop = array[index];
        /*T[] temp = (T[]) new Comparable[array.length];
        for (int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }*/
        for (int i = index; i < size()-1; i++){
            array[i] = array[i+1];
        }
        array[size()-1] = null;
        return pop;
    }

    @Override
    public void equalTo(T element) {
        if (element == null){
            return;
        }
        for(int i = 0; i < size(); i++){
            if (!(get(i).compareTo(element) == 0)){
                remove(i);
                i--;
            }
        }

    }

    @Override
    public void reverse() {
        /*int index = size();
        T[] temp = (T[]) new Comparable[array.length];
        for (int i = 0; i < size(); i++){
            temp[i] = array[index];
            index--;

        }
        array = temp;*/
        T[] temp = (T[]) new Comparable[array.length];

        for (int i = 0; i < size() / 2; i++){
            temp[i] = array[i];
            array[i] = array[size() - i - 1];
            array[size() - i - 1] = temp[i];
        }
        isSorted = false;

    }

    @Override
    public void merge(List<T> otherList) {
        ArrayList<T> other = (ArrayList<T>) otherList;
        if (other == null || array == null){
            return;
        }
            other.sort();
            sort();
            //int length = otherList.size();
            int otherSize = other.size();
            int arraySize = this.size();
            T[] longer = (T[]) new Comparable[otherSize + arraySize];

            int i = 0;
            int j = 0;
            int k = 0;
            while(i < arraySize && j < otherSize){
                if (this.array[i].compareTo(other.array[j]) < 0){
                    longer[k] = this.array[i];
                    k++;
                    i++;
                } else{
                    longer[k] = other.array[j];
                    k++;
                    j++;
                }

            }
            while (i < arraySize){
                longer[k] = this.array[i];
                k++;
                i++;
            }
            while (j < otherSize){
                longer[k] = other.array[j];
                k++;
                j++;
            }
            array = longer;
            isSorted = true;

    }

    @Override
    public void pairSwap() {
        T temp;

        for (int i = 0; i < size() - 1; i = i + 2){
                temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;

        }
        isSorted = false;


    }

    public String toString(){
        String str = "";
        for (int i = 0; i < size(); i++){
            str += (array[i] + "\n");
        }
        return str;
    }

    @Override
    public boolean isSorted() {
        return isSorted;

    }
    public void resize(){
        T[] biggerArray = (T[]) new Comparable[array.length * 2 + 1];
        for (int i = 0; i < size(); i++){
            biggerArray[i] = array[i];
        }
        array = biggerArray;

    }
}
