public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node head;
    private int size;
    public LinkedList(){
        head = null;
    }

    @Override
    public boolean add(T element) {
        Node newNode = new Node(element, null);
        if (element == null){
            return false;
        } else{
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void equalTo(T element) {

    }

    @Override
    public void reverse() {

    }

    @Override
    public void merge(List<T> otherList) {

    }

    @Override
    public void pairSwap() {

    }

    @Override
    public boolean isSorted() {
        return false;
    }
}
