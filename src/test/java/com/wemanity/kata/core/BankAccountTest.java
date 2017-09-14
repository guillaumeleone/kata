package com.wemanity.kata.core;

import org.junit.Test;

import static java.time.LocalDateTime.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

	@Test(expected = NullPointerException.class)
	public void should_throw_NPE_when_there_is_a_null_attribute() {
		new BankAccount(null, null);
	}

	@Test
	public void should_return_10_when_deposit_an_amount_of_10() {

		Amount amount = Amount.of(0);
		BankAccount account = new BankAccount(now(), amount);

		account.deposit(Amount.of(10));

		assertThat(account.getBalance()).isEqualTo(Amount.of(10));
	}

	@Test
	public void should_return_0_when_withdraw_an_amount_of_10() {

		Amount amount = Amount.of(10);
		BankAccount account = new BankAccount(now(), amount);

		account.withdraw(Amount.of(10));

		assertThat(account.getBalance()).isEqualTo(Amount.of(0));
	}

	@Test(expected = IllegalStateException.class)
	public void should_throw_exception_when_bank_account_doesnt_have_enough_money() {

		Amount amount = Amount.of(0);
		BankAccount account = new BankAccount(now(), amount);

		account.withdraw(Amount.of(10));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_throw_exception_when_deposit_a_negative_amount() {

		Amount amount = Amount.of(0);
		BankAccount account = new BankAccount(now(), amount);

		account.deposit(Amount.of(-1));
	}


	@Test(expected = IllegalArgumentException.class)
	public void should_throw_exception_when_withdraw_a_negative_amount() {

		Amount amount = Amount.of(0);
		BankAccount account = new BankAccount(now(), amount);

		account.withdraw(Amount.of(-1));
	}

	@Test
	public void should_save_operations_when_deposit_or_withdraw_an_amount() {

		Amount amount = Amount.of(0);
		BankAccount account = new BankAccount(now(), amount);

		account.deposit(Amount.of(5));
		account.withdraw(Amount.of(3));

		assertThat(account.getOperations()).isNotNull().isNotEmpty();
		assertThat(account.getOperations())
				.extracting("type")
				.contains(
						Operation.TYPE.DEPOSIT,
						Operation.TYPE.WITHDRAWAL
				);

	}
}