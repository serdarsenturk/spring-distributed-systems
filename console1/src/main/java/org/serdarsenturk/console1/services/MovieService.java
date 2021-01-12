package org.serdarsenturk.console1.services;

import org.serdarsenturk.console1.entity.Movie;

public interface MovieService {
    void findAll();
    void create(Movie movie);
    void delete(int id);

    //TODO:Change the parameter movie to which want to change parameters
    void update(Movie movie);
    void find(int id);
}
