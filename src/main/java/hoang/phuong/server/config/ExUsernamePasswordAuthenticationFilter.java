package hoang.phuong.server.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        final String username = request.getParameter("username");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("email", email);
        request.getSession().setAttribute("password", password);

        return super.attemptAuthentication(request, response);
    }
}