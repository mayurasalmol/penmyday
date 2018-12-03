package com.msa.jbk.dao;

import com.msa.jbk.entity.Product;
import com.msa.jbk.model.PaginationResult;
import com.msa.jbk.model.ProductInfo;

public interface ProductDAO {
	public Product findProduct(String code);

	public ProductInfo findProductInfo(String code);

	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage);

	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName);

	public void save(ProductInfo productInfo);
}
