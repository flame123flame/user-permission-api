package structure.java22.api.feature.usermanagement.serviceinterface;

import structure.java22.api.common.CommonResponse;
import structure.java22.api.feature.usermanagement.dto.UserDTO;

public interface UserServiceInterface {
	
	CommonResponse<Object> createUser(UserDTO.RequestSave user);
	
}