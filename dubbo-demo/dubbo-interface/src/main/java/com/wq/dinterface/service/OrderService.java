package com.wq.dinterface.service;

import com.wq.dinterface.entity.UserAddress;

import java.util.List;

public interface OrderService {
	
	public List<UserAddress> initOrder(String userId);

}