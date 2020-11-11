package ctrl;

import model.*;
import static utils.Constant.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("profile").equals("student")){//If you are student
            Student studentForm = new Student();
            studentForm.setAccount(request);
            request.setAttribute("loginFormIndex",studentForm);
            if (studentForm.getResultat().equals(registerSuccess)){//If register succed you go to login page
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            }
            else{//If register failed you stay on register page
                request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
            }
        }
        else{
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
    {

    }


}
