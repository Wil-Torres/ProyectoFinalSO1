package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.swing.SwingConstants;

public class Visualizar {

	private JFrame frmWilsonGerardoTorres;
	protected static boolean corriendo = false;  
	private JMenuItem iniciar = new JMenuItem("Iniciar");
	private JMenuItem parar = new JMenuItem("Parar");
	private JMenuItem salir = new JMenuItem("Salir");
	private static int cantidad_personas = 5; //Integer.parseInt(System.getenv("NO_FILOSOFOS_PROYECTO"));
	private static final String ruta = "../recurso/";
	private JLabel estado;
	private static final JLabel[] estados = new JLabel[cantidad_personas];
	private static final JLabel[] comidas = new JLabel[cantidad_personas];
	private static final JLabel[] palillos = new JLabel[cantidad_personas];
	private static final JLabel[] manos = new JLabel[cantidad_personas];
	private static final JLabel[] nombres = new JLabel[cantidad_personas];
	
	
	private static int separacion = 20;
	private static int tamañoIcono = 50;
	private static int pIniX1 = 93;
	private static int pIniY1 = 46;
	private static int pIniX2 = 93;
	private static int pIniY2 = 336;
	private final static List<List<Integer>> coordES = ubicacionEmojis(true);
	private final static List<List<Integer>> coordEI = ubicacionEmojis(false);
	private static int paIniX1 = 90;
	private static int paIniY1 = 127;
	private static int paIniX2 = 146;
	private static int paIniY2 = 261;
	private final static List<List<Integer>> coordPalS = ubicacionPalillo(true);
	private final static List<List<Integer>> coordPalI = ubicacionPalillo(false);
	private static int CIniX1 = 100;
	private static int CIniY1 = 116;
	private static int CIniX2 = 100;
	private static int CIniY2 = 282;
	private final static List<List<Integer>> coordComidaS = ubicacionComida(true);
	private final static List<List<Integer>> coordComidaI = ubicacionComida(false);
	private static int NIniX1 = 89;
	private static int NIniY1 = 21;
	private static int NIniX2 = 89;
	private static int NIniY2 = 397;
	private final static List<List<Integer>> coordNombreS = nombreComensal(true);
	private final static List<List<Integer>> coordNombreI = nombreComensal(false);
	
	private static int MIniX1 = 84;
	private static int MIniY1 = 127;
	private static int MIniX2 = 140;
	private static int MIniY2 = 261;
	private final static List<List<Integer>> coordManoS = manoComensal(true);
	private final static List<List<Integer>> coordmanoI = manoComensal(false);
	
	private final static int coordE[][] = {
	        {93, 46},
	        {163, 46},
	        {233, 46},
	        {303, 46},
	        {373, 46},
	        {443, 46},
	        {513, 46},
	        {583, 46}
	    };
	private final static int coordE2[][] = {
	        {93, 336},
	        {163, 336},
	        {233, 336},
	        {303, 336},
	        {373, 336},
	        {443, 336},
	        {513, 336},
	        {583, 336}
	    };
	
	private final static int coordM[][] = {
	        {230, 215},
	        {170, 400},
	        {325, 515},
	        {475, 400},
	        {415, 215},
	        {615, 260},
	        {645, 230},
	        {685, 290},
	        {715, 300}
	    };

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualizar window = new Visualizar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Visualizar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWilsonGerardoTorres = new JFrame();
		frmWilsonGerardoTorres.setTitle("Wilson Gerardo Torres Castellanos    0910-08-17069");
		frmWilsonGerardoTorres.setBounds(100, 100, 734, 485);
		frmWilsonGerardoTorres.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmWilsonGerardoTorres.setJMenuBar(menuBar);
		
		JMenu mnProyecto = new JMenu("Proyecto");
		menuBar.add(mnProyecto);
		
		JMenuItem mntmIniciar = new JMenuItem("Iniciar");
		mntmIniciar.addActionListener((ActionEvent evt) -> {
			corriendo = true;
			Principal.inicializarHilos();
		});
		mnProyecto.add(mntmIniciar);
		
