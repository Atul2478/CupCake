package Backend;

import DataMapper.OrderMapper;
import DataMapper.UserMapper;
import Model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Admin",urlPatterns = {"/admin"})
public class Admin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        boolean loggedin = (boolean) session.getAttribute("loggedin");

        User currUser = (User) session.getAttribute("user");

        boolean searched = false;
        request.setAttribute("searched", searched);

        // Tjek om der skal slettes en bestilling?
        String delete = null;
        delete = request.getParameter("delete");

        // Delete noget fra kurv array
        if (delete != null) {
            OrderMapper.removeOrder(Integer.parseInt(delete));

            // OrderMapper.removeOrderline(Integer.parseInt(delete));

            ArrayList<Order> newOrders = OrderMapper.loadOrders();

            request.removeAttribute("orders");
            request.setAttribute("orders", newOrders);

            ArrayList<User> users = UserMapper.loadUsers();
            request.setAttribute("users", users);
            request.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
        }

        String change = null;
        change = request.getParameter("change");

        if (change != null) {
            User foundUser = UserMapper.receiveUser(change);

            ArrayList<Order> Orders = OrderMapper.loadOrders();

            int amountOfOrders = 0;

            ArrayList<Order> userOrders = new ArrayList<Order>();

            for (Order o : Orders) {
                if (o.getUser_id() == foundUser.getId()) {
                    amountOfOrders += 1;
                    userOrders.add(o);
                }
            }

            request.removeAttribute("userOrders");
            request.setAttribute("userOrders", userOrders);
            request.removeAttribute("amountOfOrders");
            request.setAttribute("amountOfOrders", amountOfOrders);
            request.setAttribute("changeUser", foundUser);

            request.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
        }

        String findUser = null;
        findUser = request.getParameter("find-user");

        if (findUser != null) {
            searched = true;

            User searchedUser = null;

            if (findUser.contains("@")) {
                searchedUser = UserMapper.receiveUser(findUser);
            } else {
                searchedUser = UserMapper.receiveUserById(Integer.parseInt(findUser));
            }

            ArrayList<Order> Orders = OrderMapper.loadOrders();

            int amountOfOrders = 0;

            ArrayList<Order> userOrders = new ArrayList<>();

            for (Order o : Orders) {
                if (o.getUser_id() == searchedUser.getId()) {
                    amountOfOrders += 1;
                    userOrders.add(o);
                }
            }

            request.removeAttribute("userOrders");
            request.setAttribute("userOrders", userOrders);

            request.removeAttribute("amountOfOrders");
            request.setAttribute("amountOfOrders", amountOfOrders);

            request.setAttribute("searchedUser", searchedUser);
            request.removeAttribute("searched");
            request.setAttribute("searched", searched);
            request.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
        }

        int changeMoney = 0;
        changeMoney = Integer.parseInt(request.getParameter("change-money"));

        if (changeMoney != 0) {
            String changeMoneyUserId = null;
            changeMoneyUserId = request.getParameter("money-user-id");

            changeMoneyUserId = changeMoneyUserId.trim();

            User selectedUser = null;
            selectedUser = UserMapper.receiveUserById(Integer.parseInt(changeMoneyUserId));

            Double newBalance = selectedUser.getBalance() + changeMoney;
            UserMapper.updateBalance(Integer.parseInt(changeMoneyUserId), newBalance);

            searched = false;

            request.removeAttribute("searched");
            request.setAttribute("searched", searched);

            ArrayList<Order> orders = OrderMapper.loadOrders();
            ArrayList<User> users = UserMapper.loadUsers();

            request.setAttribute("orders", orders);
            request.setAttribute("users", users);

            request.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
        }

        int deleteUser = 0;
        deleteUser = Integer.parseInt(request.getParameter("delete-user"));

        if (deleteUser != 0) {
            UserMapper.removeUser(deleteUser);

            searched = false;

            request.removeAttribute("searched");
            request.setAttribute("searched", searched);

            ArrayList<Order> orders = OrderMapper.loadOrders();
            ArrayList<User> users = UserMapper.loadUsers();

            request.setAttribute("orders", orders);
            request.setAttribute("users", users);

            request.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        boolean loggedin = (boolean) session.getAttribute("loggedin");
        User currUser = (User) session.getAttribute("user");

        boolean searched = false;
        request.setAttribute("searched", searched);

        if (!loggedin) {
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            if (currUser.getPermission() != 10) {
                request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                ArrayList<Order> orders = OrderMapper.loadOrders();
                ArrayList<User> users = UserMapper.loadUsers();

                request.setAttribute("orders", orders);
                request.setAttribute("users", users);
                request.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
            }
        }
    }
}
