package org.serdarsenturk.console1.repository;

import org.serdarsenturk.console1.entity.Movie;
import org.serdarsenturk.console1.util.HibernateUtil;
import javax.persistence.*;
import java.util.List;

public class MySQLMovieRepository implements MovieRepository{

    //EntityManager use EntityManagerFactory interface and it's provide connection between Persistence-Unit
    //EntityManager provide CRUD process on persistence.
    EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction transaction = null;

    //Find all movie by
    @Override
    public void findAll() {
        try {
            transaction = entityManager.getTransaction(); // Create transaction
            transaction.begin(); // Begin transaction

            Query query = entityManager.createNativeQuery("SELECT s FROM Movie s"); // JPQL(Jakarta Persistence Q Language)
            List<Movie> movies = query.getResultList();
            System.out.println("Movies");
            movies.forEach(System.out::println); // Write all movies with foreach

        }catch (Exception e){
            System.out.println(e);
            transaction.rollback(); // Rollback if it has failed
        }finally {
            entityManager.close(); // When it finished close it.
            HibernateUtil.shutdown();
        }
    }

    //Create Movie by Id
    @Override
    public Movie create(Movie movie) {
        try{
            transaction = entityManager.getTransaction();

            //Start transaction
            transaction.begin();

            entityManager.persist(movie); // Create a persistence for db
            transaction.commit(); // Commit to changes.

        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }finally {
            entityManager.close();
            HibernateUtil.shutdown();
        }
        return movie;
    }

    //Delete movie by id
    @Override
    public void delete(int id) {
        try {
            transaction = entityManager.getTransaction();

            transaction.begin();
            Query query = entityManager.createQuery("DELETE FROM Movie m where m.id = :id");
            query.setParameter("id", id);
            int rowsDeleted = query.executeUpdate();
            System.out.println("Movie deleted :" + rowsDeleted);
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }finally {
            entityManager.close();
        }
    }

    //Find movie by Id
    @Override
    public void find(int id) {
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createQuery("select m FROM Movie m where m.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            System.out.println("Movie : " + query);

        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }finally {
            entityManager.close();
        }
    }

    //Update received movie
    @Override
    public void update(Movie movie) {
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.merge(movie);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }finally {
            entityManager.close();
        }
    }
}