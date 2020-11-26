package ctrl;

import model.Tableau;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "TableSearch")
public class TableSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int tutor = (int) session.getAttribute("idtutor");
        String search = (String)(request.getParameter("search"));
        Tableau Form = new Tableau(tutor);
        Form = search(Form, search);

        request.setAttribute("listEtudiants",Form.getTable());
        request.getRequestDispatcher("/WEB-INF/jsp/page.jsp").forward(request, response);
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

    public Tableau search(Tableau Tab, String search){
        boolean searchFound;
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern); // setting a dateformat to search data according to the database

        // searching inside the database to find the searched data according to the entered data

        for (int i = 0; i < Tab.getTable().size(); i++){
            searchFound = false;
            if ((Integer.toString(Tab.getTable().get(i).getStudentInfo().getIdStudent()).toUpperCase().contains(search.toUpperCase())) && (searchFound==false)){
                searchFound = true;
            }
            else if (((Tab.getTable().get(i).getStudentInfo().getLastname().toUpperCase()).contains(search.toUpperCase())) && (searchFound==false)){
                searchFound = true;
            }
            else if (((Tab.getTable().get(i).getStudentInfo().getFirstname().toUpperCase()).contains(search.toUpperCase())) && (searchFound==false)){
                searchFound = true;
            }
            else if (((Tab.getTable().get(i).getStudentInfo().getGroup().toUpperCase()).contains(search.toUpperCase())) && (searchFound==false)){
                searchFound = true;
            }
            else if (((Tab.getTable().get(i).getStudentStage().getMds().toUpperCase()).contains(search.toUpperCase())) && (searchFound==false)){
                searchFound = true;
            }
            else if (((df.format(Tab.getTable().get(i).getStudentStage().getDebut()).toUpperCase()).contains(search.toUpperCase())) && (searchFound==false)){
                searchFound = true;
            }
            else if (((df.format(Tab.getTable().get(i).getStudentStage().getFin()).toUpperCase()).contains(search.toUpperCase())) && (searchFound==false)){
                searchFound = true;
            }
            else if (((Integer.toString(Tab.getTable().get(i).getStudentStage().getNoteTech()).toUpperCase()).contains(search.toUpperCase())) && (searchFound==false)){
                searchFound = true;
            }
            else if (((Integer.toString(Tab.getTable().get(i).getStudentStage().getNoteCom()).toUpperCase()).contains(search.toUpperCase())) && (searchFound==false)){
                searchFound = true;
            }
            else if (((Tab.getTable().get(i).getStudentEnterprise().getNom().toUpperCase()).contains(search.toUpperCase())) && (searchFound==false)){
                searchFound = true;
            }
            else if (((Tab.getTable().get(i).getStudentEnterprise().getAdresse().toUpperCase()).contains(search.toUpperCase())) && (searchFound==false)){
                searchFound = true;
            }


            if (searchFound == false){
                Tab.getTable().remove(i);
                i--;
            }
        }

        return Tab;
    }
}
