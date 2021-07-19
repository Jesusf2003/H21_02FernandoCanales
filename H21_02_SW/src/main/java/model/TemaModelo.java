package model;

public class TemaModelo {
    private String bloque;
    private String tema;
    private String ponente;

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPonente() {
        return ponente;
    }

    public void setPonente(String ponente) {
        this.ponente = ponente;
    }

    public TemaModelo() {
    }

    public TemaModelo(String bloque, String tema, String ponente) {
        this.bloque = bloque;
        this.tema = tema;
        this.ponente = ponente;
    }

    @Override
    public String toString() {
        return "TemaModelo{" + "bloque=" + bloque + ", tema=" + tema + ", ponente=" + ponente + '}';
    }
    
}
