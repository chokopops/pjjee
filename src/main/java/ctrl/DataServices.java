package ctrl;

import java.sql.Connection;
import java.sql.DriverManager;
import static utils.Constant.*;

public class DataServices {

    public static Connection connect(Connection conn){ // class which permit the database connection

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

}
