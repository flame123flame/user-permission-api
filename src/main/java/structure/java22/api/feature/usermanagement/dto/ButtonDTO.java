package structure.java22.api.feature.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ButtonDTO {

	@Getter
	@Setter
	public static class RequestCreate {
		private Long buttonId;
		private String action;
		private String fontColor;
		private String buttonColor;
		private Integer borderRadius;
		private String buttonText;
		private String buttonDetails;
		private String icon;
		private String iconColor;
	}
	
}


