package org.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.util.HibernateUtil;
import org.movies.Movie;

import java.util.List;

public class MovieDao {

    public void createMovie(Movie movie){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public Movie getMovieById ( long id){
        Transaction transaction = null;
        Movie movie = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            movie = session.get(Movie.class, id);
            System.out.println(movie);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return movie;
    }

    public List<Movie> getAllMovies () {
        Transaction transaction = null;
        List<Movie> movies = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            movies = session.createQuery("from movie").list();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return movies;
    }

    public void updateMovie(Movie movie){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(movie);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public void deleteMovie(long id){
        Transaction transaction = null;
        Movie movie = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            movie = session.get(Movie.class, id);
            session.delete(movie);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
}


