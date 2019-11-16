package com.dicoding.firstsubmade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listFilm;
    FilmAdapter filmAdapter;
    String[] judulFilm, tglRilis, durasiFilm, genreFilm, sutradaraFilm, sinopsis, rating;
    TypedArray gambarUtama, gambarBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmAdapter = new FilmAdapter(this);

        listFilm = findViewById(R.id.listView_film);
        listFilm.setAdapter(filmAdapter);

        gambarUtama = getResources().obtainTypedArray(R.array.main_picture);
        gambarBackground = getResources().obtainTypedArray(R.array.background_picture);
        genreFilm = getResources().getStringArray(R.array.genre);
        rating = getResources().getStringArray(R.array.rating);
        sutradaraFilm = getResources().getStringArray(R.array.director_name);
        judulFilm = getResources().getStringArray(R.array.film_name);
        tglRilis = getResources().getStringArray(R.array.tgl_release);
        durasiFilm = getResources().getStringArray(R.array.duration);
        sinopsis = getResources().getStringArray(R.array.description);

        final ArrayList<Film> movieList = new ArrayList<>();

        for (int x = 0; x < judulFilm.length; x++) {
            Film movies = new Film();
            movies.setMainPicture(gambarUtama.getResourceId(x, -1));
            movies.setBgPicture(gambarBackground.getResourceId(x, -1));
            movies.setGenre(genreFilm[x]);
            movies.setRate(rating[x]);
            movies.setSutradaraFilm(sutradaraFilm[x]);
            movies.setJudul(judulFilm[x]);
            movies.setTglRilis(tglRilis[x]);
            movies.setDurasi(durasiFilm[x]);
            movies.setSinopsis(sinopsis[x]);
            movieList.add(movies);
        }
        filmAdapter.setMovies(movieList);

        listFilm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailFilm.class);
                intent.putExtra("movies", movieList.get(i));
                startActivity(intent);
            }
        });
    }
}
