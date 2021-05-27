package Write;

import Graph.Stats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToFile {


    public void createAndWrite() {

        try (PrintWriter writer = new PrintWriter(new File("src/Images/test.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Runda nr: " + "," + Stats.rounds + '\n');
            sb.append("Ilosc jednostek zywych: " + "," + Stats.alive + '\n');
            sb.append("Calkowita ilosc inerakcji: " + "," + Stats.test + '\n');
            sb.append("Ilosc wojen: " + Stats.attacks + "," + '\n');
            sb.append("W tym pyrrusowe zwyciestwa: " + "," + Stats.test2 + '\n');
            sb.append("Ilosc sojuszy: " + Stats.allays + "," + '\n');
            sb.append("Ilosc smierci z potrzeby: " + "," + Stats.hungerdead + '\n');
            sb.append('\n');
            writer.write(sb.toString());

            System.out.println("Zapisano dane do pliku csv!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
