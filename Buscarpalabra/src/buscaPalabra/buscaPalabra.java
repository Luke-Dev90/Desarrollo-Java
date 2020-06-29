package buscaPalabra;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class buscaPalabra extends JFrame {
		
	private static JFrame ventana;
	private static JTextField txtBusqueda;
	private static JButton btnBuscar;
	private static String Busqueda;
	private static JLabel lblBusqueda;
	
	String Palabras[] = new String[] {"televisor","computadora","heladera","ropero","impresora"};
		
		public buscaPalabra() {
			inicializar();
		}

		public void inicializar() {
			ventana = new JFrame();
			ventana.setTitle("Busqueda");
			ventana.setTitle("Busqueda");
			ventana.setBounds(100, 100, 300, 300);
			ventana.getContentPane().setLayout(null);
			ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
			
			txtBusqueda = new JTextField();
			txtBusqueda.setBounds(50, 20, 100, 25);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(50, 50, 100, 25);
			btnBuscar.addActionListener(new ActionListener(){
			
				public void actionPerformed(ActionEvent e) {
				
				Busqueda = txtBusqueda.getText();
				busqueda();
				
				}
			 }
			);
			lblBusqueda = new JLabel();
			lblBusqueda.setBounds(50, 100, 300, 30);
			lblBusqueda.setForeground(Color.green);
			lblBusqueda.setFont(new Font("arial", Font.BOLD ,14));
			ventana.add(txtBusqueda);
			ventana.add(btnBuscar);
			ventana.add(lblBusqueda);
		}
		
	public static void main(String[] args) {
		
		buscaPalabra ventana = new buscaPalabra();
		ventana.ventana.setVisible(true);
	}
	public void busqueda() {
		
		int i = 0;
		
		try {
		while(i < Palabras.length && !Palabras[i].equalsIgnoreCase(Busqueda)) {
		i++;
		if(Palabras[i].equalsIgnoreCase(Busqueda)) {
			lblBusqueda.setForeground(Color.black);
			lblBusqueda.setText(Busqueda +" estaba en la posicion n°" + i);	
				}
			}
		}catch(Exception e) {
			lblBusqueda.setForeground(Color.RED);
			lblBusqueda.setText("No se encontro");	
	}
		
	
	}
}
	
