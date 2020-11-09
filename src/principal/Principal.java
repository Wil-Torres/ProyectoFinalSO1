package principal;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

import javax.swing.plaf.multi.MultiTextUI;

public class Principal {
	
	//Establecemos la cantidad de filosofos segun las variable de entorno configurada.
	protected final static int numeroFilosofos = 5; //Integer.parseInt(System.getenv("NO_FILOSOFOS_PROYECTO"));
	
	protected final static List<List<Integer>> palilloFilosofo = asinarPalillos();
	
	// Creamos un arreglo del tamaño de los filosofos.
	protected final static Semaphore[] semaforoPalillo = new Semaphore[numeroFilosofos];
	
	
	// cargamos el archivo con los nombres
	static LeerArchivo doc = new LeerArchivo();
	protected final static String[] archivo = doc.lectura("/Users/wtorres/Desktop/proyecto.txt");
	
	protected static void inicializarHilos(){
		
		for(int i = 0; i < numeroFilosofos; i++){
			// instanciamos los semaforos asignadole 1 permiso a cada palillo
			semaforoPalillo[i] = new Semaphore(1);
		}
		
		for(int i = 0; i < numeroFilosofos; i++){
			new Comensal(i, semaforoPalillo, palilloFilosofo, archivo[i]).start();
			//colocamos la carita del emoji
            Visualizar.setEstado(i, "pensar");                                  // Además les asignamos las imágenes iniciales a las etiquetas de la interfaz.
            Visualizar.setMano(i, "vacio");
		}
		
		
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		// cargarGraficos pantalla = new cargarGraficos();
		Visualizar pantalla = new Visualizar();
		

	}

	private static List<List<Integer>> asinarPalillos() {
		// hacemos dinamico el llenado de los palillos para los filosofos.
		int[][] palillos = new int[numeroFilosofos][numeroFilosofos];
		List<List<Integer>> twoDim = new ArrayList<List<Integer>>();
		try {
			if(numeroFilosofos == 0){
				throw new Exception("error no ha configurado la variable de entorno.");
			}
			for(Integer i = 0; i <= numeroFilosofos;i++){
				if(i == 0){
					twoDim.add(Arrays.asList(i,numeroFilosofos));
				}else if((i !=0) && (i<numeroFilosofos)){
					twoDim.add(Arrays.asList(i,i-1));
				}
			}
			return twoDim;
			
		} catch (Exception e) {
			// TODO: handle exception
			return twoDim;
		}
		
		
		
	}

}
