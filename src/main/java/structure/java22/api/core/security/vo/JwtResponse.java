package structure.java22.api.core.security.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import structure.java22.api.common.UserType;

import java.util.List;


@UtilityClass
public class JwtResponse {

	@Getter
    @Setter
    public static class Response  {
		private String token;
		private String username;
		private String firstName;
		private String nickName;
		private String lastName;
		private String mobile;
		private String agentGroupName;
		private String email;
		private Boolean active;
		private UserType userType;
		private RolePermissionResponse userRole;
    }
	
	@Getter
    @Setter
    public static class RolePermissionResponse  {
		    private String title;
		    private String slug;
		    private String description;
		    private boolean active;
		    private List<PermissionResponse>  permissionResponse;
    }
	
	
	@Getter
    @Setter
    public static class PermissionResponse  {
		    private String title;
		    private String slug;
		    private String description;
		    private boolean active;
    }

	@Getter
	@Setter
	public static class Version  {
		private String version;
	}


	
}