		JMenuItem mntmParar = new JMenuItem("Parar");
		mntmParar.addActionListener((ActionEvent evt) -> {
			corriendo = false;
			Principal.inicializarHilos();
		});
		mnProyecto.add(mntmParar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener((ActionEvent evt) -> {
			System.exit(0);
		});
		mnProyecto.add(mntmSalir);
		frmWilsonGerardoTorres.getContentPane().setLayout(null);
		
		int conteoSegundoC = 0;
		for (int i = 0; i < Principal.numeroFilosofos; i++) {
			if (i <= (coordComidaS.size()-1)){
				
			manos[i] = new JLabel();
    		manos[i].setIcon(new ImageIcon(Visualizar.class.getResource("/recurso/vacio.png")));
    		manos[i].setBounds(coordManoS.get(i).get(0), coordManoS.get(i).get(1), 44, 40);
    		frmWilsonGerardoTorres.getContentPane().add(manos[i]);
    		
			palillos[i] = new JLabel();
			palillos[i].setIcon(new ImageIcon(Visualizar.class.getResource("/recurso/cuchillo.png")));
			palillos[i].setBounds(coordPalS.get(i).get(0), coordPalS.get(i).get(1), 8, 39);
    		frmWilsonGerardoTorres.getContentPane().add(palillos[i]);
				
            comidas[i] = new JLabel();
            comidas[i].setIcon(new ImageIcon(Visualizar.class.getResource("/recurso/comida.jpg")));
            comidas[i].setBounds(coordComidaS.get(i).get(0), coordComidaS.get(i).get(1), 46, 39);
            frmWilsonGerardoTorres.getContentPane().add(comidas[i]);
            
                        
			} else {
			conteoSegundoC = coordComidaI.size() - (Principal.numeroFilosofos - i);
			
			manos[i] = new JLabel();
    		manos[i].setIcon(new ImageIcon(Visualizar.class.getResource("/recurso/vacio.png")));
    		manos[i].setBounds(coordmanoI.get(conteoSegundoC).get(0), coordmanoI.get(conteoSegundoC).get(1), 44, 40);
    		frmWilsonGerardoTorres.getContentPane().add(manos[i]);
			
			palillos[i] = new JLabel();
			palillos[i].setIcon(new ImageIcon(Visualizar.class.getResource("/recurso/cuchillo.png")));
			palillos[i].setBounds(coordPalI.get(conteoSegundoC).get(0), coordPalI.get(conteoSegundoC).get(1), 8, 39);
    		frmWilsonGerardoTorres.getContentPane().add(palillos[i]);
				
			
            comidas[i] = new JLabel();
            comidas[i].setIcon(new ImageIcon(Visualizar.class.getResource("/recurso/comida.jpg")));
            comidas[i].setBounds(coordComidaI.get(conteoSegundoC).get(0), coordComidaI.get(conteoSegundoC).get(1), 46, 39);
    		frmWilsonGerardoTorres.getContentPane().add(comidas[i]);
    		
    		}
        }
		
		
		
		JLabel lblMesa = new JLabel("mesa");
		lblMesa.setIcon(new ImageIcon(Visualizar.class.getResource("/recurso/mesa.jpg")));
		lblMesa.setBounds(58, 107, 587, 224);
		frmWilsonGerardoTorres.getContentPane().add(lblMesa);
		
		int conteoSegundo = 0;
		for (int i = 0; i < Principal.numeroFilosofos; i++) {
			if (i <= (coordES.size()-1)){
            estados[i] = new JLabel();
            estados[i].setIcon(new ImageIcon(Visualizar.class.getResource("/recurso/pensar.png")));
            estados[i].setBounds(coordES.get(i).get(0), coordES.get(i).get(1), 53, 50);
            frmWilsonGerardoTorres.getContentPane().add(estados[i]);
            manos[i] = new JLabel();                                            
            frmWilsonGerardoTorres.getContentPane().add(manos[i]).setBounds(coordManoS.get(i).get(0), coordManoS.get(i).get(1), 50, 50);
            
            nombres[i] = new JLabel(Principal.archivo[i]);
            nombres[i].setBounds(coordNombreS.get(i).get(0), coordNombreS.get(i).get(1), 46, 14);
    		frmWilsonGerardoTorres.getContentPane().add(nombres[i]);
            
			} else {
				
			conteoSegundo = coordEI.size() - (Principal.numeroFilosofos - i);
			estados[i] = new JLabel();
            estados[i].setIcon(new ImageIcon(Visualizar.class.getResource("/recurso/dormir.png")));
            estados[i].setBounds(coordEI.get(conteoSegundo).get(0), coordEI.get(conteoSegundo).get(1), 53, 50);
            frmWilsonGerardoTorres.getContentPane().add(estados[i]);
            manos[i] = new JLabel();                                            
            frmWilsonGerardoTorres.getContentPane().add(manos[i]).setBounds(coordmanoI.get(conteoSegundoC).get(0), coordmanoI.get(conteoSegundoC).get(1), 50, 50);
            
            nombres[i] = new JLabel(Principal.archivo[i]);
            nombres[i].setBounds(coordNombreI.get(conteoSegundo).get(0), coordNombreI.get(conteoSegundo).get(1), 46, 14);
    		frmWilsonGerardoTorres.getContentPane().add(nombres[i]);
				
			}
        }
		
		frmWilsonGerardoTorres.setVisible(true);
	}
	
	
	private static List<List<Integer>> ubicacionEmojis(boolean lado) {
		Integer numeroReal = (int) ((cantidad_personas%2==0) ? Math.ceil((cantidad_personas / 2)) : Math.ceil(((cantidad_personas + 1) / 2)));
        List<List<Integer>> superior = new ArrayList<List<Integer>>();
        List<List<Integer>> inferior = new ArrayList<List<Integer>>();
        int valAnteriorX = 0;
        Integer control = 1;
        for(int i = 0; i <= (cantidad_personas - 1); i++){
        	if (i <= (numeroReal * 1)){
        		if (control == 1){
                	valAnteriorX = 0;
        			superior.add(Arrays.asList(pIniX1,pIniY1));
        			valAnteriorX = pIniX1;
        			System.out.println(superior.get((i)).get(i));
        			
        			
        		}else{
        			int nuevoValor = (valAnteriorX + separacion + tamañoIcono);
        			superior.add(Arrays.asList(nuevoValor,pIniY1));
        			valAnteriorX = nuevoValor;

        		}
        		control++;
        	} else if ((i > (numeroReal * 1)) && (i <= (numeroReal * 2))){
        		if (control > numeroReal)
        			control = 1;
        		if (control == 1){
            		valAnteriorX = 0;
        			inferior.add(Arrays.asList(pIniX2,pIniY2));
        			valAnteriorX = pIniX2;
        		}else{
        			int nuevoValor = (valAnteriorX + separacion + tamañoIcono);
        			inferior.add(Arrays.asList(nuevoValor + separacion + tamañoIcono,pIniY2));
        			valAnteriorX = nuevoValor;
        		}
        		control++;
        	}
        }
        
        if (lado){
        	return superior;        	
        }else{
        	return inferior;        	
        }
	}
	
