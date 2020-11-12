package ctrl;

import model.Student;
import static utils.Constant.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
                String profile = (String) request.getParameter("profile");

                Cookie cookieEmail = new Cookie("email", emailStudent);
                Cookie cookieProfile = new Cookie("profile", profile);
                cookieEmail.setMaxAge(60 * 60);
                cookieProfile.setMaxAge(60 * 60);
                response.addCookie(cookieEmail);
                response.addCookie(cookieProfile);
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("email")) {
                            request.setAttribute("email", cookie.getValue());
                        }
                        if (cookie.getName().equals("profile")) {
                            request.setAttribute("profile", cookie.getValue());
                        }
                    }
                }
                /*HttpSession session = request.getSession();
                session.setAttribute("email", emailStudent);*/

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
