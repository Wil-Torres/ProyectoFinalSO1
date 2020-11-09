package principal;

import java.io.BufferedReader;
import java.io.FileReader;

public class LeerArchivo {
	public LeerArchivo() {
		// TODO Auto-generated constructor stub
	}
	
	public String[] lectura(String ruta){
		
		BufferedReader lector;
		String separador = ",";
		String[] resultado = null;
		try {
			lector = new BufferedReader(new FileReader(ruta));
			String lecturaLinea = lector.readLine();
			while (lecturaLinea != null ) {
				resultado = lecturaLinea.split(separador);
				System.out.println(resultado);
				lecturaLinea = lector.readLine();
			}
			lector.close();
			
			return resultado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
