package com.example.ejerciciopractico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentC extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_actividad_c, container, false);
        ArrayList<Word> numeros = new ArrayList<>();

        numeros.add(new Word("uno","one"));
        numeros.add(new Word("dos","two"));
        numeros.add(new Word("tres","three"));
        numeros.add(new Word("cuatro","four"));
        numeros.add(new Word("cinco","five"));
        numeros.add(new Word("seis","six"));
        numeros.add(new Word("siete","seven"));
        numeros.add(new Word("ocho","eigth"));
        numeros.add(new Word("nueve","nain"));
        numeros.add(new Word("diez","ten"));
        numeros.add(new Word("uno","one"));
        numeros.add(new Word("dos","two"));
        numeros.add(new Word("tres","three"));
        numeros.add(new Word("cuatro","four"));
        numeros.add(new Word("cinco","five"));
        numeros.add(new Word("seis","six"));
        numeros.add(new Word("siete","seven"));
        numeros.add(new Word("ocho","eigth"));
        numeros.add(new Word("nueve","nain"));
        numeros.add(new Word("diez","ten"));
        numeros.add(new Word("uno","one"));
        numeros.add(new Word("dos","two"));
        numeros.add(new Word("tres","three"));
        numeros.add(new Word("cuatro","four"));
        numeros.add(new Word("cinco","five"));
        numeros.add(new Word("seis","six"));
        numeros.add(new Word("siete","seven"));
        numeros.add(new Word("ocho","eigth"));
        numeros.add(new Word("nueve","nain"));
        numeros.add(new Word("diez","ten"));

        WordAdapter adapter= new WordAdapter(getActivity(),numeros, getResources().getColor(R.color.morado));
        ListView actividadC = rootview.findViewById(R.id.viewActividadC);
        actividadC.setAdapter(adapter);

        return rootview;
    }
}