package edu.springboot_e4.dto.response;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagedResponseDto<T> {
	private List<T> data;
	private int page;
	private int size;
	private long totalElements;
	private int totalPages;
	
	public static <T>PagedResponseDto<T> buildPagedDto(Page<T> p){
		return PagedResponseDto.<T>builder()
				.data(p.getContent())
				.page(p.getNumber())
				.size(p.getSize())
				.totalElements(p.getTotalElements())
				.totalPages(p.getTotalPages())
				.build();
	}
}
