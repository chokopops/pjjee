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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Table")
public class Table extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // getting session data

        int tutor = (int) session.getAttribute("idtutor");
        int student = Integer.parseInt(request.getParameter("id_student"));
        Tableau Form = new Tableau(tutor); // creation of the Table object

        Form.editData(request, tutor, student);
        Form = new Tableau(tutor);
        request.setAttribute("listEtudiants",Form.getTable());
        request.getRequestDispatcher("/WEB-INF/jsp/page.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        //get the session attribute to display data

        if (session.getAttribute("idtutor")!=null){
            int tutor = (int) session.getAttribute("idtutor");
            Tableau TabStud = new Tableau(tutor);

            request.setAttribute("listEtudiants",TabStud.getTable());
            request.getRequestDispatcher("/WEB-INF/jsp/page.jsp").forward(request, response); // giving the url to redirect
        }
        else{
            response.sendRedirect("/Login");
        }


    }

}
