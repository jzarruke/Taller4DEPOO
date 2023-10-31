package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelOpcionesJuego extends JPanel implements ActionListener {
	private JLabel lblTamano;
	private JLabel lblDificultad;
	private JComboBox<String> cmbxTamanos;
	private JRadioButton btnFacil;
	private JRadioButton btnMedio;
	private JRadioButton btnDificil;
	private Interfaz interfaz;
	
	public PanelOpcionesJuego(Interfaz pInterfaz) {
		interfaz = pInterfaz;
		
		setLayout(new GridLayout(1, 8));
		setBackground(new Color(41, 137, 223));
		
		add(new JLabel("    "));
		lblTamano = new JLabel("Tamaño:");
		lblTamano.setForeground(Color.WHITE);
		add(lblTamano);
		cmbxTamanos = new JComboBox<String>();
		cmbxTamanos.addItem("5x5");
		cmbxTamanos.addItem("6x6");
		cmbxTamanos.addItem("7x7");
		cmbxTamanos.addItem("8x8");
		cmbxTamanos.addActionListener(this);
		add(cmbxTamanos);
		lblDificultad = new JLabel("Dificultad:");
		lblDificultad.setForeground(Color.WHITE);
		add(lblDificultad);
		btnFacil = new JRadioButton("Fácil");
		btnFacil.setBackground(new Color(41, 137, 223));
		btnFacil.setForeground(Color.WHITE);
		btnFacil.addActionListener(this);
		btnFacil.setSelected(true);
		add(btnFacil);
		btnMedio = new JRadioButton("Medio");
		btnMedio.setBackground(new Color(41, 137, 223));
		btnMedio.setForeground(Color.WHITE);
		btnMedio.addActionListener(this);
		add(btnMedio);
		btnDificil = new JRadioButton("Difícil");
		btnDificil.setBackground(new Color(41, 137, 223));
		btnDificil.setForeground(Color.WHITE);
		btnDificil.addActionListener(this);
		add(btnDificil);
		add(new JLabel("    "));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbxTamanos){
			int tam = cmbxTamanos.getSelectedIndex();
			interfaz.CambiarTamano(tam);
		}
		if(e.getSource() == btnFacil){
			btnFacil.setSelected(true);
			btnMedio.setSelected(false);
			btnDificil.setSelected(false);
        }else if(e.getSource() == btnMedio){
        	btnFacil.setSelected(false);
			btnMedio.setSelected(true);
			btnDificil.setSelected(false);
        }else if(e.getSource() == btnDificil){
        	btnFacil.setSelected(false);
			btnMedio.setSelected(false);
			btnDificil.setSelected(true);
        }
	}
	
	public int getDificultad() {
		int tam = cmbxTamanos.getSelectedIndex()+5;
		if (btnFacil.isSelected()) {
			return (int) (tam* tam)/4;
		}else if (btnFacil.isSelected()) {
			return (int) (tam* tam)/3;
		}else {
			return (int) (tam* tam)/2;
		}
	}
}
