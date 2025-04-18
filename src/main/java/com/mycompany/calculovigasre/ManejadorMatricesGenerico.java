package com.mycompany.calculovigasre;

import java.util.ArrayList;

public class ManejadorMatricesGenerico {

	public static <T extends Comparable<T>> int mayR(T[][]a, int numR, int n) {
		return ManejadorArregloGenerico.posMayor(a[numR], n);
	}
	
	public static <T extends Comparable<T>> int mayC(T[][]a, int numC, int m) {
		int res=0;
		
		for(int i=1; i<m; i++) {
			if(a[res][numC].compareTo(a[i][numC])<0) {
				res=i;
			}
		}
		return res;
	}
	
	public static <T extends Comparable<T>> int menR(T[][]a, int numR, int n) {
		return ManejadorArregloGenerico.posMenor(a[numR], n);
	}
	
	public static <T extends Comparable<T>> int menC(T[][]a, int numC, int m) {
		int res=0;
		
		for(int i=1; i<m; i++) {
			if(a[res][numC].compareTo(a[i][numC])>0) {
				res=i;
			}
		}
		return res;
	}
	
	public static <T extends Comparable<T>> int[] posMenor(T[][]a, int m, int n) {
		int[] res= new int[2];
		int ren=0;
		int col=0;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(a[ren][col].compareTo(a[i][j])>0) {
					ren=i;
					col=j;
				}
			}
		}
		res[0]=ren;
		res[1]=col;
		
		return res;
	}
	
	public static <T extends Comparable<T>> int[] posMayor(T[][]a, int m, int n) {
		int[] res= new int[2];
		int ren=0;
		int col=0;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(a[ren][col].compareTo(a[i][j])<0) {
					ren=i;
					col=j;
				}
			}
		}
		res[0]=ren;
		res[1]=col;
		
		return res;
	}
	
	public static  <T extends Comparable<T>> boolean esSimetrica(T[][]a, int m, int n) {
		boolean res=true;
		int i=0;
		int j=0;
		
		if(m==n) {
			while(i<m&&res) {
				j+=1;
				while(j<n&&res) {
					if(!a[i][j].equals(a[j][i])) {
						res=false;
					}
					j++;
				}
				i++;
			}
		}
		else {
			res=false;
		}
		return res;
	}
	
	public static <T> ArrayList<T> escalonada(T[][]a, int m, int n, int posm, int posn){
		ArrayList<T> res= new ArrayList<T>();
		
		
		if(posm<m&&posn<n) {
			while(posm<m&&posn<n) {
				res.add(a[posn][posm]);
				posm++;
				if(posm<m) {
					res.add(a[posn][posm]);
				}
				posn++;
			}
		}
		return res;
		
	}
	
}
