package com.dicoding.firstsubmade;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Film> listFilm;

    FilmAdapter(Context context) {
        this.context = context;
        listFilm = new ArrayList<>();
    }

    void setMovies(ArrayList<Film> listMovies) {
        this.listFilm = listMovies;
    }

    @Override
    public int getCount() {
        return listFilm.size();
    }

    @Override
    public Object getItem(int position) {
        return listFilm.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(context).inflate(R.layout.list_item_movies, parent, false);

        ImageView img_film = view.findViewById(R.id.main_picture);
        TextView film_judul = view.findViewById(R.id.judul_film);
        TextView film_rilis = view.findViewById(R.id.tanggal_rilis);
        TextView film_genre = view.findViewById(R.id.genre_film);
        TextView film_rate = view.findViewById(R.id.rate);

        Film movies = (Film) getItem(position);
        img_film.setImageResource(movies.getMainPicture());
        film_judul.setText(movies.getJudul());
        film_rilis.setText(movies.getTglRilis());
        film_genre.setText(movies.getGenre());
        film_rate.setText(movies.getRate());

        return view;
    }
}
