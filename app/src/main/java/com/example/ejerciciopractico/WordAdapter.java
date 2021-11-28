package com.example.ejerciciopractico;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    int color = 0;

    public WordAdapter(Activity context, ArrayList<Word> palabras, int color) {
        super(context, 0, palabras);
        this.color = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView palablaEnCastellano = (TextView) listItemView.findViewById(R.id.palabraCastellana);
        palablaEnCastellano.setText(currentWord.obtenerTraduccionCastellano());

        TextView palabraEnIngles = (TextView) listItemView.findViewById(R.id.palabraInglesa);
        palabraEnIngles.setText(currentWord.obtenerTraduccionIngles());

        ImageView imagen = (ImageView) listItemView.findViewById(R.id.imagenVista);
        if (currentWord.obtenerIDImagen() != 0) {
            imagen.setImageResource(currentWord.obtenerIDImagen());
            imagen.setVisibility(View.VISIBLE);
        } else {
            imagen.setVisibility(View.GONE);
        }

        LinearLayout linearLayout = listItemView.findViewById(R.id.vistasDeLaActividad);
        linearLayout.setBackgroundColor(color);

        return listItemView;
    }
}