	private static List<List<Integer>> ubicacionPalillo(boolean lado) {
		Integer numeroReal = (int) ((cantidad_personas%2==0) ? Math.ceil((cantidad_personas / 2)) : Math.ceil(((cantidad_personas + 1) / 2)));
        List<List<Integer>> superior = new ArrayList<List<Integer>>();
        List<List<Integer>> inferior = new ArrayList<List<Integer>>();
        int valAnteriorX = 0;
        Integer control = 1;
        for(int i = 0; i <= (cantidad_personas - 1); i++){
        	if (i <= (numeroReal * 1)){
        		if (control == 1){
                	valAnteriorX = 0;
        			superior.add(Arrays.asList(paIniX1,paIniY1));
        			valAnteriorX = paIniX1;
        			System.out.println(superior.get((i)).get(i));
        			
        			
        		}else{
        			int nuevoValor = (valAnteriorX + separacion + tamañoIcono);
        			superior.add(Arrays.asList(nuevoValor,paIniY1));
        			valAnteriorX = nuevoValor;

        		}
        		control++;
        	} else if ((i > (numeroReal * 1)) && (i <= (numeroReal * 2))){
        		if (control > numeroReal)
        			control = 1;
        		if (control == 1){
            		valAnteriorX = 0;
        			inferior.add(Arrays.asList(paIniX2,paIniY2));
        			valAnteriorX = paIniX2;
        		}else{
        			int nuevoValor = (valAnteriorX + separacion + tamañoIcono);
        			inferior.add(Arrays.asList(nuevoValor + separacion + tamañoIcono,paIniY2));
        			valAnteriorX = nuevoValor;
        		}
        		control++;
        	}
        }
        
        if (lado){
        	return superior;        	
        }else{
        	return inferior;        	
        }
	}
	
	private static List<List<Integer>> ubicacionComida(boolean lado) {
		Integer numeroReal = (int) ((cantidad_personas%2==0) ? Math.ceil((cantidad_personas / 2)) : Math.ceil(((cantidad_personas + 1) / 2)));
        List<List<Integer>> superior = new ArrayList<List<Integer>>();
        List<List<Integer>> inferior = new ArrayList<List<Integer>>();
        int valAnteriorX = 0;
        Integer control = 1;
        for(int i = 0; i <= (cantidad_personas - 1); i++){
        	if (i <= (numeroReal * 1)){
        		if (control == 1){
                	valAnteriorX = 0;
        			superior.add(Arrays.asList(CIniX1,CIniY1));
        			valAnteriorX = CIniX1;
        			System.out.println(superior.get((i)).get(i));
        			
        			
        		}else{
        			int nuevoValor = (valAnteriorX + separacion + tamañoIcono);
        			superior.add(Arrays.asList(nuevoValor,CIniY1));
        			valAnteriorX = nuevoValor;

        		}
        		control++;
        	} else if ((i > (numeroReal * 1)) && (i <= (numeroReal * 2))){
        		if (control > numeroReal)
        			control = 1;
        		if (control == 1){
            		valAnteriorX = 0;
        			inferior.add(Arrays.asList(CIniX2,CIniY2));
        			valAnteriorX = CIniX2;
        		}else{
        			int nuevoValor = (valAnteriorX + separacion + tamañoIcono);
        			inferior.add(Arrays.asList(nuevoValor + separacion + tamañoIcono,CIniY2));
        			valAnteriorX = nuevoValor;
        		}
        		control++;
        	}
        }
        
        if (lado){
        	return superior;        	
        }else{
        	return inferior;        	
        }
	}
	
