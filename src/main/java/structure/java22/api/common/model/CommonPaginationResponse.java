package structure.java22.api.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import structure.java22.api.common.StatusResponseCode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonPaginationResponse<T> {
    @Builder.Default
    protected String statusCode = StatusResponseCode.SUCCESS.getCode();
    @Builder.Default
    protected String message = StatusResponseCode.SUCCESS.getMessage();
    protected T data;
    protected Pagination pagination;
}
