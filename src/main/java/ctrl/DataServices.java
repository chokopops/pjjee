package ctrl;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static utils.Constant.*;

public class DataServices {

    public static Connection connect(Connection conn){ // class which permit the database connection

//        final Properties prop = new Properties();
//        InputStream input = null;
//
//        try {
//            Class.forName(JDBC_DRIVER);
//
//            input = new FileInputStream("C:\\Users\\panin\\IdeaProjects\\pjjeeàdetruire\\src\\main\\java\\ctrl\\DataServices.java");
//
//            // load a properties file
//            prop.load(input);
//
//            // get the property value and print it out
//            String DB_URL = prop.getProperty("db.url");
//            String DB_USER = prop.getProperty("db.username");
//            String DB_PWD = prop.getProperty("db.password");
//            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
//
//
//        } catch (final IOException | SQLException | ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } finally {
//            if (input != null) {
//                try {
//                    input.close();
//                } catch (final IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

}
