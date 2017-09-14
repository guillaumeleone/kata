package com.wemanity.kata.core;

import java.time.LocalDateTime;

public class Operation {

	enum TYPE {
		DEPOSIT,
		WITHDRAWAL
	}

	private final TYPE type;
	private final LocalDateTime date;
	private final Amount amount;
	private final Amount balance;

	public Operation(TYPE type, LocalDateTime date, Amount amount, Amount balance) {
		this.type = type;
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Operation{" +
				"type=" + type +
				", date=" + date +
				", amount=" + amount +
				", balance=" + balance +
				'}';
	}
}
