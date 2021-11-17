
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bob {

    static boolean found;

    public static void main(String[] args) throws FileNotFoundException {
    	
        Scanner file = new Scanner(new File("bob.dat"));
        int size = file.nextInt();
        for (int i = 0; i < size; i++) {
            int numBlocks = file.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < numBlocks; j++) {
                list.add(file.nextInt());
            }
            int favorite = file.nextInt();
            found = false;
            match(list, favorite, 0);
            out.println(found ? "Yes." : "Not Possible.");
            //out.println(favorite(list, favorite) ? "Yes." : "Not Possible.");
        }

    }

    public static void match(ArrayList<Integer> list, int fav, int index) {
        if (fav == 0) {
            found = true;
            return;
        }
        if (index >= list.size()) {

            return;
        }
        match(list, fav, index +1);
        match(list, fav - list.get(index), index +1);
    }

    // or for the more advanced recursive thinker try a one liner nested ternary
    public static boolean favorite(List<Integer> list, int fav) {
        return fav == 0 ? true : false;
    }
}
