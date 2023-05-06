import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BookshelfReader {

    public static Bookshelf readBooksFromFile(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner s = new Scanner(f);


        int numlines = 0;
        while (s.hasNextLine()){
            numlines++;
            String x = s.nextLine();
        }
        s.close();

        Bookshelf shelf = new Bookshelf(numlines);
        s = new Scanner(f);
        for (int i = 0; i < numlines; i++){
            String[] stats = s.nextLine().split(",");
            Book book = new Book(stats[0], stats[1], Double.parseDouble(stats[2]));
            shelf.add(book);
        }
        s.close();
        return shelf;
    }

    public static void writeShelfToFile(Bookshelf b, String filename) throws FileNotFoundException {
        PrintWriter p = new PrintWriter(new File(filename));
        b.sort('r');
        p.println(b.toString());
        p.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Bookshelf library = readBooksFromFile("bookinput.txt");
        writeShelfToFile(library, "output.txt");
        System.out.println(library);

    }
}