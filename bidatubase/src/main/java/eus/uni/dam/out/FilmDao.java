package eus.uni.dam.out;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class FilmDao {
	
	@PersistenceContext
    private EntityManager entityManager;

    /**
     * Almacena la ... en la base de datos
     */
    public void create(Film film) {
        entityManager.persist(film);
        return;
    }

    /**
     * Elimina el usuario de la base de datos.
     */
    public void delete(Film film) {
        if (entityManager.contains(film))
            entityManager.remove(film);
        else
            entityManager.remove(entityManager.merge(film));
        return;
    }

    /**
     * Devuelve todos los ... de la base de datos.
     */
    @SuppressWarnings("unchecked")
    public List<Film> getAll() {
    	return entityManager.createQuery("from Film").getResultList();
    }

    /**
     * Devuelve un ... en base a su Id
     */
    public Film getById(long id) {
        return entityManager.find(Film.class, id);
    }

    /**
     * Actualiza el us...uario proporcionado
     */
    public void update(Film film) {
        entityManager.merge(film);
        return;
    }

    
}