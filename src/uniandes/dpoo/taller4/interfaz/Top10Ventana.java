package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class Top10Ventana extends JFrame {
	private JPanel panelNorte = new JPanel();
	private JPanel panelCentro = new JPanel();
	
	public Top10Ventana (Collection<RegistroTop10> registros, Font arcdFont) {
		setSize(350, 550);
		setTitle("Top 10");
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        
        panelNorte.setBackground(Color.WHITE);
        panelNorte.setLayout(new GridLayout(2, 1));
        JLabel lblHigh = new JLabel("High Scores");
        lblHigh.setFont(arcdFont);
        lblHigh.setForeground(Color.BLACK);
        lblHigh.setHorizontalAlignment(JLabel.CENTER);
        panelNorte.add(lblHigh);
        JLabel lblNombre = new JLabel("# Nombre");
        lblNombre.setFont(arcdFont);
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setHorizontalAlignment(JLabel.CENTER);
        panelNorte.add(lblNombre);
        add(panelNorte, BorderLayout.NORTH);
        
        panelCentro.setLayout(new GridLayout(10, 7));
        panelCentro.setBackground(Color.BLACK);
		Iterator<RegistroTop10> iteratorRegoistros = registros.iterator();
		int top = 0;
		while(iteratorRegoistros.hasNext()) {
			top += 1;
			RegistroTop10 registro = iteratorRegoistros.next();
			panelCentro.add(new JLabel());
			JLabel lblPos = new JLabel(String.valueOf(top) + ".");
			lblPos.setFont(arcdFont);
			lblPos.setForeground(Color.WHITE);
			panelCentro.add(lblPos);
			panelCentro.add(new JLabel());
			JLabel lblJugador = new JLabel(registro.darNombre());
			lblJugador.setFont(arcdFont);
			lblJugador.setForeground(Color.WHITE);
			panelCentro.add(lblJugador);
			panelCentro.add(new JLabel());
			JLabel lblPuntos = new JLabel(String.valueOf(registro.darPuntos()));
			lblPuntos.setFont(arcdFont);
			lblPuntos.setForeground(Color.WHITE);
			panelCentro.add(lblPuntos);
			panelCentro.add(new JLabel());
		}
		add(panelCentro, BorderLayout.CENTER);
	}
}
