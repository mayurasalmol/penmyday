package com.msa.jbk.model;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {
	private int orderNum;

	private CustomerInfo customerInfo;

	private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();

	public CartInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public List<CartLineInfo> getCartLines() {
		return cartLines;
	}

	private CartLineInfo findLineByCode(String code) {
		for (CartLineInfo line : this.cartLines) {
			if (line.getProductInfo().getCode().equals(code)) {
				return line;
			}
		}
		return null;
	}

	public void addProduct(ProductInfo productInfo, int quantity) {
		CartLineInfo cartLineInfo = this.findLineByCode(productInfo.getCode());

		if (cartLineInfo == null) {
			cartLineInfo = new CartLineInfo();
			cartLineInfo.setQuantity(0);
			cartLineInfo.setProductInfo(productInfo);
			this.cartLines.add(cartLineInfo);
		}

		int newQunatity = cartLineInfo.getQuantity() + quantity;
		if (newQunatity <= 0) {
			this.cartLines.remove(cartLineInfo);
		} else {
			cartLineInfo.setQuantity(newQunatity);
		}
	}

	public void validate() {
	}

	public void updateProduct(String code, int quantity) {
		CartLineInfo cartLineInfo = this.findLineByCode(code);
		if (cartLineInfo != null) {
			if (quantity <= 0) {
				this.cartLines.remove(cartLineInfo);
			} else {
				cartLineInfo.setQuantity(quantity);
			}
		}
	}

	public void removeProduct(ProductInfo productInfo) {
		CartLineInfo cartLineInfo = this.findLineByCode(productInfo.getCode());
		if (cartLineInfo != null) {
			this.cartLines.remove(cartLineInfo);
		}
	}

	public boolean isEmpty() {
		return this.cartLines.isEmpty();
	}

	public boolean isValidCustomer() {
		return this.customerInfo != null && this.customerInfo.isValid();
	}

	public int getQuantityTotal() {
		int quantity = 0;
		for (CartLineInfo cartLineInfo : this.cartLines) {
			quantity = quantity + cartLineInfo.getQuantity();
		}
		return quantity;
	}

	public double getAmountTotal() {
		double total = 0;
		for (CartLineInfo cartLineInfo : this.cartLines) {
			total += cartLineInfo.getAmount();
		}
		return total;
	}

	public void updateQuantity(CartInfo cartInfo) {
		if (cartInfo != null) {
			List<CartLineInfo> lines = cartInfo.getCartLines();
			for (CartLineInfo cartLineInfo : lines) {
				this.updateProduct(cartLineInfo.getProductInfo().getCode(), cartLineInfo.getQuantity());
			}
		}
	}
}
