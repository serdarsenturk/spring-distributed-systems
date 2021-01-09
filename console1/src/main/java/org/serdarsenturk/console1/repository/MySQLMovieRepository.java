package org.serdarsenturk.console1.repository;

import org.serdarsenturk.console1.entity.Movie;
import org.serdarsenturk.console1.util.HibernateUtil;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MySQLMovieRepository implements MovieRepository{

    //EntityManager use EntityManagerFactory interface and it's provide connection between Persistence-Unit
    //EntityManager provide CRUD process on persistence.
    EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction transaction = null;

    @Override
    public List<Movie> findAll(Movie movie) {
        List<Movie> movies = new ArrayList<>();
        try {
            transaction = entityManager.getTransaction();

            transaction.begin();

            Query query = entityManager.createNativeQuery("select s from Movie s");

            movies = query.getResultList();

            movies.forEach(s -> {System.out.println(s);});
            return movies;
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }finally {
            entityManager.close();
            HibernateUtil.shutdown();
        }
        
        return movies;
    }

    @Override
    public Movie create(Movie movie) {
        try{
            transaction = entityManager.getTransaction();

            //Start transaction
            transaction.begin();

            entityManager.persist(movie);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }finally {
            entityManager.close();
            HibernateUtil.shutdown();
        }
        return movie;
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
