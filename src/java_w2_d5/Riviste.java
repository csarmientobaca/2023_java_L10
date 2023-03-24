package java_w2_d5;


import lombok.*;
import java.time.*;

@Getter
public class Riviste extends Content {
    Periodicita peri;

    public Riviste(String titolo, Year year, int pages, Periodicita pe) {
        super(titolo, year, pages);
        peri = pe;
    }

    @Override
    public String toString() {
//    	"Libro{"+", title=" + titolo +"ISBN_code=" + ISBN_CODE +", release_Y=" + year +
//        ", pageNum=" + pages +", author=" + autore +", genre=" + genero +'}';
        return "Riviste{"+", title=" + titolo +"ISBN_code=" + ISBN_CODE +", release_Y=" + year +
                ", pageNum=" + pages +", periodo="+peri+'}';
    }
}