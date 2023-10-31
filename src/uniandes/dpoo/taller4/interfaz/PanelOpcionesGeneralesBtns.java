	package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpcionesGeneralesBtns extends JPanel implements ActionListener {
	private JButton btnNuevo;
    private JButton btnReiniciar;
    private JButton btnTop10;
    private JButton btnCambiarJugador;
    private Color clrBotones = new Color(41, 137, 223);
    private Interfaz interfaz;
    private VentanaCambiarJugador ventanaJugador;
	
	public PanelOpcionesGeneralesBtns(Interfaz pInterfaz, VentanaCambiarJugador ventCambJugador) {
		interfaz = pInterfaz;
		ventanaJugador = ventCambJugador;
		
		setLayout(new GridLayout(10, 1));
		
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBackground(clrBotones);
		btnNuevo.addActionListener(this);
		add(btnNuevo);
		btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.setForeground(Color.WHITE);
		btnReiniciar.setBackground(clrBotones);
		btnReiniciar.addActionListener(this);
		add(btnReiniciar);
		btnTop10 = new JButton("TOP-10");
		btnTop10.setForeground(Color.WHITE);
		btnTop10.setBackground(clrBotones);
		btnTop10.addActionListener(this);
		add(btnTop10);
		btnCambiarJugador = new JButton("CAMBIAR JUGADOR");
		btnCambiarJugador.setForeground(Color.WHITE);
		btnCambiarJugador.setBackground(clrBotones);
		btnCambiarJugador.addActionListener(this);
		add(btnCambiarJugador);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNuevo){
			interfaz.NuevoJuego();
		}else if(e.getSource() == btnReiniciar){
			interfaz.ReiniciarTablero();
		}else if(e.getSource() == btnTop10){
			interfaz.MostrarTop10();
		}else if(e.getSource() == btnCambiarJugador){
			ventanaJugador.setVisible(true);
		}
	}
}