package calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

	@Test
	void empty_string_should_return_0() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(0, stringCalculator.add(""));
	}

	@Test
	void string_with_single_number_should_return_number_as_int() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(1, stringCalculator.add("1"));
	}
	
	@Test
	void string_with_two_number_should_return_sum_as_int() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(3, stringCalculator.add("1,2"));
	}
	
	@Test
	void string_with_greater_than_1000_number_should_return_sum_as_int() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(3, stringCalculator.add("1,2,1001"));
	}
	
	@Test
	void string_with_negative_number_should_comes_exception() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(-3, stringCalculator.add("-1,-2"));
	}

	@Test
	void testInputWithCommaDelimiter() {
		StringCalculator stringCalculator = new StringCalculator();
		int res = stringCalculator.add("//;\n1;2");
		assertEquals(res, 3);
	}

	@Test
	void testSingleCustomDelimiter() {
		StringCalculator stringCalculator = new StringCalculator();
		int res = stringCalculator.add("//;\n1;2");
		assertEquals(res, 3);
	}

	@Test
	void testMultiCustomDelimiter() {
		StringCalculator stringCalculator = new StringCalculator();
		int res = stringCalculator.add("//[*][%]\n1*2%3");
		assertEquals(res, 6);
	}

	@Test
	void testNumberGreaterThan1000() {
		StringCalculator stringCalculator = new StringCalculator();
		int res = stringCalculator.add("//[*][%]\n1000*2");
		assertEquals(res, 2);
	}

	@Test
	void testWithMultiCharachterDelimiter() {
		StringCalculator stringCalculator = new StringCalculator();
		int res = stringCalculator.add("//[***]\n1***2***3");
		assertEquals(res, 6);
	}
	
	@AfterAll
	static void returns_how_many_times_Add_method_was_invoked(){
		int res=StringCalculator.GetCalledCount();
		System.out.println("How many times Add() method was invoked : "+res);
	}
}
