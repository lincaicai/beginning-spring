package com.base.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//注解@Service将类定义为一个Bean
//默认情况下Bean名称派生自简单的类名单首字母小写
@Service
public class AccountServiceImpl implements AccountService {
	private AccountDao accountDao;
	
	//在两个对象之间移动给定数额的资金
	public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
		Account sourceAccount = accountDao.find(sourceAccountId);
		Account targetAccount = accountDao.find(targetAccountId);
		sourceAccount.setBalance(sourceAccount.getBalance() - amount);
		targetAccount.setBalance(targetAccount.getBalance() + amount);
		accountDao.update(sourceAccount);
		accountDao.update(targetAccount);
	}

	
	public void depositMoney(long accountId, double amount) throws Exception {
		Account account = accountDao.find(accountId);
		account.setBalance(account.getBalance() + amount);
		accountDao.update(account);
	}

	public Account getAccount(long accountId) {
		return accountDao.find(accountId);
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	//@Autowired告诉Spring，如果在容器中指定的依赖项可用，则应该满足该依赖项
	//所以Spring会首先检查Setter方法的输入参数类型，然后查找复合该类型的Spring管理的Bean
	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	

}
