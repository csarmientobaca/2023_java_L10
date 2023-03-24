package java_w2_d5;

import java.io.File;
import java.io.IOException;
import java.util.*;

import java.util.ArrayList;
import java.util.List;


public class Cat_Biblo {
	
	private static List<Content> catalogo = new ArrayList<Content>();
	
	public static void main(String[] args) {
	
	
	
	}
	
	
	public void aggiungiContent(Content p) {
		catalogo.add(p);
		
		
	}
	public void aggiungi(Libri l) {
//		arrayLibri.add(l)
		aggiungiContent(l);
	}
	public void aggiungi(Riviste l) {
//		arrayRiviste.add(l)
		aggiungiContent(l);
	}
	
	
	
	public static List<Libri> catalogoLibri(){
		return (List<Libro>) catalogo.stream().filter(e->e instanceof Libro).map(nullx->(Libro))
		
	}
	
	
}
