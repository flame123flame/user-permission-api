package structure.java22.api.core.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import structure.java22.api.common.CommonResponse;
import structure.java22.api.common.ErrorCode;
import structure.java22.api.core.security.authorization.JwtTokenUtil;
import structure.java22.api.core.security.service.JwtUserDetailsService;
import structure.java22.api.core.security.vo.JwtRequest;
import structure.java22.api.core.security.vo.JwtResponse;
import structure.java22.api.exception.HandleException;
import structure.java22.api.entity.UserEntity;
import structure.java22.api.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "authenticate/")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Value("#{'${application.version}'}")
    private String versionCode;

    @PostMapping("login")
    public ResponseEntity<CommonResponse<JwtResponse.Response>> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        CommonResponse<JwtResponse.Response> response = new CommonResponse<>();
        try {
            UserEntity userEntity = userRepository.findByUsername(authenticationRequest.getUsername())
                    .orElseThrow(() -> new HandleException(ErrorCode.NO_USER_FOUND));

            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            JwtResponse.Response userInfo = userDetailsService.buildJwtResponse(token, userEntity);
            response.setData(userInfo);
            return ResponseEntity.ok(response);
        } catch (HandleException e) {
            response.setMessage(e.getMessageTh());
            response.setStatusCode(e.getStatusCode());
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("version")
    public ResponseEntity<CommonResponse<JwtResponse.Version>> version() {
        CommonResponse<JwtResponse.Version> response = new CommonResponse<>();
        JwtResponse.Version version = new JwtResponse.Version();
        version.setVersion(versionCode);
        response.setData(version);
        return ResponseEntity.ok(response);
    }

    private void authenticate(String username, String password) throws HandleException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException | BadCredentialsException e) {
            throw new HandleException(ErrorCode.INVALID_CREDENTIALS);
        }
    }


}
