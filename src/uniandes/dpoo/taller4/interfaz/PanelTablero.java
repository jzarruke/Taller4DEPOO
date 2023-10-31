package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTablero extends JPanel implements MouseListener {
	private RoundRectangle2D[] tiles;
	private RoundRectangle2D[] recuadro;
	private float posX = 0;
	private float posY = 0;
	private float tamX;
	private float tamY;
	private int tamano;
	private ImageIcon luz = new ImageIcon("data/luz.png");
	private Icon iconLuz;
	private JLabel[] iconoLuz;
	private Interfaz interfaz;
	private boolean[][] tablero;
	
	public PanelTablero(boolean[][] pTablero, Interfaz pInterfaz) {
		tablero = pTablero;
		tamano = tablero.length;
		tamX = 500/tamano;
		tamY = 500/tamano;
		iconLuz = new ImageIcon(luz.getImage().getScaledInstance((int)tamX-5, (int)tamY-5, Image.SCALE_DEFAULT));
		interfaz = pInterfaz;
		HacerTablero(tamano);
		addMouseListener(this);
	}
	
	public void HacerTablero(int pTamano) {
		tamano = pTamano;
		setLayout(new GridLayout(tamano, tamano));
		tiles = new RoundRectangle2D[tamano*tamano];
		recuadro = new RoundRectangle2D[tamano*tamano];
		iconoLuz = new JLabel[tamano*tamano];
		for (int i = 0; i < tamano; i++) {
			for (int j = 0; j < tamano; j++) {
				if (j == 0) {
					posY = 0;
				}
				tiles[(i * 5) + j] = new RoundRectangle2D.Double(posX + (j * tamX), posY + (i * tamY), tamX, tamY, 15, 15);
				recuadro[(i * 5) + j] = new RoundRectangle2D.Double(posX + (j * tamX), posY + (i * tamY), tamX, tamY, 15, 15);
			}
		}
		for (int ind = 0; ind < tamano*tamano; ind++) {
			iconoLuz[ind] = new JLabel();
			iconoLuz[ind].setIcon(iconLuz);
			add(iconoLuz[ind]);
		}
		repaint();
	}
	
	public void NuevoTablero(boolean[][] pTablero, Interfaz pInterfaz) {
		new PanelTablero(pTablero, pInterfaz);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		for (int i = 0; i < tamano; i++) {
			for (int j = 0; j < tamano; j++) {
				if (tablero[i][j]) {
					g2.setColor(new Color(255, 240, 118));
				}else {
					g2.setColor(Color.GRAY);
				}
				g2.draw(tiles[(i*tamano)+j]);
				g2.fill(tiles[(i*tamano)+j]);
			}
		}
		g2.setColor(Color.GRAY);
		for (int ind = 0; ind < recuadro.length; ind++) {
			g2.draw(tiles[ind]);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		int[] casilla = convertirCoordenadasACasilla(mouseX, mouseY);
		interfaz.HacerJugada(casilla[0], casilla[1]);
	}
	
	private int[] convertirCoordenadasACasilla(int x, int y) {
		int ladoTablero = tamano;
		int altoPanelTablero = getHeight();
		int anchoPanelTablero = getWidth();
		int altoCasilla = altoPanelTablero/ladoTablero;
		int anchoCasilla = anchoPanelTablero/ladoTablero;
		int fila = (int) (y/altoCasilla);
		int columna = (int) (x/anchoCasilla);
		return new int[] {fila, columna};
	}
	
	public void MostrarJugada(boolean[][] pTablero) {
		tablero = pTablero;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {}
}