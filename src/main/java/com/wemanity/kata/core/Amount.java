package com.wemanity.kata.core;

import java.math.BigDecimal;
import java.util.Objects;

public class Amount implements Comparable<Amount> {

	private BigDecimal value;

	public static Amount of(double value) {
		return new Amount(new BigDecimal(value));
	}

	protected Amount(BigDecimal value) {
		Objects.requireNonNull(value);
		this.value = value;
	}

	public Amount add(Amount amount) {
		return new Amount(this.value.add(amount.value));
	}

	public Amount substract(Amount amount) {
		return new Amount(this.value.subtract(amount.value));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Amount amount = (Amount) o;
		return Objects.equals(value, amount.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "Amount{" +
				"value=" + value +
				'}';
	}

	public int compareTo(Amount o) {
		return this.value.compareTo(o.value);
	}
}