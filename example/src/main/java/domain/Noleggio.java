package domain;

/**
 * Created by Assunta on 12/11/2016.
 */
public class Noleggio {
    private Film _film;
    private int _giorniNoleggio;

    public Noleggio(Film film, int giorniNoleggio) {
        _film = film;
        _giorniNoleggio = giorniNoleggio;
    }

    public int getGiorniNoleggio() {
        return _giorniNoleggio;
    }

    public Film getFilm() {
        return _film;
    }

    public double getAmmontare() {
        double questoAmmontare = 0;
        // ammontare per ogni noleggio
        switch (getFilm().getCodicePrezzo()) {
            case Film.REGOLARE:
                questoAmmontare += 2;
                if (getGiorniNoleggio() > 2)
                    questoAmmontare += (getGiorniNoleggio() - 2) * 1.5;
                break;
            case Film.NOVITA:
                questoAmmontare += getGiorniNoleggio() * 3;
                break;
            case Film.BAMBINI:
                questoAmmontare += 1.5;
                if (getGiorniNoleggio() > 3)
                    questoAmmontare += (getGiorniNoleggio() - 3) * 1.5;
                break;
        }
        return questoAmmontare;
    }
}
