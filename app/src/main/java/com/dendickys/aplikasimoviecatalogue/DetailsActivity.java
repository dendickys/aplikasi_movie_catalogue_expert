package com.dendickys.aplikasimoviecatalogue;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dendickys.aplikasimoviecatalogue.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    ImageView imgPoster;
    TextView tvName, tvYear, tvGenre, tvDescription;
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imgPoster = findViewById(R.id.img_poster_detail);
        tvName = findViewById(R.id.tv_name_detail);
        tvYear = findViewById(R.id.tv_year_detail);
        tvGenre = findViewById(R.id.tv_genre_detail);
        tvDescription = findViewById(R.id.tv_description_detail);

        Movie movies = getIntent().getParcelableExtra(EXTRA_MOVIE);
        imgPoster.setImageResource(movies.getPoster());
        tvName.setText(movies.getName());
        tvYear.setText(movies.getYear());
        tvGenre.setText(movies.getGenre());
        tvDescription.setText(movies.getDescription());
    }
}
