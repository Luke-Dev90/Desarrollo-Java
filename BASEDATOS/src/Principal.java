import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Principal extends dataBase{

	private JFrame frame,frame2;
	private JTable table;
	private JButton btnBuscar,btnModificar,btnDelete,btnClear;
	private JTextField txtCodigo,txtDescripcion,txtCantidad, txtPrecio;
	private JComboBox cBoxCantidad,cBoxPrecio;
  	private JButton btnAgregar,btnNewButton;
  	private JLabel lblNewLabel_1;

  	
  	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// frame base datos
		frame = new JFrame();
		frame.setBounds(100, 100, 656, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 628, 324);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			buscar();
			buscarDescripcion();
			buscarCantidad();
			buscarPrecio();
			}
		});
		btnBuscar.setBounds(106, 415, 91, 23);
		frame.getContentPane().add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 actualizarId();
			}
		});
		btnModificar.setBounds(217, 415, 91, 23);
		frame.getContentPane().add(btnModificar);
		
		btnDelete = new JButton("Borrar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(!txtCodigo.getText().isEmpty()) {
					borrarID();
					lblNewLabel_1.setForeground(Color.GREEN);
					lblNewLabel_1.setText("Registro borrado con exito");
				}else {
					lblNewLabel_1.setForeground(Color.RED);
					lblNewLabel_1.setText("Solo por el codigo puede borrar");
				}
				
			}
		});
		btnDelete.setBounds(547, 389, 91, 23);
		frame.getContentPane().add(btnDelete);
			
		btnClear = new JButton("Limpiar");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_1.setText("");
				txtCodigo.setText(null);
				txtDescripcion.setText(null);
				txtCantidad.setText(null);
				txtPrecio.setText(null);
				table.setVisible(false);
			}
		});
		btnClear.setBounds(547, 360, 91, 23);
		frame.getContentPane().add(btnClear);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 387, 86, 20);
		frame.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(106, 387, 205, 20);
		frame.getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(321, 387, 91, 20);
		frame.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(422, 387, 97, 20);
		frame.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(30, 360, 61, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescripcin.setBounds(172, 360, 86, 14);
		frame.getContentPane().add(lblDescripcin);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidad.setBounds(338, 360, 74, 14);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblPUnitario = new JLabel("P. unitario");
		lblPUnitario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPUnitario.setBounds(432, 360, 74, 14);
		frame.getContentPane().add(lblPUnitario);
		
		cBoxCantidad = new JComboBox();
		cBoxCantidad.setModel(new DefaultComboBoxModel(new String[] {"igual", "mayor o igual", "menor o igual"}));
		cBoxCantidad.setBounds(321, 415, 91, 22);
		frame.getContentPane().add(cBoxCantidad);
		
		
		
		
		cBoxPrecio = new JComboBox();
		cBoxPrecio.setModel(new DefaultComboBoxModel(new String[] {"igual", "mayor o igual", "menor o igual"}));
		cBoxPrecio.setBounds(422, 415, 97, 22);
		frame.getContentPane().add(cBoxPrecio);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				agregarId();
			
			}
			
		});
		btnAgregar.setBounds(10, 415, 86, 23);
		frame.getContentPane().add(btnAgregar);
		
		btnNewButton = new JButton("Ver tabla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
			}
		});
		btnNewButton.setBounds(547, 420, 91, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 346, 298, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	 private void mostrar() { //mostrar base de dato asociada
		 table.setVisible(true);
		DefaultTableModel modelo = new DefaultTableModel();
		ResultSet rs = dataBase.getTabla("select idCodigo, descripcion,cantidad,precioUnitario from inventario");
		modelo.setColumnIdentifiers(new Object[] {"idCodigo","descripcion","cantidad","precioUnitario"});
	try {
		while(rs.next()) {
			modelo.addRow(new Object[] {rs.getInt("idCodigo"),rs.getString("descripcion"),rs.getInt("cantidad"),rs.getDouble("precioUnitario")});
		}
		table.setModel(modelo);
	}catch(Exception e) {
		System.out.println(e);
		 }
	}
	
	private void buscar() { 	//busqueda por codigo
	
		table.setVisible(true);
		if(!txtCodigo.getText().isEmpty()) {
		int idCodigo = Integer.parseInt(txtCodigo.getText());		
		DefaultTableModel modelo = new DefaultTableModel();
		ResultSet rs = dataBase.getTabla("select idCodigo, descripcion, cantidad, precioUnitario from inventario where idCodigo="+idCodigo);
		modelo.setColumnIdentifiers(new Object[] {"idCodigo","descripcion","cantidad","precioUnitario"});
		try {
			while(rs.next()) {
				modelo.addRow(new Object[] { rs.getInt("idCodigo"),rs.getString("descripcion"),
						rs.getInt("cantidad"),rs.getDouble("precioUnitario")});
				break;
			}
			table.setModel(modelo);
			System.out.println("Busqueda por codigo realizada");
		}catch(Exception e) {
			System.out.println(e);
			}
			}
		//busqueda por descripcion relacionada en TextField Descripcion
		}
	
		private void buscarDescripcion() {
			table.setVisible(true);
		if((!txtDescripcion.getText().isEmpty())){
			String descripcion = txtDescripcion.getText();		
			DefaultTableModel modelo = new DefaultTableModel();
			ResultSet rsD = dataBase.getTabla("select idCodigo,descripcion,cantidad,precioUnitario from inventario where descripcion like"+"'%"+descripcion+"%'");
			
			modelo.setColumnIdentifiers(new Object[] {"idCodigo","descripcion","cantidad","precioUnitario"});
			try {
				while(rsD.next()) {
					modelo.addRow(new Object[] { rsD.getInt("idCodigo"),rsD.getString("descripcion"),
							rsD.getInt("cantidad"),rsD.getDouble("precioUnitario")});
					}
				table.setModel(modelo);
			}catch(Exception e) {
				System.out.println(e);
			}
		 }
		}
		
	private void buscarCantidad() {	
		
		table.setVisible(true);
		int comparar = cBoxCantidad.getSelectedIndex();
		
		switch (comparar) {
		case 0 :
			if(!txtCantidad.getText().isEmpty()){ //Busqueda filtrada segun ComboBox
				// Iguales
				int cantidad = Integer.parseInt(txtCantidad.getText());		
				DefaultTableModel modelo = new DefaultTableModel();
				ResultSet rsD = dataBase.getTabla("select * from inventario where cantidad="+"'"+cantidad+"'");
				modelo.setColumnIdentifiers(new Object[] {"idCodigo","descripcion","cantidad","precioUnitario"});
				
				try {
					while(rsD.next()) {
						modelo.addRow(new Object[] { rsD.getInt("idCodigo"),rsD.getString("descripcion"),
								rsD.getInt("cantidad"),rsD.getDouble("precioUnitario")});
						}
					table.setModel(modelo);	
			}catch(Exception e) {
				System.out.println(e);
			}
				//mayor o igual
			}
			break;
		case 1: // Mayor o igual
			if(!txtCantidad.getText().isEmpty()){ //Busqueda filtrada segun ComboBox 
				int cantidad = Integer.parseInt(txtCantidad.getText());		
				DefaultTableModel modelo = new DefaultTableModel();
				ResultSet rsD = dataBase.getTabla("select * from inventario where cantidad>="+"'"+cantidad+"'");
				modelo.setColumnIdentifiers(new Object[] {"idCodigo","descripcion","cantidad","precioUnitario"});
				
				try {
					while(rsD.next()) {
						modelo.addRow(new Object[] { rsD.getInt("idCodigo"),rsD.getString("descripcion"),
								rsD.getInt("cantidad"),rsD.getDouble("precioUnitario")});
						}
					table.setModel(modelo);	
			}catch(Exception e) {
				System.out.println(e);
			}
		}
			break;
		case 2:  //menor o igual

			if(!txtCantidad.getText().isEmpty()){
				
				int cantidad = Integer.parseInt(txtCantidad.getText());		
				
				DefaultTableModel modelo = new DefaultTableModel();
				ResultSet rsD = dataBase.getTabla("select * from inventario where cantidad <="+"'"+cantidad +"'");
				
				modelo.setColumnIdentifiers(new Object[] {"idCodigo","descripcion","cantidad","precioUnitario"});
				try {
					while(rsD.next()) {
						modelo.addRow(new Object[] { rsD.getInt("idCodigo"),rsD.getString("descripcion"),
								rsD.getInt("cantidad"),rsD.getDouble("precioUnitario")});
						}
					table.setModel(modelo);
					
				
			}catch(Exception e) {
				System.out.println(e);
			}
		 }
		}
	}
	
	private void buscarPrecio() {
		
		table.setVisible(true);
		int comparar = cBoxPrecio.getSelectedIndex();
		
		switch (comparar) {
		case 0 :
			if(!txtPrecio.getText().isEmpty()){ //Busqueda filtrada segun ComboBox
				// Iguales
				double precio = Double.parseDouble(txtPrecio.getText());		
				DefaultTableModel modelo = new DefaultTableModel();
				
				ResultSet rsD = dataBase.getTabla("select * from inventario where precioUnitario="+"'"+precio+"'");
				modelo.setColumnIdentifiers(new Object[] {"idCodigo","descripcion","cantidad","precioUnitario"});
				
				try {
					while(rsD.next()) {
						modelo.addRow(new Object[] { rsD.getInt("idCodigo"),rsD.getString("descripcion"),
								rsD.getInt("cantidad"),rsD.getDouble("precioUnitario")});
						}
					table.setModel(modelo);	
			}catch(Exception e) {
				System.out.println(e);
			}
				//mayor o igual
			}
			break;
		case 1: // Mayor o igual
			if(!txtPrecio.getText().isEmpty()){ 
				double precio = Double.parseDouble(txtPrecio.getText());		
				DefaultTableModel modelo = new DefaultTableModel();
				ResultSet rsD = dataBase.getTabla("select * from inventario where precioUnitario>="+"'"+precio+"'");
				modelo.setColumnIdentifiers(new Object[] {"idCodigo","descripcion","cantidad","precioUnitario"});
				
				try {
					while(rsD.next()) {
						modelo.addRow(new Object[] { rsD.getInt("idCodigo"),rsD.getString("descripcion"),
								rsD.getInt("cantidad"),rsD.getDouble("precioUnitario")});
						}
					table.setModel(modelo);	
			}catch(Exception e) {
				System.out.println(e);
			}
		}
			break;
		case 2:  //menor o igual

			if(!txtPrecio.getText().isEmpty()){
				
				double precio = Double.parseDouble(txtPrecio.getText());		
				DefaultTableModel modelo = new DefaultTableModel();
				
				ResultSet rsD = dataBase.getTabla("select * from inventario where precioUnitario <="+"'"+precio +"'");
				modelo.setColumnIdentifiers(new Object[] {"idCodigo","descripcion","cantidad","precioUnitario"});
				
				try {
					while(rsD.next()) {
						modelo.addRow(new Object[] { rsD.getInt("idCodigo"),rsD.getString("descripcion"),
								rsD.getInt("cantidad"),rsD.getDouble("precioUnitario")});
						}
					table.setModel(modelo);
			}catch(Exception e) {
				System.out.println(e);
			}
		 }
		}
	}
	private void borrarID() {
		
	if(!txtCodigo.getText().isEmpty()) {
		dataBase borrar = new dataBase();
		int idCodigo = Integer.parseInt(txtCodigo.getText());
		String query = "Delete from inventario where idCodigo="+idCodigo;
		borrar.getUpdate(query);
			}
	}
	private void agregarId() {
		
		dataBase agregar = new dataBase();

		String descripcion = txtDescripcion.getText();
		String cantidad = txtCantidad.getText();
		String precioUnitario = txtPrecio.getText();
		
		String query = "insert into deposito.inventario (descripcion,cantidad,precioUnitario)"
				+ " values('"+descripcion+"','"+cantidad+"','"+precioUnitario+"')";
		agregar.getUpdate(query);
		
		txtDescripcion.setText("");
		txtCantidad.setText("");
		txtPrecio.setText("");
		txtDescripcion.requestFocus();
}
	private void actualizarId() {
		
	int idCodigo = Integer.parseInt(txtCodigo.getText());
	String descripcion = txtDescripcion.getText();
	String cantidad = txtCantidad.getText();
	String precioUnitario = txtPrecio.getText();
	String query = "UPDATE inventario set idCodigo='"+idCodigo+"',descripcion='"+descripcion+"', cantidad ='"+cantidad+"',precioUnitario='"+precioUnitario+"' where idCodigo="+idCodigo;
	dataBase actualizar = new dataBase();
	actualizar.getUpdate(query);
	
}
		
	}




	

