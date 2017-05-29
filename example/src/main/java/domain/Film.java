package domain;

/**
 * Created by Assunta on 12/11/2016.
 */
public class Film {
    public static final int BAMBINI = 2;
    public static final int REGOLARE = 0;
    public static final int NOVITA = 1;

    private String _titolo;
    private int _codicePrezzo;

    public Film(String titolo, int codicePrezzo) {
        _titolo = titolo;
        _codicePrezzo = codicePrezzo;
    }

    public int getCodicePrezzo() {
        return _codicePrezzo;
    }

    public void setCodicePrezzo(int arg) {
        _codicePrezzo = arg;
    }

    public String getTitolo() {
        return _titolo;
    }
}
