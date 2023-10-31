package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaCambiarJugador extends JFrame implements ActionListener {
	private JLabel lblVacio = new JLabel("");
	private JLabel lblNombre;
	private JLabel lblIndicacionP1;
	private JLabel lblIndicacionP2;
	private JTextField txtNombre;
	private Interfaz interfaz;
	
	public VentanaCambiarJugador(Interfaz pInterfaz, Font arcdFont) {
		interfaz = pInterfaz;
		
		setSize(250, 150);
		setTitle("Cambiar jugador");
		setBackground(Color.BLACK);
		setLayout(new GridLayout(6, 1));
		
		lblVacio.setBackground(Color.BLACK);
		add(lblVacio);
		lblNombre = new JLabel("   Ingrese su nombre");
		lblNombre.setFont(arcdFont);
		add(lblNombre);
		lblIndicacionP1 = new JLabel("   recuerde que solo");
		lblIndicacionP1.setFont(arcdFont);
		add(lblIndicacionP1);
		lblIndicacionP2 = new JLabel(" deben ser 3 caracteres");
		lblIndicacionP2.setFont(arcdFont);
		add(lblIndicacionP2);
		add(lblVacio);
		txtNombre = new JTextField();
		txtNombre.setFont(arcdFont);
		txtNombre.addActionListener(this);
		add(txtNombre);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtNombre) {
			String jugador = txtNombre.getText();
			if (jugador.length() > 3) {
				JOptionPane.showMessageDialog( this, "Su nombre supera la cantidad de 3 caracteres", "Error en nombre", JOptionPane.WARNING_MESSAGE );
			}else {
				interfaz.CambiarJugador(jugador.toUpperCase());
				txtNombre.setText("");
				setVisible(false);
			}
		}
	}
}
