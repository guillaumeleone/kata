package com.wemanity.kata;

import com.wemanity.kata.core.Amount;
import com.wemanity.kata.core.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static java.time.LocalDateTime.*;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		Amount amount = new Amount(ZERO);
		BankAccount account = new BankAccount(now(), amount);

		account.deposit(new Amount(new BigDecimal(5)));
		account.withdraw(new Amount(new BigDecimal(3)));

		try {
			account.withdraw(new Amount(new BigDecimal(10)));
		} catch(Exception e) {
			logger.error("" + e);
		}

		account.getOperations().forEach(operation -> logger.info(operation.toString()));
	}
}
