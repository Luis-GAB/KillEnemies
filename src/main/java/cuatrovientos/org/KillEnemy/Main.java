package cuatrovientos.org.KillEnemy;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
    public static void main(String[] args) {
    	
    	Hero jugador = new Hero();
        ArrayList<Character> listaPersonajes  = new ArrayList<>();
        int numRevisados;
        
        for (int i = 0; i < 5; i++) {
        	listaPersonajes.add(new Friend());
        }
        for (int i = 0; i < 5; i++) {
        	listaPersonajes.add(new Enemy());
        }
        
        Collections.shuffle(listaPersonajes);
        
        numRevisados = 0;
        for (Character personajeRevisar: listaPersonajes) {
        	if (personajeRevisar.isEnemy()) {
        		Enemy enemigoAtacar = (Enemy) personajeRevisar;
        		System.out.println("¡El personaje nº" + numRevisados + " es un enemigo! ¡Matalo!");
        		jugador.attack(enemigoAtacar);
        	} else {
        		Friend aliadoDefender = (Friend) personajeRevisar;
        		System.out.println("¡El personaje nº" + numRevisados + " es un aliado!");
        		jugador.defend(aliadoDefender);
        	}
        	numRevisados++;
        }
        
    }
    
}
