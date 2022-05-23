package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

//		1
//		LinkedList<Integer> listaNumeros = new LinkedList<Integer>();
//		System.out.println("Leer lista");
//		leerLista(listaNumeros);
//		System.out.println(listaNumeros);

//		2
//		LinkedList<Integer> listaNumerosN = new LinkedList<Integer>();
//		System.out.println("\nLeer lista N");
//		leerListaN(listaNumerosN, 5);
//		System.out.println(listaNumerosN);

//		3
//		LinkedList<Integer> clasificarOrigen = new LinkedList<Integer>();
//		clasificarOrigen.add(-1);
//		clasificarOrigen.add(5);
//		clasificarOrigen.add(3);
//		clasificarOrigen.add(-14);
//		clasificarOrigen.add(0);
//
//		LinkedList<Integer> pos = new LinkedList<Integer>();
//		LinkedList<Integer> neg = new LinkedList<Integer>();
//
//		clasificarNumeros(clasificarOrigen, pos, neg);
//
//		System.out.println("Array origen: " + clasificarOrigen);
//		System.out.println("Positivos: " + pos);
//		System.out.println("Negativos: " + neg);

//		4
//		System.out.println("\nEleminar Repetidos");
//		LinkedList<Integer> repetidosOrigen = listaNumerosN;
//		LinkedList<Integer> repetidosFin = eliminarRepetidos(repetidosOrigen);
//
//		System.out.println("Origen: " + repetidosOrigen);
//		System.out.println("Fin: " + repetidosFin);

//		5
		String[] arrayPalabrasAlfa = {"Abc", "Maxim", "Programación", "C"};
		LinkedList<String> listaPalabrasAlfa = new LinkedList<String>(Arrays.asList(arrayPalabrasAlfa));
		ordenarListaPalabras(listaPalabrasAlfa);
		System.out.println(listaPalabrasAlfa);
		
//		6
		String[] arrayPalabrasTamano = {"Abc", "Maxim", "Programación", "C"};
		LinkedList<String> listaPalabrasTamano = new LinkedList<String>(Arrays.asList(arrayPalabrasTamano));
		ordenarListaPalabras2(listaPalabrasTamano);
		System.out.println(listaPalabrasTamano);
		
//		7
		System.out.println(sorteoBonoloto());	
	
		input.close();

	}

//	1
	public static void leerLista(LinkedList<Integer> lista) {
		int num = 0;
		while (true) {
			System.out.print("Inserta un nuevo número: ");
			num = input.nextInt();
			if (num == -1)
				break;
			lista.add(num);
		}
		System.out.println("Insertación completada");
	}

//	2
	public static void leerListaN(LinkedList<Integer> lista, int N) {
		int num = 0;
		for (int i = 0; i < N; i++) {
			System.out.print("Inserta un nuevo número: ");
			num = input.nextInt();
			lista.add(num);
		}
		System.out.println("Insertación completada");
	}

//	3
	public static void clasificarNumeros(LinkedList<Integer> origen, LinkedList<Integer> pos, LinkedList<Integer> neg) {
		for (int num : origen) {
			if (num < 0)
				neg.add(num);
			if (num > 0)
				pos.add(num);
		}

		Collections.sort(pos);
		Collections.sort(neg);
	}

//	4
	private static LinkedList<Integer> eliminarRepetidos(LinkedList<Integer> origen) {
		LinkedList<Integer> resultado = new LinkedList<Integer>();
		for (int num : origen) {
			if (resultado.contains(num)) continue;
			resultado.add(num);
		}
		return resultado;
	}
	
//	5
	private static void ordenarListaPalabras(LinkedList<String> listaPalabras) {
		Collections.sort(listaPalabras, Comparators.alfa);
	}
	
//	6
	private static void ordenarListaPalabras2(LinkedList<String> listaPalabras) {
		Collections.sort(listaPalabras, Comparators.tamano);
	}
	
//	7
	private static LinkedList<Integer> sorteoBonoloto() {
		LinkedList<Integer> sorteo = new LinkedList<Integer>();
		LinkedList<Integer> ganadores = new LinkedList<Integer>();
		
		for(int i = 0; i < 50; i++) sorteo.add(i);
		
		for(int i = 0; i < 6; i++) {
			int pos = (int) Math.floor(Math.random() * sorteo.size());
			ganadores.add(sorteo.get(pos));
			sorteo.remove(pos);
		}
		
		return ganadores;
	}

}
