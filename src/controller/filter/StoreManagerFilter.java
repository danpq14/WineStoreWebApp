package controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "StoreManagerFilter", urlPatterns = "/store-manager")
public class StoreManagerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        Object o = session.getAttribute("role");
        if (o != null) {
            int role = Integer.parseInt(o.toString());
            int role_admin = 1;
            if (role == role_admin) {
                chain.doFilter(req, resp);
            } else {
                response.sendRedirect("views/access-denied.jsp");
            }
        }
        chain.doFilter(req, resp);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
