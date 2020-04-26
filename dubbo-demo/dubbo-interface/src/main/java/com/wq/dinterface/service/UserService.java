package com.wq.dinterface.service;

import com.wq.dinterface.entity.UserAddress;

import java.util.List;

public interface UserService {
	
	public List<UserAddress> getUserAddressList(String userId);

}