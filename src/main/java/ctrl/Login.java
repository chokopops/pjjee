package ctrl;

import model.*;
import static utils.Constant.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static utils.Constant.registerSuccess;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            Tutor Form = new Tutor();
            Form.verifAccount(request);
            if (Form.getResultat().equals(loginSuccess)){//If login succeed you go to login page

                String login = Form.getLogin();
                String profile = (String) request.getParameter("profile");

                Cookie cookieLogin = new Cookie("login", login);
                Cookie cookieProfile = new Cookie("profile", profile);
                cookieLogin.setMaxAge(60 * 60);
                cookieProfile.setMaxAge(60 * 60);
                response.addCookie(cookieLogin);
                response.addCookie(cookieProfile);
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("login")) {
                            request.setAttribute("login", cookie.getValue());
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookiesb = request.getCookies();
        if (cookiesb != null) {
            for (Cookie cookie : cookiesb) {
                if (cookie.getName().equals("login")) {
                    request.setAttribute("login", cookie.getValue());
                }
                if (cookie.getName().equals("profile")) {
                    request.setAttribute("profile", cookie.getValue());
                }
            }
        }
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }
}
