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
    	  
	    private Long id;
	    private Long roleId;
	    private Long calAgentGroupId;
	    private String firstName;
	    private String lastName;
	    private String nickName;
	    private String mobile;
	    private String username;
	    private String password;
	    private BigDecimal firstInstallmentSales;
		private UserType userType;
    }
	
}


