package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelOpcionesGenerales extends JPanel implements MouseListener{
	private double posX;
	private double posYNuevo;
	private double posYReiniciar;
	private double posYTop10;
	private double posYCambiarJugador;
	private double tamX;
	private double tamY;
	private RoundRectangle2D btnNuevo;
    private RoundRectangle2D btnReiniciar;
    private RoundRectangle2D btnTop10;
    private RoundRectangle2D btnCambiarJugador;
    private Interfaz interfaz;
    private VentanaCambiarJugador ventanaJugador;
	
	public PanelOpcionesGenerales(double mitadVentana, Interfaz pInterfaz, VentanaCambiarJugador ventCambJugador) {
		interfaz = pInterfaz;
		ventanaJugador = ventCambJugador;
		
		setLayout(new GridLayout(14, 1));
		
		addMouseListener(this);
		add(new JLabel("                                           "));
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		JLabel nuevo = new JLabel("               NUEVO");
		nuevo.setForeground(Color.WHITE);
		add(nuevo);
		JLabel reiniciar = new JLabel("             REINICIAR");
		reiniciar.setForeground(Color.WHITE);
		add(reiniciar);
		JLabel top10 = new JLabel("               TOP-10");
		top10.setForeground(Color.WHITE);
		add(top10);
		JLabel cambiarJugador = new JLabel("     CAMBIAR JUGADOR");
		cambiarJugador.setForeground(Color.WHITE);
		add(cambiarJugador);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		tamX = 150;
		tamY =  tamX/5;
		posX = 0;
		posYReiniciar = mitadVentana - 72;
		posYNuevo = posYReiniciar - 36;
		posYTop10 = posYReiniciar + 36;
		posYCambiarJugador = posYTop10 + 36;
		btnNuevo = new RoundRectangle2D.Double(posX, posYNuevo, tamX, tamY, 5, 5);
		btnReiniciar = new RoundRectangle2D.Double(posX, posYReiniciar, tamX, tamY, 5, 5);
	    btnTop10 = new RoundRectangle2D.Double(posX, posYTop10, tamX, tamY, 5, 5);
	    btnCambiarJugador = new RoundRectangle2D.Double(posX, posYCambiarJugador, tamX, tamY, 5, 5);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(new Color(41, 137, 223));
		
		g2.draw(btnNuevo);
		g2.draw(btnReiniciar);
		g2.draw(btnTop10);
		g2.draw(btnCambiarJugador);
		
		g2.fill(btnNuevo);
		g2.fill(btnReiniciar);
		g2.fill(btnTop10);
		g2.fill(btnCambiarJugador);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		if (mouseX >= 0 && mouseX <= tamX) {
			if(mouseY >= posYNuevo && mouseY <= posYNuevo + tamY){
				interfaz.NuevoJuego();
			}else if(mouseY >= posYReiniciar && mouseY <= posYReiniciar + tamY){
				interfaz.ReiniciarTablero();
			}else if (mouseY >= posYTop10 && mouseY <= posYTop10 + tamY) {
				interfaz.MostrarTop10();
			}else if (mouseY >= posYCambiarJugador && mouseY <= posYCambiarJugador + tamY) {
				ventanaJugador.setVisible(true);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}