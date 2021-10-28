package eus.uni.dam;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eus.uni.dam.in.Pelicula;
import eus.uni.dam.in.PeliculaDao;
import eus.uni.dam.out.Film;
import eus.uni.dam.out.FilmDao;

@SpringBootApplication
public class AppBatetikBestera {

	public static void main(String[] args) {

		ApplicationContext appContextIn = new AnnotationConfigApplicationContext(DbKonfigIn.class);
		ApplicationContext appContextOut = new AnnotationConfigApplicationContext(DbKonfigOut.class);

		PeliculaDao peliDao = appContextIn.getBean(PeliculaDao.class);
		FilmDao filmDao = appContextOut.getBean(FilmDao.class);

		//DbOut taulako erregistroak ezabatu
		List<Film> filmak = filmDao.getAll();
		System.out.println(filmak.size()+" erregistro ezabatuko dira MariDBtik");
		for ( Film f:filmak) {
			filmDao.delete(f);
		}
		System.out.println("Ezabatuak.");
		
		//DbIneko erregistroak banan banan bestean sortu
		List<Pelicula> peliak = peliDao.getAll();
		for (Pelicula p : peliak) {
			Film f = new Film(p.getId(),p.getTitulo());
			filmDao.create(f);
		}
		System.out.println(peliak.size()+" erregistro esportatu dira.");
		
		
		((AnnotationConfigApplicationContext) appContextIn).close();
		((AnnotationConfigApplicationContext) appContextOut).close();
	}

}
