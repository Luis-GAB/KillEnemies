package cuatrovientos.org.KillEnemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Main {
	
	public static Hero jugador = new Hero();
	public static int numRevisados = 0;
    public static ArrayList<Character> listaPersonajes  = new ArrayList<>();
    public static int enemigosLista = 0;
    public static int aliadosLista = 0;
	
    public static void main(String[] args) {
  
    	Scanner readFromConsole = new Scanner(System.in);
    	File archivo = new File("partida.dat");
    	String accion = "";
    	
    	if (archivo.exists()) {
            // Ya existe una partida: cargarla
            listaPersonajes = cargarPartida();

            if (listaPersonajes == null) {
                crearPersonajes();
            }

        } else {
            // No existe partida: crear los personajes
            crearPersonajes();
        }
        
    	Collections.shuffle(listaPersonajes);
        showCharacters();
        
        numRevisados = 0;
        
        for (int i = 0; i < listaPersonajes.size(); i++) {
        	
        	Character personajeRevisar = listaPersonajes.get(i);
        	
        	System.out.println("Aparece el personaje nº" + numRevisados);
        	while (!(accion.equalsIgnoreCase("matar") || accion.equalsIgnoreCase("defender"))) {
            	System.out.print("¿Quieres matarlo o curarlo? (matar/defender): ");
        		accion = readFromConsole.nextLine();
        	}
        	
        	if (accion.equalsIgnoreCase("matar")) {
        		matar(personajeRevisar);
        		listaPersonajes.remove(personajeRevisar);
        		i--;
        	} else if (accion.equalsIgnoreCase("defender")) {
        		defender(personajeRevisar);
        	}
        	
        	//if (personajeRevisar.isEnemy()) {
        	//Enemy enemigoAtacar = (Enemy) personajeRevisar;
        	//System.out.println("¡El personaje nº" + numRevisados + " es un enemigo! ¡Matalo!");
        	//jugador.attack(enemigoAtacar);
        	//} else {
        	//Friend aliadoDefender = (Friend) personajeRevisar;
        	//System.out.println("¡El personaje nº" + numRevisados + " es un aliado!");
        	//jugador.defend(aliadoDefender);
        	//}
        	numRevisados++;
        	accion = "";
        }
        
        guardarPartida(listaPersonajes);
        readFromConsole.close();
        
    }
    
    public static void crearPersonajes() {
    	for (int i = 0; i < 5; i++) {
        	listaPersonajes.add(new Friend());
        }
        for (int i = 0; i < 5; i++) {
        	listaPersonajes.add(new Enemy());
        }
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
        	numRevisados++;
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
    
    public static void guardarPartida(ArrayList<Character> listaPersonajes) {
        try (ObjectOutputStream salida = new ObjectOutputStream(
                new FileOutputStream("partida.dat"))) {

            salida.writeObject(listaPersonajes);
            System.out.println("Partida guardada correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar la partida.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Character> cargarPartida() {
        try (ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream("partida.dat"))) {

            return (ArrayList<Character>) entrada.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar la partida.");
            e.printStackTrace();
            return null;
        }
    }
    
}
