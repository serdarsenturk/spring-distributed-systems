package org.serdarsenturk.console1.repository;

import org.serdarsenturk.console1.entity.Movie;
import org.springframework.data.domain.Pageable;

import java.util.List;

// This interface provide to use different services on it.
public interface MovieRepository{
    List<Movie> findAll(Movie movie);
    Movie create(Movie movie);
    void delete(int id);
    Movie find(int id);
    Movie update(int id);
}
