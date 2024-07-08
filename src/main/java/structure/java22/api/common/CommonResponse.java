package structure.java22.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {
    @Builder.Default
    protected String statusCode = StatusResponseCode.SUCCESS.getCode();
    @Builder.Default
    protected String message = StatusResponseCode.SUCCESS.getMessage();
    protected T data;
    protected Integer draw;
    protected Integer recordsTotal;
    protected Integer page;
}
