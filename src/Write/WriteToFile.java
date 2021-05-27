package Write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToFile {
    public void write() {

        try (PrintWriter writer = new PrintWriter(new File("src/Images/test.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("id,");
            sb.append(",");
            sb.append("Name");
            sb.append('\n');
            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
