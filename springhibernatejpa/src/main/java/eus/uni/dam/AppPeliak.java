package eus.uni.dam;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AppPeliak {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(DatuBasearenKonfigurazioa.class);

		PeliculaDao peliDao = appContext.getBean(PeliculaDao.class);
		/* edo horrela:
		 * @Autowired
		 * PeliculaDao peliDao;
		 */		
		
		// Pelikulen taula sortu eta erregistro bat txertatu
		Pelicula peli = new Pelicula(1, "El Estornino", "2020", null);
		peliDao.create(peli);
		System.out.println("Create egina: El Estornino. ");

		
		  //Pelikula bati data aldatu peli.setAnyo("2018"); peliDao.update(peli);
		  System.out.println("Update egina: El Estornino-2018. ");
		  
		  //Bigarren Pelikula bat txertatu 
		  peli = new Pelicula(2,"Galipolli","1990",null); 
		  peliDao.create(peli);
		  System.out.println("Txertatua: Galipolli. ");
		  
		  
		  //Pelikulen taulako datuak berreskuratu 
		  List<Pelicula> pelis = peliDao.getAll(); 
		  for (Pelicula p:pelis) { System.out.println(p); }
		  
		  //borrau bat peliDao.delete(peliDao.getById(1));
		  System.out.println("borrau da lehengoa?");
		 

		((AnnotationConfigApplicationContext) appContext).close();

	}

}
