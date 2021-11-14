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

		Pelicula peli2 = appContext.getBean(Pelicula.class);
		peli2.setId(4);
		peli2.setTitulo("AupaEtxebeste");
		try {
			peliDao.create(peli2);
		} catch (org.springframework.dao.DataIntegrityViolationException ex) {//pakete honetan beste hainbat salbuespen interesgarri daude definituta
			System.out.println("Ezin izan da erregistroa txertatu. id hori hartuta dago.");
		}
		List<Pelicula> pelis = peliDao.getAll();
		for (Pelicula p : pelis) {
			System.out.println(p);
		}

		((AnnotationConfigApplicationContext) appContext).close();

	}

}
