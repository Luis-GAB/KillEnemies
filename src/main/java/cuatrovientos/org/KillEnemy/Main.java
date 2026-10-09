package cuatrovientos.org.KillEnemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static Hero jugador = new Hero();
	public static int numRevisados = 0;
    public static ArrayList<Character> listaPersonajes  = new ArrayList<>();
    public static int enemigosLista = 0;
    public static int aliadosLista = 0;
	
    public static void main(String[] args) {
  
    	Scanner readFromConsole = new Scanner(System.in);
    	String accion = "";
    	
    	showCharacters();
        
        for (int i = 0; i < 5; i++) {
        	listaPersonajes.add(new Friend());
        }
        for (int i = 0; i < 5; i++) {
        	listaPersonajes.add(new Enemy());
        }
        
        Collections.shuffle(listaPersonajes);
        
        for (Character personajeRevisar: listaPersonajes) {
        	
        	System.out.println("Aparece el personaje nº" + numRevisados);
        	while (!(accion.equalsIgnoreCase("matar") || accion.equalsIgnoreCase("defender"))) {
            	System.out.print("¿Quieres matarlo o curarlo? (matar/defender): ");
        		accion = readFromConsole.nextLine();
        	}
        	
        	if (accion.equalsIgnoreCase("matar")) {
        		matar(personajeRevisar);
        		listaPersonajes.remove(personajeRevisar);
        	} else if (accion.equalsIgnoreCase("defender")) {
        		defender(personajeRevisar);
        	}
        	
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
        
        readFromConsole.close();
        
    }
    
    public static void showCharacters() {
    	System.out.println("Lista personajes: ");
    	for (Character personajeRevisar: listaPersonajes) {
        	if (personajeRevisar.isEnemy()) {
        		System.out.println("El personaje nº" + numRevisados + " es un enemigo");
        		enemigosLista++;
        	} else {
        		System.out.println("El personaje nº" + numRevisados + " es un aliado");
        		aliadosLista++;
        	}
        }
        System.out.println("Enemigos: " + enemigosLista);
        System.out.println("Aliados: " + aliadosLista);
    }
    
    public static void matar(Character personajeRevisar) {
    	if (personajeRevisar.isEnemy()) {
    		Enemy enemigoAtacar = (Enemy) personajeRevisar;
    		jugador.attack(enemigoAtacar);
    	} else {
    		Friend aliadoAtacar = (Friend) personajeRevisar;
    		jugador.attack(aliadoAtacar);
    	}
    }
    
    public static void defender(Character personajeRevisar) {
    	if (personajeRevisar.isEnemy()) {
    		Enemy enemigoDefender = (Enemy) personajeRevisar;
    		jugador.defend(enemigoDefender);
    		listaPersonajes.add(new Enemy());
    	} else {
    		Friend aliadoDefender = (Friend) personajeRevisar;
    		jugador.defend(aliadoDefender);
    	}
    }
    
}
