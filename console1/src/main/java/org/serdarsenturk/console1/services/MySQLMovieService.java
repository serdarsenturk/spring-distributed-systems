package org.serdarsenturk.console1.services;

import org.serdarsenturk.console1.entity.Movie;
import org.serdarsenturk.console1.repository.MySQLMovieRepository;

public class MySQLMovieService implements MovieService{
    private final MySQLMovieRepository mySQLMovieRepository;

    public MySQLMovieService(MySQLMovieRepository mySQLMovieRepository) {
        this.mySQLMovieRepository = mySQLMovieRepository;
    }

    @Override
    public void findAll() {
        mySQLMovieRepository.findAll();
    }

    @Override
    public void create(Movie movie) {
        mySQLMovieRepository.create(movie);
    }

    @Override
    public void delete(int id) {
        mySQLMovieRepository.delete(id);
    }

    @Override
    public void update(Movie movie) {
        mySQLMovieRepository.update(movie);
    }

    @Override
    public void find(int id) {
        mySQLMovieRepository.find(id);
    }
}
