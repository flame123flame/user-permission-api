package structure.java22.api.core.model;

import lombok.Data;
import structure.java22.api.core.constant.ResponseConstant;

@Data
public class ResponseData<T> {
	private ResponseConstant.RESPONSE_STATUS status = ResponseConstant.RESPONSE_STATUS.FAILED;
	private String message;
	private T data;
}
