package hoang.phuong.server.config.security;

import hoang.phuong.server.dao.UserRepository;
import hoang.phuong.server.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository testRepo;

    @Inject
    public UserDetailsService(UserRepository testRepo) {
        this.testRepo = testRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Email is " + email);
        User user = testRepo.findByEmail(email);
        System.out.println("User is " + user);
        List<GrantedAuthority> authorityList = user.getRoles().stream()
                .map(role -> {
                    System.out.println("ROLE is " + role);
                    return new SimpleGrantedAuthority(role.toString());
                })
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), user.getEnabled(), true, true, true, authorityList);
    }

}
