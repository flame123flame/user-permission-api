package structure.java22.api.feature.usermanagement.serviceinterface;

import structure.java22.api.common.CommonResponse;
import structure.java22.api.feature.usermanagement.dto.ButtonDTO;
import structure.java22.api.feature.usermanagement.dto.UserDTO;

public interface ButtonServiceInterface {

	CommonResponse<Object> findAllButton();

	CommonResponse<Object> create(ButtonDTO.RequestCreate req);

	CommonResponse<Object> update(ButtonDTO.RequestCreate req);

}