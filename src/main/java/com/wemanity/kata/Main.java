package com.wemanity.kata;

import com.wemanity.kata.core.Amount;
import com.wemanity.kata.core.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.time.LocalDateTime.*;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		BankAccount account = new BankAccount(now(), Amount.of(0));

		account.deposit(Amount.of(5));
		account.withdraw(Amount.of(3));

		try {
			account.withdraw(Amount.of(10));
		} catch(Exception e) {
			logger.error("" + e);
		}

		account.getOperations().forEach(operation -> logger.info(operation.toString()));
	}
}
