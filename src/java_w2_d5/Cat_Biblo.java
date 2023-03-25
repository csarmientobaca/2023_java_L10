package java_w2_d5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

import java.util.Set;
import java.io.File;

import java.io.IOException;

import java.time.Year;

import java.util.HashSet;
//import org.apache.commons.io.FileUtils;

import java.util.stream.Collectors;



public class Cat_Biblo {
	
	static final Logger log = LoggerFactory.getLogger(Cat_Biblo.class);
    static final Scanner input = new Scanner(System.in);
    static Set<Content> archive = new HashSet<Content>();
    static final String path = "src\\java_w2_d5\\res\\archive.txt";
    static String toWrite = "";
	
//	private static List<Content> catalogo = new ArrayList<Content>();
	
	public static void main(String[] args) throws IOException{
		
		boolean switchOnOff = true;
		
		dummyLibriBiblo();
		
		log.info("cosa vuoi fare in questa biblioteca?");
		
		while (switchOnOff) {
	            log.info("press a number to run the action");

	            
	            log.info("\nfor crea content\n---1---");
	            log.info("\nfor delete with ISBN\n---2---");
	            log.info("\nfor search content\n---3---");
	            log.info("\nExit\n---0---");

	            int actionToPerform = askFor();
	            
	            switch (actionToPerform) {
	                case 0 ->  switchOnOff= false;
	                case 1 ->  aggContent();
//	                case 2 ->  removeArticleFromArchive();
//	                case 3 ->  generalSearch();
	            }
		}
		
		
	
	
	}
	
//	
//	public void aggiungiContent(Content p) {
//		catalogo.add(p);
//		
//		
//	}
//	public void aggiungi(Libri l) {
////		arrayLibri.add(l)
//		aggiungiContent(l);
//	}
//	public void aggiungi(Riviste l) {
////		arrayRiviste.add(l)
//		aggiungiContent(l);
//	}
//	
//	
//	
//	public static List<Libri> catalogoLibri(){
//		return (List<Libro>) catalogo.stream().filter(e->e instanceof Libro).map(nullx->(Libro))
//		
//	}
	public static void dummyLibriBiblo(){
		Libri libro1 =new Libri("harry potter and the philosopher's stone",Year.parse("1997"), 223, "JK ROWLING", "Children-Fantasy");
		Libri libro2 =new Libri("Harry Potter and the Chamber of Secrets",Year.parse("1998"), 251, "JK ROWLING", "Children-Fantasy");

		Libri libro3 =new Libri("harry potter and the prisoner of askaban",Year.parse("1999"), 317, "JK ROWLING", "Adolecent-Fantasy");

		archive.add(libro1);
		archive.add(libro2);
		archive.add(libro3);
		
	}
	
	public static int askFor() {
		int choose = 0;
				
		
		
		boolean switchOnOff = true;
		
		while (switchOnOff){
			
			if(input.hasNextInt()) {
//			CAMBIARE IL IF PER UNA LOGICA RIASUNTA
				choose = input.nextInt();
				if(choose< 0|| choose >3) {
					log.info("no good, change variable");
					input.nextLine();
					continue;
				}				
			}
			else {
				log.warn("no good value");
				input.nextLine();
				continue;
				
			}
			switchOnOff=false;
			
		}
		return choose;
	}
	
	
    public static int askFor(int i) {
        boolean switchOnOff = true;
        int pick = 0;
        while (switchOnOff) {
            if (input.hasNextInt()) {
                pick = input.nextInt();
            } else {
                log.warn("no good insert a int");
                input.nextLine();
                continue;
            }
            switchOnOff = false;
        }
        return pick;
    }
    public static long askFor(String type) {
        boolean switchOnOff = true;
        long pick = 0;
        while (switchOnOff) {
            if (input.hasNextLong()) {
                pick = input.nextLong();
            } else {
                log.warn("nope insert number"+ type);
                input.nextLine();
                continue;
            }
            switchOnOff = false;
        }
        return pick;
    }
    public static void aggContent() {
        log.info("content to add");
        log.info("\n1 Libro");
        log.info("\n2 Rivista");
        log.info("\n0 Exit");

        boolean switchOnOff = true;
        int choose = 4;
        while (switchOnOff) {
            if (input.hasNextInt()) {
                choose = input.nextInt();
                if (choose < 0 || choose > 3) {
                    log.info("nope try again");
                    input.nextLine();
                    continue;
                } else {
                    switch (choose) {
                        case 0 -> log.info("STOP");
                        case 1 -> aggTypeContent(1);
                        case 2 -> aggTypeContent(2);
                    }
                }
            } else {
                log.warn("CHOOSE FROM 1 T 3");
                input.nextLine();
                continue;
            }
            switchOnOff = false;
        }
    }
    
    
    public static void aggTypeContent(int n) {
        if (n == 1) {
            log.info("TITLE HERE_:");
            String title = input.next() + input.nextLine();
            log.info("YEAR HERE_:");
            String year = input.next();
            log.info("NUM OF PAGES HERE_:");
            int pageNum = askFor(0);
            log.info("AUTORE HERE_:");
            String auth = input.next() + input.nextLine();
            log.info("GENERO HERE_:");
            String gen = input.next();
            log.info("ADDING BOOK");
            archive.add(new Libri(title, Year.parse(year), pageNum, auth, gen));
            log.info(archive.toString());
        } else {
            log.info("TITLE HERE_:");
            String title =input.next() + input.nextLine();
            log.info("YEAR HERE_:");
            String year = input.next();
            log.info("NUM OF PAGES HERE_:");
            int pageNum = askFor(0);
            log.info("IS RIVISTE \nSETTIMANLI - 1\nMENSILI - 2\nBI-ANNUALI - 3");
            Periodicita period = typeOfPeriodicita();
            archive.add(new Riviste(title, Year.parse(year), pageNum, period));
            log.info(archive.toString());
        }
    }
    
    public static Periodicita typeOfPeriodicita() {
        boolean isRunning = true;
        Periodicita period = Periodicita.settimanale;
        int pick = 4;
        while (isRunning) {
            if (input.hasNextInt()) {
                pick = input.nextInt();
                if (pick < 0 || pick > 3) {
                    log.info("invalid value, insert again");
                    input.nextLine();
                    continue;
                } else {
                    switch (pick) {
                        case 1 -> period =  Periodicita.settimanale;
                        case 2 -> period = Periodicita.mensile;
                        case 3 -> period = Periodicita.meta_anno;
                    }
                }
            } else {
                log.warn("no good, press a number from 1 to 3");
                input.nextLine();
                continue;
            }
            isRunning = false;
        }
        return period;
    }
}
