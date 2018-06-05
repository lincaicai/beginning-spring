package com.base.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

//注解@Repository能够启用与Spring数据访问相关联的其他功能
//默认情况下Bean名称派生自简单的类名单首字母小写
@Repository
public class AccountDaoInMemoryImpl implements AccountDao{
	
	private Map<Long, Account> accountsMap = new HashMap<Long, Account>();
	
	{
		Account account1 = new Account();
		account1.setId(1L);
		account1.setOwnerName("Jhon");
		account1.setBalance(10.0);
		
		Account account2 = new Account();
		account2.setId(2L);
		account2.setOwnerName("Mary");
		account2.setBalance(20.0);
		
		accountsMap.put(account1.getId(), account1);
		accountsMap.put(account2.getId(), account2);
	}

	public void insert(Account account) {
		accountsMap.put(account.getId(), account);
	}

	public void update(Account account) {
		accountsMap.put(account.getId(), account);
	}

	public void update(List<Account> accounts) {
		for(Account account:accounts)
		{
			update(account);
		}
	}

	public void delete(long accountId) {
		accountsMap.remove(accountId);
	}

	public Account find(long accountId) {
		return accountsMap.get(accountId);
	}

	public List<Account> find(List<Long> accountIds) {
		List<Account> accounts = new ArrayList<Account>(); 
		for(Long id:accountIds)
		{
			accounts.add(accountsMap.get(id));
		}
		return accounts;
	}

	public List<Account> find(String ownerName) {
		List<Account> accounts = new ArrayList<Account>();
		for(Account account:accountsMap.values())
		{
			if(ownerName.equals(account.getOwnerName()))
			{
				accounts.add(account);
			}
		}
		return accounts;
	}

	public List<Account> find(boolean locked) {
		List<Account> accounts = new ArrayList<Account>();
		for(Account account:accountsMap.values())
		{
			if(locked == account.isLocked())
			{
				accounts.add(account);
			}
		}
		return accounts;
	}

}
