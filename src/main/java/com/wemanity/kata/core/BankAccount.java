package com.wemanity.kata.core;

import com.wemanity.kata.core.Operation.TYPE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.wemanity.kata.core.Operation.TYPE.*;
import static java.math.BigDecimal.*;
import static java.time.LocalDateTime.*;

public class BankAccount {

	private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

	private LocalDateTime date;
	private Amount balance;
	private List<Operation> operations = new ArrayList<Operation>();

	public BankAccount(LocalDateTime date, Amount balance) {
		Objects.requireNonNull(date);
		Objects.requireNonNull(balance);
		this.date = date;
		this.balance = balance;
	}

	public void deposit(Amount amount) {
		checkIfAmountIsPositive(amount);
		this.balance = this.balance.add(amount);
		saveOperation(DEPOSIT, now(), amount, balance);
		logger.debug("Balance: {}", this.balance);
	}

	public void withdraw(Amount amount) {
		checkIfAmountIsPositive(amount);
		checkIfBalanceIsPositive(amount);
		this.balance = this.balance.substract(amount);
		saveOperation(WITHDRAWAL, now(), amount, balance);
		logger.debug("Balance: {}", this.balance);
	}

	private void saveOperation(TYPE type, LocalDateTime date, Amount amount, Amount balance) {
		this.operations.add(new Operation(type, date, amount, balance));
	}

	private void checkIfAmountIsPositive(Amount amount) {
		if (amount.compareTo(new Amount(ZERO)) < 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}
	}

	private void checkIfBalanceIsPositive(Amount amount) {
		if (this.balance.compareTo(amount) < 0) {
			throw new IllegalStateException("You don't have enough money");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BankAccount account = (BankAccount) o;
		return Objects.equals(date, account.date) &&
				Objects.equals(balance, account.balance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, balance);
	}

	@Override
	public String toString() {
		return "BankAccount{" +
				"date=" + date +
				", balance=" + balance +
				'}';
	}

	public Amount getBalance() {
		return balance;
	}

	public List<Operation> getOperations() {
		return operations;
	}
}