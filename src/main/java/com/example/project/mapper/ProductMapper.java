package com.example.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.dto.ImageDTO;
import com.example.project.dto.ProductDTO;
import com.example.project.dto.ProductDetailDTO;
import com.example.project.dto.ProductListDTO;
import com.example.project.dto.ProductPageRequestDTO;
import com.example.project.dto.ProductPageRequestDTO;

@Mapper
public interface ProductMapper {
	
	public List<ProductDetailDTO> getOne(int product_img_id) throws Exception;
	public List<ProductListDTO> getProductList() throws Exception;
	public List<ProductListDTO> getProductListWithPaging(ProductPageRequestDTO productPageRequestDTO) throws Exception;
	public int totalRecord(ProductPageRequestDTO pageRequestDTO) throws Exception;
	public void productInsert(ProductDTO productDTO) throws Exception;
	public int productUpdate(ProductDTO productDTO) throws Exception;
	
	
}
