package com.example.project.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("ProductListDTO")
@Component
public class ProductListDTO {
	
	ProductDTO productDTO;
	ImageDTO imageDTO;
	CategoryDTO categoryDTO;

}
