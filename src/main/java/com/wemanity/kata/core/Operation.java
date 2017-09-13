package com.wemanity.kata.core;

import java.time.LocalDateTime;

public class Operation {

	enum TYPE {
		DEPOSIT,
		WITHDRAWAL
	}

	private TYPE type;
	private LocalDateTime date;
	private Amount amount;
	private Amount balance;

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
