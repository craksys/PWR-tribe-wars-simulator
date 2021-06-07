package Write;

import Graph.Stats;

import java.io.*;

public class CSV implements WriteToFile {


    public void write() throws IOException {
//
        File file = new File("src/Images/Dane.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write("Runda nr: " + "," + Stats.rounds + '\n');
        br.write("Ilosc jednostek zywych: " + "," + Stats.alive + '\n');
        br.write("Calkowita ilosc inerakcji: " + "," + Stats.interactions + '\n');
        br.write("Ilosc wojen: " + "," + Stats.attacks + '\n');
        br.write("W tym pyrrusowe zwyciestwa: " + "," + Stats.ties + '\n');
        br.write("Ilosc sojuszy: " + "," + Stats.allays + '\n');
        br.write("Ilosc smierci z potrzeby: " + "," + Stats.lackOfResources + '\n');
        br.write('\n');
        br.close();
        fr.close();
    }
}