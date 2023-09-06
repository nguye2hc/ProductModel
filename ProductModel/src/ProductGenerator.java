import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator
{
    public static void main(String[] args) {

        ArrayList<Product> guys = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductDataRecord.txt");

        boolean done = false;

        // a.	ID (a String as before in Person)
        // b.   Name (a String)
        // c.	Description (a String a short sentence)
        // d.	Cost (This is currency so it will be a Java double)

        String ID = "";
        String Name = "";
        String Description = "";
        double Cost = 0;


        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits] ");
            Name = SafeInput.getNonZeroLenString(in, "Enter the name ");
            Description = SafeInput.getNonZeroLenString(in, "Enter the description ");
            Cost = SafeInput.getRangedDouble(in, "Enter the cost ", 0, 100000);

            Product product = new Product(ID, Name, Description, Cost);
            guys.add(product);

            done = SafeInput.getYNConfirm(in, "Are you done ?");
        } while (!done);

        for (Product product: guys)
        {System.out.println(product.toCSVDataRecord());}


        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Product product : guys)
            {
                writer.write(product.toCSVDataRecord());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
