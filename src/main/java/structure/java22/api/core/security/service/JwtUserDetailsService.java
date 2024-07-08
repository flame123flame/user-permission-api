package structure.java22.api.core.security.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import structure.java22.api.core.security.vo.JwtResponse;
import structure.java22.api.entity.UserEntity;
import structure.java22.api.repository.UserRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return new User(username, "", new ArrayList<>());
        }
        return new User(user.getUsername(), user.getPasswordHash(),
                new ArrayList<>());
    }

    public JwtResponse.Response buildJwtResponse(String token, UserEntity userEntity) {
        JwtResponse.Response response = new JwtResponse.Response();
        response.setToken(token);
        return response;
    }

}
