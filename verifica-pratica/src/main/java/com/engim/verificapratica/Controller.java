package com.engim.verificapratica;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class Controller {

    private static Sorteggio sorteggio = new Sorteggio();


    /*
    * ES 1: get ("/add?nome=n&nazione=m") che aggiunge al sorteggio una squadra con nome n e nazione m (utilizzare
    * la classe Sorteggio) - 15 p
    *
    * */
    @GetMapping(value="/add")

    public void aggiungi(@RequestParam(value="nome") String nome,@RequestParam(value="nazione") String nazione){
        sorteggio.aggiungi(nome,nazione);
    }
    /*
    * ES 2: get ("/listaSquadre?nazione=n") che restituisce la lista delle squadre di nazione n - 20 p
    * */
     @GetMapping(value = "/listaSquadra")
    public  List<Squadra> getsquadra(String nazione){

         List<Squadra> l = new ArrayList<>();
         for (int i = 0; i < sorteggio.getSquadre().size(); i++){
         if(sorteggio.getSquadre().get(i).getNazione().equals(nazione)){
             l.add(sorteggio.next());
         }

    }
         return l ;
     }
    /*
    * ES 3: get ("/sorteggia") che restituisce 2 squadre di nazioni diverse (utilizzare la classe Sorteggio, il metodo
    * next. Consiglio: dopo aver sorteggiato la prima, continuare a sorteggiare finché la seconda
    * non è di una nazione diversa) - 20 p
    * */
    public List<Squadra> getSortigia(){
        List<Squadra> nazioniDiversi = new ArrayList<>();
        Squadra s = sorteggio.next();
        nazioniDiversi.add(s);
        while (nazioniDiversi.size()<2) {
            if (!s.getNazione().equals(sorteggio.next().getNazione())) {
                nazioniDiversi.add(sorteggio.next());

            }
        }
            return nazioniDiversi;
    }
    /*
    *
    * ES 4: implementare il sorteggio delle squadre di una fase finale di un torneo a eliminazione diretta.
    * Creare il metodo sorteggiaPartite che:
    * - controlla se il numero di squadre aggiunte è una potenza di 2. Se non lo è lancia una RuntimeException.
    * - Finché ci sono squadre non sorteggiate: sorteggia 2 squadre e le inserisce in un oggetto della classe Partita (da creare)
    * - restituisce la lista di Partite.
    * creare get ("/getPartite") che restituisce la lista appena creata - 30 p
    * */

}
