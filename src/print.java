import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class print {

    static void print(List<Integer> arguments){

        int supply = arguments.get(0);
        int buy = arguments.get(1);
        int result = arguments.get(2);

        PrintWriter pw;
        try {
            pw = new PrintWriter ("ReportSQL.csv");

            String csvData = "" + "Supply" + ',' + supply + '\n' +
                    "Buy" + ',' + buy + '\n' + "Result" + ',' + result;
            pw.write(csvData);
            pw.close();

            JOptionPane.showMessageDialog(null,"Report saved");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
