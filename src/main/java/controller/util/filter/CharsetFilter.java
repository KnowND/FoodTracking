package controller.util.filter;

/**
 * Created by edik2 on 15.01.2018.
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Encoding filter
 *
 */
public class CharsetFilter implements Filter {
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding=config.getInitParameter("requestEncoding");
        if(encoding==null) encoding="UTF-8";
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain next)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        request.setCharacterEncoding(encoding);
        next.doFilter(request, response);
    }

    public void destroy(){
    }
}
