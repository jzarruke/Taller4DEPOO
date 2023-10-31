package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import javax.swing.JFrame;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class Interfaz extends JFrame {
    private PanelOpcionesJuego panelNorte;
	private PanelDatos panelSur;
	private PanelTablero panelCentro;
    private PanelOpcionesGenerales panelEste;
    private PanelOpcionesGeneralesBtns panelEsteBtns;
    private int tamanoTablero = 5;
    private int pastTamano;
    private Tablero tablero;
    private Font arcdFontI = CustomFont("data/ARCADE_I.TTF", 0, 15);
    private Font arcdFontN = CustomFont("data/ARCADE_N.TTF", 0, 10);
    private VentanaCambiarJugador ventanaJugador;
    private String jugador = "";
    private Top10Ventana ventanaT10;
    private Top10 top10 = new Top10();
    Collection<RegistroTop10> registros;
    
    public Interfaz() {
    	int tamX = 665;
    	int tamY = 585;
    	
    	ventanaJugador = new VentanaCambiarJugador(this, arcdFontN);
    	ventanaJugador.setLocationRelativeTo(null);
    	
    	top10.cargarRecords(new File("data/top10.csv"));
    	registros = top10.darRegistros();
    	
    	ventanaT10 = new Top10Ventana(registros, arcdFontI);
    	ventanaT10.setLocationRelativeTo(null);
    	
    	setSize(tamX, tamY);
    	setResizable(false);
        setTitle("LightsOut");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        panelNorte = new PanelOpcionesJuego(this);
        add(panelNorte, BorderLayout.NORTH);
        
        tablero = new Tablero(tamanoTablero);
        tablero.desordenar(panelNorte.getDificultad());
        panelCentro = new PanelTablero(tablero.darTablero(), this);
        add(panelCentro, BorderLayout.CENTER);
        
        panelEste = new PanelOpcionesGenerales(tamY/2, this, ventanaJugador);
        add(panelEste, BorderLayout.EAST);
        
//        panelEsteBtns = new PanelOpcionesGeneralesBtns(this, ventanaT10);
//        add(panelEsteBtns, BorderLayout.EAST);
        
        panelSur = new PanelDatos(jugador);
        add(panelSur, BorderLayout.SOUTH);
        
        addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent e){
        		GuardarTop10();
        	}
        });
    }
	
	public void CambiarJugador(String nombre) {
		jugador = nombre;
		panelSur.CambioJugador(jugador);
	}
	
	public void CambiarTamano(int pTamanoTablero) {
		pastTamano = tamanoTablero;
		tamanoTablero = pTamanoTablero + 5;
	}
	
	public void NuevoJuego() {
		tablero = new Tablero(tamanoTablero);
		tablero.desordenar(panelNorte.getDificultad());
		panelCentro.NuevoTablero(tablero.darTablero(), this);
		panelSur.Reiniciar();
	}
	
	public void ReiniciarTablero() {
		tablero.reiniciar();
		pastTamano = tamanoTablero;
		panelCentro.HacerTablero(pastTamano);
		panelSur.Reiniciar();
	}
	
	public void MostrarTop10() {
		ventanaT10.setVisible(true);
	}
	
	private void comprobarTop10() {
		int puntaje = tablero.calcularPuntaje();
		if (top10.esTop10(puntaje)) {
			top10.agregarRegistro(jugador, puntaje);
			GuardarTop10();
		}
	}
	
	public void GuardarTop10(){
		try {
			top10.salvarRecords(new File("data/top10.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void HacerJugada(int casillaX, int casillaY) {
		panelSur.Jugada();
		tablero.jugar(casillaX, casillaY);
		panelCentro.MostrarJugada(tablero.darTablero());
		if (chequearTablero()) {
			comprobarTop10();
		}
	}
	
	private boolean chequearTablero() {
		boolean win = true;
		boolean[][] casillas = tablero.darTablero();
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				if (casillas[i][j]) {
					win = !win;
				}
			}
		}
		return win;
	}
	
	public Font CustomFont(String fontName, int estilo, float tamanio) {
		Font font = null;
        try {
            File fuente = new File(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, fuente);
        } catch (Exception ex) {
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);            
        }
        return font.deriveFont(estilo, tamanio);
	}
    
    public static void main(String[] args) {
    	Interfaz interfaz = new Interfaz();
    	interfaz.setLocationRelativeTo(null);
    	interfaz.setVisible(true);
    	interfaz.ventanaJugador.setVisible(true);
    }
}