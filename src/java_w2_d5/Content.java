package java_w2_d5;
import lombok.*;

import java.util.*;

import java.time.*;


@Getter
public class Content {
    int pages;
    Random artID = new Random();

    String titolo;
    
    long ISBN_CODE;
    
    Year year;

    public Content(String ti, Year yer, int pag) {
    	titolo = ti;        
    	ISBN_CODE = createUnic();
        year = yer;
        pages = pag;
    }


    private long  createUnic() {
        return Math.abs(artID.nextLong());
    }
}