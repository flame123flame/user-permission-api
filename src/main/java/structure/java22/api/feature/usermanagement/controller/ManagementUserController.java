package structure.java22.api.feature.usermanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import structure.java22.api.common.CommonResponse;
import structure.java22.api.feature.usermanagement.dto.UserDTO;
import structure.java22.api.feature.usermanagement.serviceinterface.UserServiceInterface;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users-management")
public class ManagementUserController {

    private final UserServiceInterface userService;
    
    @Operation(description = "Create User")
    @PostMapping(value = "/create")
    public ResponseEntity<CommonResponse<Object>> create(@Valid @RequestBody UserDTO.RequestSave request) {
        return ResponseEntity.ok(userService.createUser(request));
    }


}