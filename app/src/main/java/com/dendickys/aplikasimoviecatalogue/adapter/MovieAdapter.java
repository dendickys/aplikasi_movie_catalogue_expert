package com.dendickys.aplikasimoviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dendickys.aplikasimoviecatalogue.R;
import com.dendickys.aplikasimoviecatalogue.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        private TextView tvName, tvYear, tvGenre, tvDescription;
        private ImageView imgPoster;

        ViewHolder(View view) {
            tvName = view.findViewById(R.id.tv_name);
            tvYear = view.findViewById(R.id.tv_year);
            tvGenre = view.findViewById(R.id.tv_genre);
            tvDescription = view.findViewById(R.id.tv_description);
            imgPoster = view.findViewById(R.id.img_poster);
        }

        void bind(Movie movie) {
            tvName.setText(movie.getName());
            tvYear.setText(movie.getYear());
            tvGenre.setText(movie.getGenre());
            tvDescription.setText(movie.getDescription());
            imgPoster.setImageResource(movie.getPoster());
        }
    }
}
