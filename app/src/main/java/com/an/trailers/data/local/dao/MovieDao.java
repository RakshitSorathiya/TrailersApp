package com.an.trailers.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.an.trailers.data.local.entity.MovieEntity;
import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMovies(List<MovieEntity> movies);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateMovie(MovieEntity movie);

    @Query("SELECT * FROM `MovieEntity` where id = :id")
    Flowable<MovieEntity> getMovieDetailById(Long id);

    @Query("SELECT * FROM `MovieEntity` where categoryType = :type")
    Flowable<List<MovieEntity>> getMoviesByType(String type);
}