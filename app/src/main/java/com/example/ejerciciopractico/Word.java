package com.example.ejerciciopractico;

public class Word {
    private String palabraEnCastellano;
    private String palabraEnIngles;
    private int resourceID = 0;
    private int soundID = 0;

    public Word(String palabraEnCastellano, String palabraEnIngles) {
        this.palabraEnCastellano = palabraEnCastellano;
        this.palabraEnIngles = palabraEnIngles;
    }

    public Word(String palabraEnCastellano, String palabraEnIngles, int resourceID) {
        this.palabraEnCastellano = palabraEnCastellano;
        this.palabraEnIngles = palabraEnIngles;
        this.resourceID = resourceID;
    }

    public Word(String palabraEnCastellano, String palabraEnIngles, int resourceID, int soundID) {
        this.palabraEnCastellano = palabraEnCastellano;
        this.palabraEnIngles = palabraEnIngles;
        this.resourceID = resourceID;
        this.soundID = soundID;
    }

    public String obtenerTraduccionCastellano() {
        return palabraEnCastellano;
    }

    public String obtenerTraduccionIngles() {
        return palabraEnIngles;
    }

    public int obtenerIDImagen() {
        return resourceID;
    }

    public int obtenerIDSonido() {
        return soundID;
    }
}
