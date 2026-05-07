package edu.ecom_e3.dto.response;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PagedResponseDto<T> {
	private List<T> content;
	private int pageNumber;
	private int size;
	private long totalElements;
	private int totalPages;
	
	public static <T> PagedResponseDto<T> buildPage(Page<T> page){
		return PagedResponseDto.<T>builder()
				.content(page.getContent())
				.pageNumber(page.getNumber())
				.size(page.getSize())
				.totalElements(page.getTotalElements())
				.totalPages(page.getTotalPages()) 
				.build();
	} 
}
