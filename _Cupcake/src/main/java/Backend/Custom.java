package Backend;

import DataMapper.TopBottomMapper;
import Model.Bottom;
import Model.Top;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Custom",urlPatterns = {"/custom"})
public class Custom extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Top> topList = TopBottomMapper.readTops();
        request.setAttribute("toplist", topList);

        ArrayList<Bottom> bottomList = TopBottomMapper.readBottoms();
        request.setAttribute("bottomlist", bottomList);

        request.getServletContext().getRequestDispatcher("/custom.jsp").forward(request, response);

    }
}

