public class Stack<T extends Comparable<T>> {
    private T[] stack;
    private int count;
    public Stack(){
        stack = (T[]) new Comparable[5];
    }
    public Stack(int size){
        stack = (T[]) new Comparable[size];
    }
    public T pop()throws StackException{
        if (count == 0){
            throw new StackException(count);
        } else{
            return stack[--count];
        }


    }
    public void push(T item) throws StackException{
        if (count == stack.length){
            throw new StackException(count);
        } else{
            stack[count++] = item;
        }
      /*  try {
            stack[count++] = item;
        } catch (RuntimeException e){
            System.out.println("Error");
        }*/

    }
}
