
import java.sql.Connection;
import java.sql.DriverManager;

public class databaseconnection {

    public Connection databaselink;

    public Connection getConnection() {
        String databasename = "logintryi";
        String databaseuser = "root";
        String databasepasswowrd = "mama2121";
        String url = "jdbc:mysql://localhost/" + databasename;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, databaseuser, databasepasswowrd);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return databaselink;
    }

}
