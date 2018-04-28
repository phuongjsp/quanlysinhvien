package hoang.phuong.server.config.security;

import hoang.phuong.server.dao.UserRepository;
import hoang.phuong.server.model.User;
import hoang.phuong.server.util.SecurityUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserRepository userService;

    @Inject
    public RestAuthenticationSuccessHandler(UserRepository userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication)
            throws IOException {
        User user = userService.findByEmail(authentication.getName());
        SecurityUtil.sendResponse(request, response, HttpServletResponse.SC_OK, user);
    }

}
