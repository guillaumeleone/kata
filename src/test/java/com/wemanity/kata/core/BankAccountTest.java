package com.wemanity.kata.core;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static java.time.LocalDateTime.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

	@Test(expected = NullPointerException.class)
	public void should_throw_NPE_when_there_is_a_null_attribute() {
		new BankAccount(null, null);
	}

	@Test
	public void should_return_10_when_deposit_an_amount_of_10() {

		Amount amount = new Amount(ZERO);
		BankAccount account = new BankAccount(now(), amount);

		account.deposit(new Amount(TEN));

		assertThat(account.getBalance()).isEqualTo(new Amount(TEN));
	}

	@Test
	public void should_return_0_when_withdraw_an_amount_of_10() {

		Amount amount = new Amount(TEN);
		BankAccount account = new BankAccount(now(), amount);

		account.withdraw(new Amount(TEN));

		assertThat(account.getBalance()).isEqualTo(new Amount(ZERO));
	}

	@Test(expected = IllegalStateException.class)
	public void should_throw_exception_when_bank_account_doesnt_have_enough_money() {

		Amount amount = new Amount(ZERO);
		BankAccount account = new BankAccount(now(), amount);

		account.withdraw(new Amount(TEN));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_throw_exception_when_deposit_a_negative_amount() {

		Amount amount = new Amount(ZERO);
		BankAccount account = new BankAccount(now(), amount);

		account.deposit(new Amount(new BigDecimal(-1)));
	}


	@Test(expected = IllegalArgumentException.class)
	public void should_throw_exception_when_withdraw_a_negative_amount() {

		Amount amount = new Amount(ZERO);
		BankAccount account = new BankAccount(now(), amount);

		account.withdraw(new Amount(new BigDecimal(-1)));
	}

	@Test
	public void should_save_operations_when_deposit_or_withdraw_an_amount() {

		Amount amount = new Amount(ZERO);
		BankAccount account = new BankAccount(now(), amount);

		account.deposit(new Amount(new BigDecimal(5)));
		account.withdraw(new Amount(new BigDecimal(3)));

		assertThat(account.getOperations()).isNotNull().isNotEmpty();
		assertThat(account.getOperations())
				.extracting("type")
				.contains(
						Operation.TYPE.DEPOSIT,
						Operation.TYPE.WITHDRAWAL
				);

	}
}