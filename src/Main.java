import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int supply = 0;
        int buy = 0;
        int result;

        Connection c;
        Statement statement;

        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/sopra",
                            "postgres","123456");
            c.setAutoCommit(false);

            statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.values;");

            while (rs.next()){
                String operation = rs.getString("operation");
                int amount = rs.getInt("amount");
                if(operation.equals("supply")){
                    supply = supply + amount;
                }
                else {
                    buy = buy + amount;
                }
            }
            rs.close();
            statement.close();
            c.close();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        result = supply - buy;

        List<Integer> list = Arrays.asList(supply, buy, result);

        print pr = new print();
        pr.print(list);
    }
}