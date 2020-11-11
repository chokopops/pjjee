package ctrl;

import model.Student;
import static utils.Constant.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static utils.Constant.registerSuccess;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("profile").equals("student")){//If you are student
            Student studentForm = new Student();
            studentForm.verifAccount(request);
            if (studentForm.getResultat().equals(loginSuccess)){//If login succeed you go to login page

                String emailStudent = studentForm.getEmail();
                HttpSession session = request.getSession();
                session.setAttribute("email", emailStudent);

                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            }
            else{//If login failed you stay on register page
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            }
        }
        else{
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