	private static List<List<Integer>> nombreComensal(boolean lado) {
		Integer numeroReal = (int) ((cantidad_personas%2==0) ? Math.ceil((cantidad_personas / 2)) : Math.ceil(((cantidad_personas + 1) / 2)));
        List<List<Integer>> superior = new ArrayList<List<Integer>>();
        List<List<Integer>> inferior = new ArrayList<List<Integer>>();
        int valAnteriorX = 0;
        Integer control = 1;
        for(int i = 0; i <= (cantidad_personas - 1); i++){
        	if (i <= (numeroReal * 1)){
        		if (control == 1){
                	valAnteriorX = 0;
        			superior.add(Arrays.asList(NIniX1,NIniY1));
        			valAnteriorX = NIniX1;
        			System.out.println(superior.get((i)).get(i));
        			
        			
        		}else{
        			int nuevoValor = (valAnteriorX + separacion + tamañoIcono);
        			superior.add(Arrays.asList(nuevoValor,NIniY1));
        			valAnteriorX = nuevoValor;

        		}
        		control++;
        	} else if ((i > (numeroReal * 1)) && (i <= (numeroReal * 2))){
        		if (control > numeroReal)
        			control = 1;
        		if (control == 1){
            		valAnteriorX = 0;
        			inferior.add(Arrays.asList(NIniX2,NIniY2));
        			valAnteriorX = NIniX2;
        		}else{
        			int nuevoValor = (valAnteriorX + separacion + tamañoIcono);
        			inferior.add(Arrays.asList(nuevoValor + separacion + tamañoIcono,NIniY2));
        			valAnteriorX = nuevoValor;
        		}
        		control++;
        	}
        }
        
        if (lado){
        	return superior;        	
        }else{
        	return inferior;        	
        }
	}
	
	private static List<List<Integer>> manoComensal(boolean lado) {
		Integer numeroReal = (int) ((cantidad_personas%2==0) ? Math.ceil((cantidad_personas / 2)) : Math.ceil(((cantidad_personas + 1) / 2)));
        List<List<Integer>> superior = new ArrayList<List<Integer>>();
        List<List<Integer>> inferior = new ArrayList<List<Integer>>();
        int valAnteriorX = 0;
        Integer control = 1;
        for(int i = 0; i <= (cantidad_personas - 1); i++){
        	if (i <= (numeroReal * 1)){
        		if (control == 1){
                	valAnteriorX = 0;
        			superior.add(Arrays.asList(MIniX1,MIniY1));
        			valAnteriorX = MIniX1;
        			System.out.println(superior.get((i)).get(i));
        			
        			
        		}else{
        			int nuevoValor = (valAnteriorX + separacion + tamañoIcono);
        			superior.add(Arrays.asList(nuevoValor,MIniY1));
        			valAnteriorX = nuevoValor;

        		}
        		control++;
        	} else if ((i > (numeroReal * 1)) && (i <= (numeroReal * 2))){
        		if (control > numeroReal)
        			control = 1;
        		if (control == 1){
            		valAnteriorX = 0;
        			inferior.add(Arrays.asList(MIniX2,MIniY2));
        			valAnteriorX = MIniX2;
        		}else{
        			int nuevoValor = (valAnteriorX + separacion + tamañoIcono);
        			inferior.add(Arrays.asList(nuevoValor + separacion + tamañoIcono,MIniY2));
        			valAnteriorX = nuevoValor;
        		}
        		control++;
        	}
        }
        
        if (lado){
        	return superior;        	
        }else{
        	return inferior;        	
        }
	}
	
	protected static void setEstado(int n, String nombre) {
        estados[n].setIcon(new ImageIcon(
                Visualizar.class.getResource(ruta + nombre + ".png")));
    }
	protected static void setEstadoC(int n, String nombre) {
        estados[n].setIcon(new ImageIcon(
                Visualizar.class.getResource(ruta + nombre + ".jpg")));
    }
	
	protected static void setMano(int n, String nombre) {
        manos[n].setIcon(new ImageIcon(
        		Visualizar.class.getResource(ruta + nombre + ".png")));
    }
	
	
}
