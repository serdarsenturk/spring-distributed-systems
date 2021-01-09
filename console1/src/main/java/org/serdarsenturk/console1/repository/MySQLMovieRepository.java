package org.serdarsenturk.console1.repository;

import org.serdarsenturk.console1.entity.Movie;
import org.serdarsenturk.console1.util.HibernateUtil;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MySQLMovieRepository implements MovieRepository{

    //EntityManager use EntityManagerFactory interface and it's provide connection between Persistence-Unit
    //EntityManager provide CRUD process on persistence.
    EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public List<Movie> findAll(Movie movie) {
        return null;
    }

    @Override
    public Movie create(Movie movie) {
        entityManager.getTransaction().begin();


        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Movie find(int id) {
        return null;
    }

    @Override
    public Movie update(int id) {
        return null;
    }
}
