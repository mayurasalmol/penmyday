package com.msa.jbk.dao;

import com.msa.jbk.entity.Account;

public interface AccountDAO {
	public Account findAccount(String userName);
}
