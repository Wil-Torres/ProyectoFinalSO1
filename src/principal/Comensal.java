package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Comensal extends Thread {
	
	// declaramos las propiedades de la clase
	private final int numero;
	private final Semaphore[] palilloS; 
	private final List<List<Integer>> palilloComensal; 
	private final String nombre;
	private final int izquierdo;
	private final int derecho;
	
	
	
	public Comensal(int numero, Semaphore[] palilloS, List<List<Integer>> palilloComensal, String nombre) {
		this.numero = numero;
		this.palilloS = palilloS;
		this.palilloComensal = palilloComensal;
		this.nombre = nombre;
		this.izquierdo = palilloComensal.get(numero).get(0);
		this.derecho = palilloComensal.get(numero).get(1);
	}
	
	@Override
	public void run() {
		while (Visualizar.corriendo) {
			try {
				comensalPensando();
				comensalComiendo();
				comensalDurmiendo();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void comensalDurmiendo() {
		try {
			// pensara durante un segundo
			
			Comensal.sleep(Constantes.tiempoDurmiendo);
			System.out.println("Filosofo " + nombre + " Durmiendo");
			// cambiar emoji a durmiendo.
			Visualizar.setEstado(numero, "dormir");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private void comensalComiendo() throws IOException {
		//concedemos permiso para tomar el cubierto
		if(palilloS[izquierdo].tryAcquire()){
			if(palilloS[derecho].tryAcquire()){
				System.out.println("Filosofo " + nombre + " inicia comiendo " + (new Date()));
				enviartexto("Filosofo " + nombre + " inicia comiendo " + (new Date()));
				Visualizar.setEstadoC(numero, "comer");
				Visualizar.setMano(izquierdo, "mano");                         
				Visualizar.setMano(derecho, "mano");
				try {
					sleep(new Random().nextInt(Constantes.tiempoMaximo) +  Constantes.tiempoComiendo);
				} catch (Exception e) {
					// TODO: handle exception
				}
				// soltamos el cubierto para que lo utilice alguien mas
				System.out.println("Filosofo " + nombre + " termina de comer " + (new Date()));
				enviartexto("Filosofo " + nombre + " termina de comer " + (new Date()));
				Visualizar.setEstado(numero, "sin_estado");
				Visualizar.setMano(izquierdo, "vacio");                         
				Visualizar.setMano(derecho, "vacio");
				palilloS[derecho].release();
			}
			// soltamos el cubierto para que lo utilice alguien mas
			palilloS[izquierdo].release();
			
		} else {
			System.out.println("Esperando turno");
			Visualizar.setEstado(numero, "sin_estado");
		}
		
	}

	private void comensalPensando() {
		// TODO Auto-generated method stub
		try {
			// pensara durante un segundo
			Comensal.sleep(Constantes.tiempoPensando);
			System.out.println("Filosofo " + nombre + " pensando");
			// cambiar emoji a pensando.
			Visualizar.setEstado(numero, "pensar");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	private void enviartexto(String texto) throws IOException{
		String ruta = "/Users/wtorres/Desktop/archivo.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.newLine();
            bw.write(texto);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(texto);
        }
        bw.close();
	}

}
