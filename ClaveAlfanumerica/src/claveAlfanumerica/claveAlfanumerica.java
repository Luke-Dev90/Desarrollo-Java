package claveAlfanumerica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class claveAlfanumerica  extends JFrame{
	
	JFrame frame;
	JButton btnGenerar;
	JLabel lblMostrar , lblMostrar2;
	
	public static final int LIM = 1;
	
	public claveAlfanumerica() {
		
		inicializar();
	}
	
	public static void main(String[] args) {
		
		claveAlfanumerica ventana = new claveAlfanumerica();
		
	}
	
	public void inicializar() {
		
		frame = new JFrame("Generar codigo");
		frame.setSize(350,200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		lblMostrar = new JLabel();
		lblMostrar.setBounds(50, 30, 250, 25);
		lblMostrar.setText("Presione el boton para generar clave");
		lblMostrar.setFont(new Font("arial", Font.BOLD,12));
		lblMostrar.setForeground(Color.BLACK);
		
		lblMostrar2 = new JLabel();
		lblMostrar2.setText("Presione el boton para generar clave");
		lblMostrar2.setFont(new Font("arial", Font.BOLD,12));
		lblMostrar2.setForeground(Color.BLACK);
		
		btnGenerar = new JButton("Generar clave");
		btnGenerar.setBounds(80, 80, 150, 25);
		
		btnGenerar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					generarClave();
					
				}});
		frame.add(btnGenerar);
		frame.add(lblMostrar);
		frame.add(lblMostrar2);
		
		
	}
	public void generarClave() {
	Random r = new Random();
		
		char a = (char) (r.nextInt(10)+ 'b');
		char b = (char) (r.nextInt(10) + 'b');
		char c = (char) (r.nextInt(10) + 'b');
		int num1 = r.nextInt(9);
		int num2 = r.nextInt(6);
		int num3 = r.nextInt(3);
		
	    String claveAlfanumerica = (String) (a +""+ num1 + ""+ b + "" + num2 + "" + num3 + "" + c);
	    lblMostrar2.setBounds(140,50,150,25);
	    lblMostrar2.setText(claveAlfanumerica);
	    lblMostrar2.setFont(new Font("arial", Font.BOLD,12));
	    
	   
		}
	
}
