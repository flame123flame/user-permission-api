package structure.java22.api.feature.usermanagement.dto;

import lombok.*;
import lombok.experimental.UtilityClass;
import structure.java22.api.common.UserType;

import java.math.BigDecimal;
@UtilityClass
public class UserDTO {
    
	@Getter
    @Setter
    public static class RequestSave  {
	    private String username;
		private String password;
		private String email;
    }
	
}


