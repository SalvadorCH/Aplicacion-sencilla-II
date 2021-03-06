package com.example.ejerciciopractico;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentB extends Fragment {

    private ArrayList<Word> numeros = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.activity_actividad_b, container, false);

        numeros.add(new Word("uno", "one", R.drawable.family_younger_sister, R.raw.phrase_yes_im_coming));
        numeros.add(new Word("dos", "two", R.drawable.family_younger_sister, R.raw.phrase_yes_im_coming));
        numeros.add(new Word("tres", "three", R.drawable.family_younger_sister, R.raw.phrase_yes_im_coming));
        numeros.add(new Word("cuatro", "four", R.drawable.family_younger_sister, R.raw.phrase_yes_im_coming));
        numeros.add(new Word("cinco", "five", R.drawable.family_younger_sister, R.raw.phrase_yes_im_coming));
        numeros.add(new Word("seis", "six", R.drawable.family_younger_sister, R.raw.phrase_yes_im_coming));
        numeros.add(new Word("siete", "seven", R.drawable.family_younger_sister, R.raw.phrase_yes_im_coming));
        numeros.add(new Word("ocho", "eigth", R.drawable.family_younger_sister));
        numeros.add(new Word("nueve", "nain", R.drawable.family_younger_sister));
        numeros.add(new Word("diez", "ten", R.drawable.family_younger_sister));
        numeros.add(new Word("uno", "one", R.drawable.family_younger_sister));
        numeros.add(new Word("dos", "two", R.drawable.family_younger_sister));
        numeros.add(new Word("tres", "three", R.drawable.family_younger_sister));
        numeros.add(new Word("cuatro", "four", R.drawable.family_younger_sister));
        numeros.add(new Word("cinco", "five", R.drawable.family_younger_sister));
        numeros.add(new Word("seis", "six", R.drawable.family_younger_sister));
        numeros.add(new Word("siete", "seven", R.drawable.family_younger_sister));
        numeros.add(new Word("ocho", "eigth", R.drawable.family_younger_sister));
        numeros.add(new Word("nueve", "nain", R.drawable.family_younger_sister));
        numeros.add(new Word("diez", "ten"));
        numeros.add(new Word("uno", "one", R.drawable.family_younger_sister));
        numeros.add(new Word("dos", "two", R.drawable.family_younger_sister));
        numeros.add(new Word("tres", "three", R.drawable.family_younger_sister));
        numeros.add(new Word("cuatro", "four", R.drawable.family_younger_sister));
        numeros.add(new Word("cinco", "five", R.drawable.family_younger_sister));
        numeros.add(new Word("seis", "six", R.drawable.family_younger_sister));
        numeros.add(new Word("siete", "seven", R.drawable.family_younger_sister));
        numeros.add(new Word("ocho", "eigth", R.drawable.family_younger_sister));
        numeros.add(new Word("nueve", "nain", R.drawable.family_younger_sister));
        numeros.add(new Word("diez", "ten", R.drawable.family_younger_sister));

        WordAdapter adapter = new WordAdapter(getActivity(), numeros, getResources().getColor(R.color.verde));
        ListView vistaNumeros = (ListView) rootview.findViewById(R.id.vistaActividadB);
        vistaNumeros.setAdapter(adapter);

        vistaNumeros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = numeros.get(position);
                if (word.obtenerIDSonido() != 0) {
                    releaseMediaPlayer();
                    mediaPlayer = MediaPlayer.create(getActivity(), word.obtenerIDSonido());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                } else {
                    Toast.makeText(getActivity(), "No existe sonido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootview;

    }

    @Override
    public void onStop() {
        releaseMediaPlayer();
        super.onStop();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}