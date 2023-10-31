package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDatos extends JPanel {
	private JLabel lblJugadas;
	private JLabel lblJugador;
	private JTextField txtJugadas;
	private JTextField txtJugador;
	private String jugador;
	
	public PanelDatos(String pJugador) {
		jugador = pJugador;
		
		setLayout(new GridLayout(1, 4));
		
		lblJugadas = new JLabel("Jugadas:");
		add(lblJugadas);
		txtJugadas = new JTextField("0");
		txtJugadas.setEditable(false);
		add(txtJugadas);
		lblJugador = new JLabel("Jugador:");
		add(lblJugador);
		txtJugador = new JTextField(jugador);
		txtJugador.setEditable(false);
		add(txtJugador);
	}
	
	public void CambioJugador(String player){
		txtJugador.setText(player);
	}
	
	public void Jugada() {
		String cantJugadas = Integer.toString(Integer.parseInt(txtJugadas.getText())+1);
		txtJugadas.setText(cantJugadas);
	}
	
	public void Reiniciar() {
		String cantJugadas = "0";
		txtJugadas.setText(cantJugadas);
	}
}
