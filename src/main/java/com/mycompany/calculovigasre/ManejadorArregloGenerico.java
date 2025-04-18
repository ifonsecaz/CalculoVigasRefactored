package com.mycompany.calculovigasre;

import java.util.ArrayList;

	/*Fonseca Zarate Israel
	 * Septiembre 2018
	 * arreglos
	 */

public class ManejadorArregloGenerico {

		
	public static <T extends Comparable <T>> int posMayor(T[] a, int n) {
		int posM =0;
			
		for(int i=1; i<n; i++) {
			if (a[posM].compareTo(a[i])<0) {
				posM=i;
			}
		}
			
		return posM;
	}
		
	public static <T extends Comparable <T>>int posMenor(T[] a, int n) {
		int posM = 0;
			
			
		for(int i=1; i<n; i++) {
			if(a[posM].compareTo(a[i])>0) {
				posM=i;
			}
		}
		return posM;
	}
		
	public static <T extends Comparable<T>> int cuantosMayX(T[] a, int n, T num) {
		int cuantos=0;
			
		for (int i=0; i<n; i++) {
			if(num.compareTo(a[i])<0) {
				cuantos++;
			}
		}
		return cuantos;
	}
		
	public static <T extends Comparable<T>> int cuantosMenX(T[] a, int n, T num) {
		int cuantos=0;
		
		for (int i=0; i<n; i++) {
			if(num.compareTo(a[i])>0) {
				cuantos++;
			}
		}
		return cuantos;
	}
		
	public static <T extends Comparable<T>> ArrayList<Integer> cualesMayX(T[] a, int n, T num){
		ArrayList<Integer> res = new ArrayList<Integer>();
			
		for(int i=0; i<n; i++) {
			if(num.compareTo(a[i])<0) {
				res.add(i);
			}
		}
			
		return res;
	}
		
	public static <T extends Comparable<T>> ArrayList<Integer> cualesMenX(T[] a, int n, T num){
		ArrayList<Integer> res= new ArrayList<Integer>();
		
		for (int i=0; i<n; i++) {
			if(a[i].compareTo(num)<0) {
				res.add(i);
			}
		}
		return res;
	}
		
	public static <T> void swap(T[] a, int n1, int n2) {
		T num1;
		
		num1=a[n1];
			
		a[n1]=a[n2];
		a[n2]=num1;
	}
		
	public static <T> void invierte(T[] a, int n) {
			
		for (int i=0; i<n/2; i++) {
			swap(a,i,n-i-1);
		}
	}
		
	public static <T>void corrimientosDer(T [] a, int n, int k) {
			
			
		for(int j=0;j<k;j++) {
				
			for(int i=1;i<n;i++) {
				swap(a,n-i,n-1-i);
			}	
			a[0]=null;
		}
	}
		
	public static <T>void corrimientosIzq(T [] a, int n, int k) {
		
		for(int j=0;j<k;j++) {
					
			for(int i=1;i<n;i++) {
				swap(a,i-1,i);
			}	
			a[n-1]=null;
		}
	}
		
		
	public static <T extends Comparable<T>>int posMinimo(T []a, int n, int ind) {
		int posM = ind;
		
			
		for(int i=ind; i<n; i++) {
			if(a[posM].compareTo(a[i])>0) {
				posM=i;
			}
		}
		return posM;
	}
		
	public static <T extends Comparable<T>>void seleccionDirecta(T []a, int n) {
					
		for(int i=0; i<n-1; i++) {
			swap(a,i,posMinimo(a,n,i));
		}
	}
		
	public static <T extends Comparable<T>>void seleccionDirectaMayAMen(T []a, int n) {
		int posM;
		T ind;
			
		for(int i=0; i<n-1; i++) {
			posM=i;
			for(int j=i+1; j<n; j++) {
				if(a[posM].compareTo(a[j])<0) {
					posM=j;
				}
			}
			ind=a[i];
			a[i]=a[posM];
			a[posM]=ind;
		}
	}
		
	public static <T extends Comparable<T>>int busquedaSecuencialDesordenada(T[]a,int n, T x) {
		int i=0;
		int pos;
		
		while(i<n && !a[i].equals(x)) {
			i++;
		}
		
		if(i==n) {
			pos=-1;
		}
		else {
			pos=i;
		}
		return pos;
	}
	
	public static <T extends Comparable<T>>int busSecOrd(T[]a, int n, T x) {
		int i=0;
		int pos;
		
		while(i<n && a[i].compareTo(x)<0) {
			i++;
		}
			
		if(i==n || !a[i].equals(x)) {
			pos=-i-1;
		}
		else {
			pos=i;
		}
		return pos;
	}
		
	public static <T extends Comparable<T>>int busquedaBinaria(T []a, int n, T x) {
		int inicio=0;
		int fin=n-1;
		int mitad;
		int pos;
		
		mitad=(fin-inicio)/2;
		
		while(!x.equals(a[mitad]) && inicio<=fin) {
			if(x.compareTo(a[mitad])>0) {
				inicio=mitad+1;
			
			}
			else {
				fin=mitad+1;
			}
			mitad=inicio+(fin-inicio)/2;
		}
		if(a[mitad].equals(x)) {
			pos=mitad;
		}
		else {
			if(a[mitad].compareTo(x)<0) {
				pos=-mitad;
			}
			else {
				pos=-mitad-1;
			}
		}
		return pos;		
	}
	
	public static <T> void unCorrimientoDer(T[] a, int n, int k) {
		int ind1=n;
		int ind2=n-1;
		
		for(int i=k; i<n-1; i++) {
			swap(a,ind1,ind2);
			ind1--;
			ind2--;
		}
	}
	
	public static <T>void unCorrimientoIzq(T[]a, int n, int k){
		int ind1=k;
		int ind2=k+1;
		
		for(int i=k; i<n-1; i++) {
			swap(a,ind1,ind2);
			ind1++;
			ind2++;
		}
		a[n-1]=null;
	}
	
	private static <T> int inserta (T[]a, int n, int pos, T b) {
		int res=n;
	
		if(n<a.length) {
			unCorrimientoDer(a,n,pos);
			a[pos]=b;
			res++;
		}
		return res;
	}
	
	private static <T> int elimina (T[]a, int n, int pos, T b) {
		int res=n;
		
		
		unCorrimientoIzq(a,n,pos);
		res--;
		a[res]=null;
		
		
		return res;
	}
	
	public static <T extends Comparable<T>> int insertaEnOrden(T[]a, int n, T x) {
		int res=n;
		int pos;
		
	
		pos=busSecOrd(a, n, x);
			
		if(pos<0) {
			res=inserta(a,n,(pos*-1)-1,x);
		}
		
		return res;
	}
	
	public static <T> int insertaAlFinal(T[]a, int n, T x) {
		int res=n;
		
		
		res=inserta(a,n,n,x);
		
		return res;
	}
	
	public static <T> int insertaAlInicio(T[]a, int n, T x) {
		int res=n;
		
	
		res=inserta(a,n,0,x);
		
		return res;
	}
	
	public static <T extends Comparable<T>> int eliminaOrdenado(T[]a, int n, T x){
		int res=n;
		int pos;
		
		pos=busSecOrd(a, n, x);
		if(pos>=0) {
			res=elimina(a,n,pos,x);
		}
		
		return res;
	}
	
	public static <T extends Comparable<T>> int eliminaDesordenado(T[]a, int n, T x) {
		int pos;
		
		pos=busquedaSecuencialDesordenada(a,n,x);
		if(pos>=0) {
			n--;
			a[pos]=a[n];
			a[n]=null;
		}
		
		return n;
	}
}
