package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
//		String[] arrayPalabrasAlfa = { "Abc", "Maxim", "Programación", "C" };
//		LinkedList<String> listaPalabrasAlfa = new LinkedList<String>(Arrays.asList(arrayPalabrasAlfa));
//		ordenarListaPalabras(listaPalabrasAlfa);
//		System.out.println(listaPalabrasAlfa);

//		6
//		String[] arrayPalabrasTamano = { "Abc", "Maxim", "Programación", "C" };
//		LinkedList<String> listaPalabrasTamano = new LinkedList<String>(Arrays.asList(arrayPalabrasTamano));
//		ordenarListaPalabras2(listaPalabrasTamano);
//		System.out.println(listaPalabrasTamano);

//		7
//		System.out.println(sorteoBonoloto());

//		8
		LinkedList<Integer> interseccionLista1 = new LinkedList<Integer>();
		interseccionLista1.add(1);
		interseccionLista1.add(2);
		interseccionLista1.add(5);

		LinkedList<Integer> interseccionLista2 = new LinkedList<Integer>();
		interseccionLista2.add(2);
		interseccionLista2.add(5);
		interseccionLista2.add(14);
		interseccionLista2.add(10);

		LinkedList<Integer> interseccionListaResultado = interseccionListas(interseccionLista1, interseccionLista2);
		System.out.println(interseccionListaResultado);

//		9
		LinkedList<Integer> listaOrdenada = new LinkedList<Integer>();
		listaOrdenada.add(1);
		listaOrdenada.add(2);
		listaOrdenada.add(3);
		listaOrdenada.add(4);
		listaOrdenada.add(5);
		listaOrdenada.add(6);
		listaOrdenada.add(7);

		LinkedList listaDesordenada = desordenarLista(listaOrdenada);

		System.out.println(listaDesordenada);

//		10
		LinkedList<Double> puntuaciones = new LinkedList<Double>();
		double[] puntuacionesArray = { 15.0, 20.0, 40.0, 25.0, 5.0, 50.0, 60.0 };

		for (int i = 0; i < puntuacionesArray.length; i++) {
			puntuaciones.add(puntuacionesArray[i]);
		}

		System.out.println(puntuaciones);
		double puntuacionFinal = puntuacionesTrampolin(puntuaciones);
		System.out.println(puntuacionFinal);
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
			if (resultado.contains(num))
				continue;
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

		for (int i = 0; i < 50; i++)
			sorteo.add(i);

		for (int i = 0; i < 6; i++) {
			int pos = (int) Math.floor(Math.random() * sorteo.size());
			ganadores.add(sorteo.get(pos));
			sorteo.remove(pos);
		}

		return ganadores;
	}

//	8
	private static LinkedList interseccionListas(LinkedList lista1, LinkedList lista2) {
		LinkedList resultado = new LinkedList();
		for (Object el : lista1) {
			if (lista2.contains(el))
				resultado.add(el);
		}
		return resultado;
	}

//	9
	private static LinkedList desordenarLista(LinkedList lista) {
		LinkedList resultado = new LinkedList();
		int tamanoOrigen = lista.size();
		for (int i = 0; i < tamanoOrigen; i++) {
			int pos = (int) Math.floor(Math.random() * lista.size());
			resultado.add(lista.get(pos));
			lista.remove(pos);
		}
		return resultado;
	}

//	10
	private static double puntuacionesTrampolin(LinkedList<Double> puntuaciones) {
		Collections.sort(puntuaciones);
		
		List<Double> puntosRestantes = puntuaciones.subList(2, 5);

		System.out.println(puntosRestantes);
		
		double suma = 0;

		for (double puntuacion : puntosRestantes) {
			suma += puntuacion;
		}

		return suma;
	}

}
