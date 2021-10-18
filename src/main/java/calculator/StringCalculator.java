package calculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

class StringCalculator {
	static int count=0;
	public int add(String s) {
		count++;
		
//		return 0 if string is empty
		if (s.length() == 0)
			return 0;
//		if String ends with characters throw exception 
		if (s.charAt(s.length() - 1) < 48 || s.charAt(s.length() - 1) > 57)
			throw new IllegalArgumentException("invalid String");
		String delimiter = "\n|,";
//		check for custom delimiter 
		if (s.startsWith("//")) {
			String arr3[] = addCustomDelimiter(s).split(",");
			s = s.substring(s.indexOf("\n") + 1);
			delimiter = "\n";
			for (String d : arr3)
				delimiter += "|" + Pattern.quote(d);
		}
		String arr[] = s.split(delimiter);
		return getSum(arr);
	}

	private String addCustomDelimiter(String s) {
		String delimiter = "";
//		check if there are multiple delimiters within [ ]
		if (s.indexOf('[') != -1) {
			char arr[] = s.toCharArray();
			int indexOfDelimiter = s.lastIndexOf("]");
			int i = 3;
			while (i < indexOfDelimiter) {
				if (arr[i] == ']') {
					i++;
					delimiter += ",";
					continue;

				}
				if (arr[i] == '[') {
					i++;
					continue;
				}
				delimiter += arr[i];
				i++;
			}
		}
//		else single custom delimiter 
		else
			return delimiter + s.charAt(2);
		return delimiter;
	}

//	method to parse String into integer
	private int getSum(String[] arr) throws IllegalArgumentException {
		int sum = 0;
		ArrayList<Integer> negativeList = new ArrayList<>();
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			int num = Integer.parseInt(arr[i]);
			if (num >= 1000)
				continue;
			if (num < 0) {
				flag = true;
				negativeList.add(num);
			}
			sum = sum + num;
		}
		if (flag) {
			Iterator<Integer> itr = negativeList.iterator();
			String exceptionMsg = "";
			while (itr.hasNext())
				exceptionMsg += itr.next() + " ";
			throw new IllegalArgumentException("Negaive numbers not allowed " + exceptionMsg);
		}
		return sum;
	}
	
	public static int GetCalledCount() {	
		return count;
	}
}