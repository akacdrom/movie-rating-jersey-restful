package org.movies;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.hibernate.dao.MovieDao;

import java.util.List;

@Path("movies")
public class MovieResource {

    MovieDao movieDao = new MovieDao();

    public MovieResource() throws Exception {
    }

    @GET
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Movie> getMovies() throws Exception {
        System.out.println("getMovies called...");
        return movieDao.getAllMovies();
    }

    @GET
    @Path("movie/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Movie getMovie(@PathParam("id") long id) throws Exception {
        System.out.println("getMovie called...");
        return movieDao.getMovieById(id);
    }

    @POST
    @Path("movie")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Movie createMovie(Movie movie) throws Exception {
        System.out.println("createMovie called...");
        System.out.println(movie);
        movieDao.createMovie(movie);
        return movie;
    }

    @PUT
    @Path("movie")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Movie updateMovie(Movie movie) throws Exception {
        System.out.println("updateMovie called...");
        System.out.println(movie);
        if (movieDao.getMovieById(movie.getId()) == null){
            System.out.println("Object not found creating new one..");
            movieDao.createMovie(movie);
        }
        else movieDao.updateMovie(movie);
        return movie;
    }

    @DELETE
    @Path("movie/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public String deleteMovie(@PathParam("id") long id) throws Exception {
        System.out.println("deleteMovie called...");
        movieDao.deleteMovie(id);
        return "Movie with specific Id is deleted: "+ id;
    }
}
