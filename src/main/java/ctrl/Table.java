package ctrl;

import model.Student;
import model.Tableau;
import model.Tutor;
import static utils.Constant.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Table")
public class Table extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(""); // Il faut faire ressortir les 17 variables demandées dans page depuis la database.//
            ArrayList<Tableau> friends = new ArrayList<>();
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);

        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
