package structure.java22.api.common.utils;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import structure.java22.api.common.model.Pagination;
import structure.java22.api.common.model.PaginationRequest;

@Getter
@Setter
@Log4j2
@Component
public class PaginationUtils {

    public static Pageable convertToPageable(PaginationRequest pagination) {
        return PageRequest.of(pagination.getPage()-1,pagination.getLength(),  pagination.getSortDirection(), pagination.getSortProperty());
    }

    public static Pageable convertToPageableMerge(PaginationRequest pagination) {
        return PageRequest.of(pagination.getPage()-1,pagination.getLength(),  pagination.getSortDirection(), pagination.getSortProperty());
    }

    public static Pagination convertToPagination(Pageable pageable, Page<?> page) {
        return Pagination.builder()
                .page(pageable.getPageNumber() + 1)
                .length(pageable.getPageSize())
                .totalPages(page.getTotalPages())
                .totalData(page.getTotalElements())
                .build();

    }
    public static Pagination convertToPaginationMerge(Pageable pageable, int size) {
        return Pagination.builder()
                .page(pageable.getPageNumber() + 1)
                .length(pageable.getPageSize())
                .totalPages(size/pageable.getPageSize())
                .totalData(size)
                .build();
    }

}
