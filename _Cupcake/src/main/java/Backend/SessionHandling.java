package Backend;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class SessionHandling {

    public static void clearSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Enumeration attributeNames = session.getAttributeNames();

        while (attributeNames.hasMoreElements()) {

            String param = attributeNames.nextElement().toString();

            session.removeAttribute(param);
            System.out.println(param);
        }

    }
}
