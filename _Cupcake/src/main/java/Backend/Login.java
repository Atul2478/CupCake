package Backend;


import DataMapper.UserMapper;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        boolean loggedin = false;

        loggedin = (boolean) session.getAttribute("loggedin");

        if (loggedin == false) {

        UserMapper userMapper = new UserMapper();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User tempUser = null;

        tempUser = userMapper.receiveUser(email);

        if (tempUser != null) {
            if (tempUser.getPassword().equals(password)) {

                loggedin = true;

                session.setAttribute("user", tempUser);
                session.setAttribute("user_id", tempUser.getId());
                session.setAttribute("username", tempUser.getUsername());
                session.setAttribute("email", tempUser.getEmail());
                session.setAttribute("balance", tempUser.getBalance());
                session.setAttribute("loggedin", loggedin);

                request.getRequestDispatcher("/user.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        boolean loggedIn = false;

        loggedIn = (boolean) session.getAttribute("loggedin");

        if (loggedIn == false) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        }
    }
}