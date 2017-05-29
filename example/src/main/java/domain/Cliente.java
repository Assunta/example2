package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Assunta on 12/11/2016.
 */
public class Cliente  {
    private String _nome;
    private List<Noleggio> _noleggi = new ArrayList<Noleggio>();

    public Cliente (String nome) {
        _nome = nome;
    }

    public void addNoleggio(Noleggio arg) {
        _noleggi.add(arg);
    }

    public String getNome(){
        return _nome;
    }

    public String rendiconto() {
        String r = "Rendiconto noleggi per " + getNome() + "\n";
        for(Noleggio noleggio: _noleggi) {
            r += "\t" + noleggio.getFilm().getTitolo() + "\t" +
                    String.valueOf(noleggio.getAmmontare()) + "\n";
        }
        // aggiungi pie' di pagina
        r += "L'ammontare dovuto e' " + String.valueOf(getAmmontare()) + "\n";
        r += "Hai guadagnato " + String.valueOf(getTotalePunti()) + " punti per noleggi frequenti\n";
        //System.out.println(r);
        return r;
    }

    private double getAmmontare(){
        double ammontareTotale = 0;
       for(Noleggio noleggio: _noleggi) {
            double questoAmmontare = 0;
            questoAmmontare = noleggio.getAmmontare();
            ammontareTotale += questoAmmontare;
        }
        return ammontareTotale;
    }

    private int getTotalePunti(){
        int puntiNoleggiFrequenti = 0;
        for(Noleggio noleggio: this._noleggi)
            puntiNoleggiFrequenti += getPuntiNoleggiFrequenti(noleggio);
        return puntiNoleggiFrequenti;
    }

    private int getPuntiNoleggiFrequenti(Noleggio noleggio) {
        int puntiNoleggiFrequenti = 0;
        // punti per noleggi frequenti
        puntiNoleggiFrequenti++;

        // bonus per noleggi novita' di 2 giorni
        if ((noleggio.getFilm().getCodicePrezzo() == Film.NOVITA) &&
                noleggio.getGiorniNoleggio() > 1)
            puntiNoleggiFrequenti++;
        return puntiNoleggiFrequenti;
    }

}
