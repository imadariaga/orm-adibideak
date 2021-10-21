package eus.uni.dam;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AppBatetikBestera {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(DatuBasearenKonfigurazioa.class);

		PeliculaDao peliDao = appContext.getBean(PeliculaDao.class);
		
		Pelicula peli = new Pelicula(1,"Maixabel","2021",null);
		peliDao.create(peli);
		
	 
		  List<Pelicula> oinetakoPeliak = peliDao.getAll(); 
		  for (Pelicula p:oinetakoPeliak) { 
			  System.out.println(p); }
		 
		
		((AnnotationConfigApplicationContext) appContext).close();

	}

}
