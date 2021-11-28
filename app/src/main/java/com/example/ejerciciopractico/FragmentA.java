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

public class FragmentA extends Fragment {

    private ArrayList<Word> palablas = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(getContext(), "acabose", Toast.LENGTH_SHORT).show();
            releaseMediaPlayer();
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_actividad, container, false);

        palablas.add(new Word("uno", "one", R.drawable.number_one, R.raw.color_black));
        palablas.add(new Word("dos", "two", R.drawable.number_two, R.raw.color_green));
        palablas.add(new Word("tres", "three", R.drawable.number_three, R.raw.color_black));
        palablas.add(new Word("cuatro", "four", R.drawable.number_four, R.raw.color_green));
        palablas.add(new Word("cinco", "five", R.drawable.number_five, R.raw.color_black));
        palablas.add(new Word("seis", "six", R.drawable.number_six, R.raw.color_black));
        palablas.add(new Word("siete", "seven", R.drawable.number_seven, R.raw.color_green));
        palablas.add(new Word("ocho", "eigth", R.drawable.number_eight, R.raw.color_black));
        palablas.add(new Word("nueve", "nain", R.drawable.number_nine, R.raw.color_green));
        palablas.add(new Word("diez", "ten", R.drawable.number_ten));
        palablas.add(new Word("uno", "one", R.drawable.number_one));
        palablas.add(new Word("dos", "two", R.drawable.number_two));
        palablas.add(new Word("tres", "three", R.drawable.number_three));
        palablas.add(new Word("cuatro", "four", R.drawable.number_four));
        palablas.add(new Word("cinco", "five", R.drawable.number_five));
        palablas.add(new Word("seis", "six", R.drawable.number_six));
        palablas.add(new Word("siete", "seven", R.drawable.number_seven, R.raw.color_green));
        palablas.add(new Word("ocho", "eigth", R.drawable.number_eight, R.raw.color_brown));
        palablas.add(new Word("nueve", "nain", R.drawable.number_nine));
        palablas.add(new Word("diez", "ten", R.drawable.number_ten));
        palablas.add(new Word("uno", "one", R.drawable.number_one));
        palablas.add(new Word("dos", "two", R.drawable.number_two));
        palablas.add(new Word("tres", "three", R.drawable.number_three));
        palablas.add(new Word("cuatro", "four", R.drawable.number_four));
        palablas.add(new Word("cinco", "five", R.drawable.number_five));
        palablas.add(new Word("seis", "six", R.drawable.number_six));
        palablas.add(new Word("siete", "seven", R.drawable.number_seven));
        palablas.add(new Word("ocho", "eigth", R.drawable.number_eight));
        palablas.add(new Word("nueve", "nain", R.drawable.number_nine));
        palablas.add(new Word("diez", "ten", R.drawable.number_ten, R.raw.color_green));

        WordAdapter adapter = new WordAdapter(getActivity(), palablas, getResources().getColor(R.color.naranja));
        ListView listView = (ListView) rootView.findViewById(R.id.listaNumeros);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = palablas.get(position);
                if (word.obtenerIDSonido() != 0) {
                    releaseMediaPlayer();
                    mediaPlayer = MediaPlayer.create(getActivity(), word.obtenerIDSonido());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(onCompletionListener);
                } else {
                    Toast.makeText(getActivity(), "No existe el sonido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;

    }

    @Override
    public void onStop() {
        releaseMediaPlayer();
        super.onStop();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}