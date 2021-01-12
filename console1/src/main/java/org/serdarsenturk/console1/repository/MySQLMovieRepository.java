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

            Query query = entityManager.createNativeQuery("select * from Movie", Movie.class); // HQL(Hibernate Query Language)
            List<Movie> resultList = query.getResultList(); // Returns each object in query
            resultList.forEach(movie -> System.out.println(movie)); // Writes all movies in "Movie"table

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

            //Start transaction
            transaction.begin();
            Query query = entityManager.createQuery("delete from Movie where id =:id"); //Delete movie by id
            query.setParameter("id", id); //Set which id will delete from table
            query.executeUpdate(); //Execute query

            transaction.commit(); //Commit to changes

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
            //Start transaction
            transaction.begin();

            Query query = entityManager.createQuery("from Movie where id =: id");
            query.setParameter("id", id); //Set parameter which id will be find
            Movie result = (Movie) query.getSingleResult(); //Cast Movie object will return from db

            //TODO: Write toString method to write this object use this way temporarily
            System.out.println(result.toString());
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
