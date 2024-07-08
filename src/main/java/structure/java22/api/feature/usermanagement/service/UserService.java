package structure.java22.api.feature.usermanagement.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import structure.java22.api.common.CommonResponse;
import structure.java22.api.common.ErrorCode;
import structure.java22.api.exception.HandleException;
import structure.java22.api.feature.usermanagement.dto.UserDTO;
import structure.java22.api.repository.UserRepository;
import structure.java22.api.feature.usermanagement.serviceinterface.UserServiceInterface;


@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public CommonResponse<Object> createUser(UserDTO.RequestSave request) {
        CommonResponse<Object> response = new CommonResponse<>();
            if (userRepository.existsByUsername(request.getUsername())) {
                throw new HandleException(ErrorCode.DUPLICATE_USER);
            }

            return response;
        }

}

