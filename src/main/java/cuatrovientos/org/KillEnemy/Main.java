package cuatrovientos.org.KillEnemy;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
    public static void main(String[] args) {
    	
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
        		System.out.println("¡El personaje nº" + numRevisados + " es un enemigo! ¡Matalo!");
        		personajeRevisar.kill();
        	} else {
        		System.out.println("¡El personaje nº" + numRevisados + " es un aliado!");
        	}
        	numRevisados++;
        }
        
    }
    
}
