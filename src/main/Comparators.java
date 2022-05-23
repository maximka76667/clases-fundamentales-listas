package main;

import java.util.Comparator;

public class Comparators {

	public static final Comparator<String> alfa = (String s1, String s2) -> s1.compareTo(s2);

	public static final Comparator<String> tamano = (String s1, String s2) -> s1.length() - s2.length();
	
}
