package com.msa.jbk.dao;

import java.util.List;

import com.msa.jbk.model.CartInfo;
import com.msa.jbk.model.OrderDetailInfo;
import com.msa.jbk.model.OrderInfo;
import com.msa.jbk.model.PaginationResult;

public interface OrderDAO {
	public void saveOrder(CartInfo cartInfo);

	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);

	public OrderInfo getOrderInfo(String orderId);

	public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
}
