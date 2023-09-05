package com.alura.hotelalura.test;

import com.alura.hotelalura.utils.Format;

public class FormatTest {

	public static void main(String[] args) {

		System.out.println(Format.isValidNumber("20"));
		System.out.println(Format.isValidString("pedro"));
		System.out.println(Format.isValidDate("2023-06-03"));
		System.out.println(Format.capitalize("nombre"));
	}

}
