public class Bookshelf {

    private Book[] arr;

    //Book[] arr = new Book[20];
    private int nextEmpty = 0;
    private int arrSize = 20;

    public Bookshelf(int arrSize){
        this.arrSize = arrSize;
        this.arr = new Book[arrSize];

    }


    public boolean add(Book newBook){

        if (arr[arr.length -1] != null){
            return false;
        } else {
            arr[nextEmpty] = newBook;
            nextEmpty ++;
            return true;
        }
    }

    public Bookshelf getBooksByAuthor(String author){
        //Book[] newArray = new Book[arrSize];
        Bookshelf newShelf = new Bookshelf(arrSize);

        for (int i = 0; i < arr.length - 1; i++) {
            if (author.equals(arr[i].getAuthor())) {
                newShelf.add(arr[i]);
                //newArray[count] = arr[i];
                //count++;
            }


        }

        //newShelf.arr = newArray;
        return newShelf;
    }
    public String toString(){
        String str = "";
        for (int i = 0; i < nextEmpty; i++ ){
            str = str + (arr[i].getTitle() + ", " + arr[i].getAuthor() + ", " + arr[i].getRating() + "\n");
        }
        return str;
    }

    public void sort(char sortBy) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j], sortBy) > 0) {
                    Book temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }
    }

    public static void main(String[] args){
        /*Bookshelf bs = new Bookshelf(5);
        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs.add(new Book("Eldest", "Christopher Paolini", 10.0));
        bs.add(new Book("Brisingr", "Christopher Paolini", 10.0));
        bs.add(new Book("Inheritance", "Christopher Paolini", 10.0));
        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
        Bookshelf goodbooks = bs.getBooksByAuthor("Christopher Paolini");
        System.out.println(goodbooks);*/

        Bookshelf bs = new Bookshelf(5);
        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkein", 10.0));
        bs.add(new Book("Twilight", "Stephenie Meyer", 0.0));
        bs.add(new Book("The Diary of a Wimpy Kid", "Jeff Kinney", 0.0));
        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
        bs.sort('a');
        System.out.println(bs);
    }
}
