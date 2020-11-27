package ctrl;

import model.*;
import static utils.Constant.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Boolean Log;
            Tutor Form = new Tutor();
            Form.verifAccount(request);
            String log = request.getParameter("loginForm");
            request.setAttribute("log",log);
            if (Form.getResultat().equals(LOGINSUCCESS)){//If login succeed you go to login page
                Log = true;
                HttpSession session = request.getSession(); //creation of the session object which will handle every session data
                session.setAttribute("idtutor", Form.getIdTutor());
                session.setAttribute("LastNameTutor", Form.getLastName());
                session.setAttribute("FirstNameTutor", Form.getFirstName());
                request.setAttribute("Log", Log);
                response.sendRedirect("/Table");
            }
            else{//If login failed you stay on login page
                Log = false;
                request.setAttribute("Log", Log);
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }
}
