package structure.java22.api.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum UserType {

    ADMIN("ADMIN"),
    AGENT("AGENT");

    private final String code;

    private static final Map<String, UserType> BY_VALUE = new HashMap<>();

    static {
        for (UserType userType : values()) {
            BY_VALUE.put(userType.getCode(), userType);
        }
    }

}
