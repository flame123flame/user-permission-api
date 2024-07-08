package structure.java22.api.feature.usermanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import structure.java22.api.common.CommonResponse;
import structure.java22.api.feature.usermanagement.dto.ButtonDTO;
import structure.java22.api.feature.usermanagement.serviceinterface.ButtonServiceInterface;

@RestController
@AllArgsConstructor
@RequestMapping("/api/button")
public class ButtonController {

    ButtonServiceInterface buttonServiceInterface;

    @Operation(description = "Find All Button")
    @GetMapping(value = "/find-all")
    public ResponseEntity<CommonResponse<Object>> findAll() {
        return ResponseEntity.ok(buttonServiceInterface.findAllButton());
    }

    @Operation(description = "Create Button")
    @PostMapping(value = "/create")
    public ResponseEntity<CommonResponse<Object>> create(@RequestBody ButtonDTO.RequestCreate req) {
        return ResponseEntity.ok(buttonServiceInterface.create(req));
    }

    @Operation(description = "Update Button")
    @PostMapping(value = "/update")
    public ResponseEntity<CommonResponse<Object>> update(@RequestBody ButtonDTO.RequestCreate req) {
        return ResponseEntity.ok(buttonServiceInterface.update(req));
    }

}
