package java_w2_d5;

import java.time.*;

import lombok.Getter;
import lombok.Setter;


@Getter

public class Libri extends Content{
	  	String autore;
	    String genero;

	    public Libri(String titolo, Year year, int pages, String autor, String gen) {
	        super(titolo, year, pages);
	        autore = autor;
	        genero = gen;
	    }

	    @Override
	    public String toString() {
	        return "\nLibro{"+", title=" + titolo +", ISBN_code=" + ISBN_CODE +", ANNO=" + year +
	                ", pageNum=" + pages +", author=" + autore +", genre=" + genero +'}';
	    }
	

}
