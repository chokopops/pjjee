package ctrl;

import model.*;
import static utils.Constant.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

import static utils.Constant.registerSuccess;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            Tutor Form = new Tutor();
            Form.verifAccount(request);
            if (Form.getResultat().equals(loginSuccess)){//If login succeed you go to login page

                HttpSession session = request.getSession();
                session.setAttribute("idtutor", Form.getIdTutor());

                response.sendRedirect("/Table");
            }
            else{//If login failed you stay on register page
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }
}
