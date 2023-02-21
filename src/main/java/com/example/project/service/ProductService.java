package com.example.project.service;

import java.util.List;

import com.example.project.dto.ImageDTO;
import com.example.project.dto.ProductDTO;
import com.example.project.dto.ProductDetailDTO;
import com.example.project.dto.ProductListDTO;
import com.example.project.dto.ProductPageRequestDTO;
import com.example.project.dto.ProductPageResultDTO;

public interface ProductService {
	
	public List<ProductDetailDTO> getOne(int product_id) throws Exception;
	public List<ProductListDTO> getProductList() throws Exception;
//	public List<ProductListDTO> getProductListWithPaging(ProductPageRequestDTO productPageRequestDTO) throws Exception;
	public ProductPageResultDTO getProductListWithPaging(ProductPageRequestDTO requestDTO) throws Exception;
	public void productInsert(ProductDTO productDTO) throws Exception;
	public void productUpdate(ProductDTO productDTO) throws Exception;
}
