package hoang.phuong.server.config.security;

import hoang.phuong.server.util.SecurityUtil;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestUnauthorizedEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException exception) throws IOException {
        response.addHeader("WWW-Authenticate", " Basic realm=\"User Visible Realm\"");
        SecurityUtil.sendError(request, response, new AuthenticationServiceException(""),
                HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
    }

}