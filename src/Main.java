import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //This program reads database of daily shop operations and creates a report of supplied/sold items in the shop.

        int supply = 0;
        int buy = 0;
        int result;

        Connection c;
        Statement statement;

        /*To make this program work you need to import sopra.sql database into your RDBMS(I used PostgreSQL)
        and define Database Driver, address, username and password. You will also need JDBC interface
         */
        String driver = "";
        String url = "";
        String user = "";
        String pswd = "";

        try{
            Class.forName(driver);
            c = DriverManager
                    .getConnection(url, user, pswd);
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
        pr.fileprint(list);
    }
}