package com.wemanity.kata.core;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

	@Test(expected = NullPointerException.class)
	public void should_throw_NPE_when_amount_is_null() {
		new Amount(null);
	}

	@Test
	public void should_return_11_when_add_an_amount_of_value_10() {

		Amount amount = new Amount(ONE);
		Amount amount2 = new Amount(TEN);

		Amount total = amount.add(amount2);

		assertThat(total)
				.isNotNull()
				.isEqualTo(new Amount(new BigDecimal(11)));
	}

	@Test
	public void should_return_9_when_substract_an_amount_of_value_10() {

		Amount amount = new Amount(ONE);
		Amount amount2 = new Amount(TEN);

		Amount total = amount2.substract(amount);

		assertThat(total)
				.isNotNull()
				.isEqualTo(new Amount(new BigDecimal(9)));
	}

	@Test
	public void should_return_minus_one_when_the_amount1_is_less_than_amount2() {

		Amount amount1 = new Amount(ONE);
		Amount amount2 = new Amount(TEN);

		assertThat(amount1.compareTo(amount2)).isEqualTo(-1);
	}

	@Test
	public void should_return_one_when_the_amount2_is_more_than_amount1() {

		Amount amount1 = new Amount(ONE);
		Amount amount2 = new Amount(TEN);

		assertThat(amount2.compareTo(amount1)).isEqualTo(1);
	}

	@Test
	public void should_return_0_when_the_amounts_are_equals() {
		Amount amount = new Amount(ONE);
		assertThat(amount.compareTo(amount)).isEqualTo(0);
	}
}