package ctrl;

import model.Tableau;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Detail")
public class Detail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int tutor = (int) session.getAttribute("idtutor");
        int student = Integer.parseInt(request.getParameter("id_student"));
        Tableau Form = new Tableau(tutor, student);

        request.setAttribute("listEtudiant",Form.getTable());

        request.getRequestDispatcher("/WEB-INF/jsp/pageDetail.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("idtutor")!=null){
            response.sendRedirect("/Table");
        }
        else{
            response.sendRedirect("/Login");
        }
    }
}
