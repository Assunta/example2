package test;

import domain.Cliente;
import domain.Film;
import domain.Noleggio;
import junit.framework.TestCase;

/**
 * Created by Assunta on 18/11/2016.
 */
public class ClienteTest extends TestCase {
    private static final int N_FILM = 10;
    private static final int N_CLIENTI = 4;
    private static final int N_NOLEGGI = 6;
    private Film[] film = new Film[N_FILM];
    private Cliente[] clienti = new Cliente[N_CLIENTI];
    private Noleggio[] noleggi = new Noleggio[N_NOLEGGI];

    public ClienteTest(String nome){
        super(nome);
    }

    public void setUp() {
        //creo qualche film
        for (int i = 0; i < film.length; i++)
            film[i] = new Film("Film" + i, i%3);

        // creo qualche cliente
        for (int i = 0; i < clienti.length; i++){
            clienti[i] = new Cliente("Cliente" + i);
        }
        // creo qualche noleggio
        for (int i = 0; i < noleggi.length; i++)
            noleggi[i] = new Noleggio(film[i],i+1);

        // aggiungo i noleggi ai clienti
        for (int i = 0; i < clienti.length; i++)
            clienti[i].addNoleggio(noleggi[i%N_CLIENTI]);
    }

    public void TearDown(){}
    public void testRendiconto() {
        String res =
                "Rendiconto noleggi per Cliente0\n"+
                        "\tFilm0\t2.0\n"+
                        "L'ammontare dovuto e' 2.0\n"+
                        "Hai guadagnato 1 punti per noleggi frequenti\n"+
                        "Rendiconto noleggi per Cliente1\n"+
                        "\tFilm1\t6.0\n"+
                        "L'ammontare dovuto e' 6.0\n"+
                        "Hai guadagnato 2 punti per noleggi frequenti\n"+
                        "Rendiconto noleggi per Cliente2\n"+
                        "\tFilm2\t1.5\n"+
                        "L'ammontare dovuto e' 1.5\n"+
                        "Hai guadagnato 1 punti per noleggi frequenti\n"+
                        "Rendiconto noleggi per Cliente3\n"+
                        "\tFilm3\t5.0\n"+
                        "L'ammontare dovuto e' 5.0\n"+
                        "Hai guadagnato 1 punti per noleggi frequenti\n";

        String res1 = "***";
        for (int i = 0; i < clienti.length; i++){
            res1 += clienti[i].rendiconto();
        }

        assertEquals(res,res1);
    }

}