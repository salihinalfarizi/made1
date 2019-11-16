package com.dicoding.firstsubmade;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class DetailFilm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_details);

        ImageView bg_image = findViewById(R.id.bg_image);
        ImageView main_image = findViewById(R.id.main_image);
        ImageButton btnLink = findViewById(R.id.play);
        TextView judulFilm = findViewById(R.id.judul);
        TextView tglRilisFilm = findViewById(R.id.tgl_rilis);
        TextView durasiFilm = findViewById(R.id.durasi);
        TextView genreFilm = findViewById(R.id.genre);
        TextView namaSutradara =findViewById(R.id.sutradara);
        TextView sinopsisFilm = findViewById(R.id.sinopsis_film);
        TextView ratingFilm = findViewById(R.id.rating);

        Film movies = getIntent().getParcelableExtra("movies");

        int gambarFilm = movies.getMainPicture();
        int gambarBackground = movies.getBgPicture();
        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://youtu.be/XY7falovJiI"));
                startActivity(intent);
            }
        });
        String judul = movies.getJudul();
        String tglRilis = movies.getTglRilis();
        String durasi = movies.getDurasi();
        String genre = movies.getGenre();
        String sutradaraFilm = movies.getSutradaraFilm();
        String sinopsis = movies.getSinopsis();
        String rate = movies.getRate();

        main_image.setImageResource(gambarFilm);
        bg_image.setImageResource(gambarBackground);
        judulFilm.setText(judul);
        tglRilisFilm.setText(tglRilis);
        durasiFilm.setText(durasi);
        genreFilm.setText(genre);
        namaSutradara.setText(sutradaraFilm);
        sinopsisFilm.setText(sinopsis);
        ratingFilm.setText(rate);

        Objects.requireNonNull(getSupportActionBar()).setTitle(movies.getJudul());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
