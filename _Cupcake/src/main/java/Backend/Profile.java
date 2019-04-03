package Backend;

import DataMapper.TopBottomMapper;
import DataMapper.UserMapper;
import Model.Bottom;
import Model.Top;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Profile",urlPatterns = {"/profile"})
public class Profile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String password = null;
        password = request.getParameter("password");

        String changeSuccess = null;

        if (password != null) {
            User currUser = (User) session.getAttribute("user");

            if (password.equals(currUser.getPassword())) {
                // DO THINGS
                changeSuccess = "ok";

                String newEmail = request.getParameter("email");
                String newUsername = request.getParameter("username");

                UserMapper.updateEmail(currUser.getId(), newEmail);
                UserMapper.updateUsername(currUser.getId(), newUsername);

                currUser = UserMapper.receiveUser(currUser.getEmail());

                session.removeAttribute("user");
                session.setAttribute("user", currUser);

                request.setAttribute("success", changeSuccess);
                request.getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
            } else {
                // DISPLAY MESSAGE
                changeSuccess = "fail";


                request.setAttribute("success", changeSuccess);
                request.getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String changeSuccess = null;
        changeSuccess = request.getParameter("success");


        request.setAttribute("success", changeSuccess);
        request.getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
    }
}

