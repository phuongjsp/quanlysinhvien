package hoang.phuong.server.config.security;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsrfRequestMatcher implements org.springframework.security.web.util.matcher.RequestMatcher {

    private final Map<String, String[]> requireCsrfPatterns;

    public CsrfRequestMatcher(Map<String, String[]> requireCsrfPatterns) {
        this.requireCsrfPatterns = requireCsrfPatterns;
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        List<AntPathRequestMatcher> requestMatcherList = requireCsrfPatterns.entrySet().stream()
                .map(entry -> {
                    return Arrays.stream(entry.getValue())
                            .map(httpMethod -> new AntPathRequestMatcher(entry.getKey(), httpMethod))
                            .collect(Collectors.toList());
                })
                .collect(ArrayList::new, List::addAll, List::addAll);
        return requestMatcherList.stream().anyMatch(requestMatcher -> requestMatcher.matches(request));
    }

}
