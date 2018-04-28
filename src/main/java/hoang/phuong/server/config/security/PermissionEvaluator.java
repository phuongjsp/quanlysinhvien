package hoang.phuong.server.config.security;

import hoang.phuong.server.dao.UserRepository;
import hoang.phuong.server.exception.EntityNotFoundException;
import hoang.phuong.server.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class PermissionEvaluator implements org.springframework.security.access.PermissionEvaluator {

    private static final Logger LOG = LoggerFactory.getLogger(PermissionEvaluator.class);
    private final UserRepository userRepository;

    public PermissionEvaluator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }

    public boolean hasPermissionForUser(Authentication authentication, Integer userId) {
        if (userRepository.getById(userId) == null) {//TODO can xem lai
            throw new EntityNotFoundException(
                    String.format("User with id %d not found", userId));
        }
        User authenticationUser = userRepository.findByEmail(authentication.getName());
        if (Objects.equals(authenticationUser.getId(), userId)) {
            return true;
        }
        LOG.error("User with id {} does not have permission", userId);
        return false;
    }


}