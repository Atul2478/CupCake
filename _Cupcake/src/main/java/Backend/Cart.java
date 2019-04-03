package Backend;

import DataMapper.OrderMapper;
import DataMapper.TopBottomMapper;
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

@WebServlet(name = "Cart", urlPatterns = {"/cart"})
public class Cart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        boolean loggedin = (boolean) session.getAttribute("loggedin");

        ArrayList<Cupcake> kurv = null;
        kurv = (ArrayList<Cupcake>) session.getAttribute("kurv");

        if (kurv == null) { kurv = new ArrayList<Cupcake>(); }

        String delete = null;
        delete = request.getParameter("delete");

        // Delete noget fra kurv array
        if (delete != null) {
            kurv.remove(Integer.parseInt(delete));

            Double totalPrice = 0.0;

            for (Cupcake c : kurv) {
                totalPrice += c.getPrice()*c.getAmount();
            }

            session.removeAttribute("totalPrice");
            session.setAttribute("totalPrice", totalPrice);

            session.removeAttribute("kurv");
            session.setAttribute("kurv", kurv);

            request.getRequestDispatcher("/kurv.jsp").forward(request, response);
        }

        String order = null;
        order = request.getParameter("order");

        if (order != null && order.equals("doOrder")) {
            // Complete Order

            if (!loggedin) {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                Double totalPrice = 0.0;

                for (Cupcake c : kurv) {
                    totalPrice += c.getPrice()*c.getAmount();
                }

                // Complete Order

                User user = null;
                user = (User) session.getAttribute("user");

                OrderMapper.createOrder(kurv, user, totalPrice);

                Double newBalance = 0.0;

                newBalance = user.getBalance() - totalPrice;

                UserMapper.updateBalance(user.getId(), newBalance);

                // Opdater brugeren

                session.removeAttribute("user");

                User tempUser = UserMapper.receiveUser(user.getEmail());

                session.setAttribute("user", tempUser);

                kurv = null;

                session.removeAttribute("kurv");
                session.setAttribute("kurv", kurv);

                request.getRequestDispatcher("/kurv.jsp").forward(request, response);
            }
        } else {

            String sTop = request.getParameter("top");
            String sBottom = request.getParameter("bottom");
            String sAmount = request.getParameter("amount");

            int top = Integer.parseInt(sTop);
            int bottom = Integer.parseInt(sBottom);
            int amount = Integer.parseInt(sAmount);

            ArrayList<Top> topList = TopBottomMapper.readTops();
            ArrayList<Bottom> bottomList = TopBottomMapper.readBottoms();

            Double topPrice = 0.0;
            Double bottomPrice = 0.0;

            String topName = "";
            String bottomName = "";

            for (Top t : topList) {
                if (t.getId() == top) {
                    topPrice = t.getPrice();

                    topName = t.getName();
                }
            }

            for (Bottom b : bottomList) {
                if (b.getId() == bottom) {
                    bottomPrice = b.getPrice();

                    bottomName = b.getName();
                }
            }

            Double price = topPrice + bottomPrice;

            Cupcake newCupcake = new Cupcake(top, topName, bottom, bottomName, amount, price);

            kurv.add(newCupcake);

            Double totalPrice = 0.0;

            for (Cupcake c : kurv) {
                totalPrice += c.getPrice()*c.getAmount();
            }

            session.removeAttribute("totalPrice");
            session.setAttribute("totalPrice", totalPrice);

            session.removeAttribute("kurv");
            session.setAttribute("kurv", kurv);

            request.getRequestDispatcher("/kurv.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}