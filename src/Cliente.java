import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cliente {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_comname;
	private JTextField txt_contacname;
	private JTextField txt_contactitle;
	private JTextField txt_address;
	private JTextField txt_city;
	private JTextField txt_fax;
	private JTextField txt_phone;
	private JTextField txt_country;
	private JTextField txt_postalcode;
	private JTextField txt_reg;
	DataCliente conexion = new DataCliente();
	Variables var = new Variables();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente window = new Cliente();
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
	public Cliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 592, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Ingresar Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Variables.id = txt_id.getText();
				Variables.comname = txt_comname.getText();
				Variables.contacname = txt_contacname.getText();
				Variables.contactitle = txt_contactitle.getText();
				Variables.address = txt_address.getText();
				Variables.city = txt_city.getText();
				Variables.reg = txt_reg.getText();
				Variables.postalcode = txt_postalcode.getText();
				Variables.country = txt_country.getText();
				Variables.phone = txt_phone.getText();
				Variables.fax = txt_fax.getText();
				conexion.ingresarCliente();
			}
		});
		btnNewButton.setBounds(10, 233, 142, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Consultar Cliente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.consultarCliente();
				txt_id.setText(Variables.id);
				txt_comname.setText(Variables.comname);
				txt_contacname.setText(Variables.contacname);
				txt_contactitle.setText(Variables.contactitle);
				txt_address.setText(Variables.address);
				txt_city.setText(Variables.city);
				txt_reg.setText(Variables.reg);
				txt_postalcode.setText(Variables.postalcode);
				txt_country.setText(Variables.country);
				txt_phone.setText(Variables.phone);
				txt_fax.setText(Variables.fax);
				

			}
		});
		btnNewButton_1.setBounds(193, 233, 131, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Eliminar Cliente");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.eliminarCliente();
			}
			
			
		});
		btnNewButton_1_1.setBounds(193, 267, 140, 23);
		frame.getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Modificar Cliente");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Variables.id = txt_id.getText();
				Variables.comname = txt_comname.getText();
				Variables.contacname = txt_contacname.getText();
				Variables.contactitle = txt_contactitle.getText();
				Variables.address = txt_address.getText();
				Variables.city = txt_city.getText();
				Variables.reg = txt_reg.getText();
				Variables.postalcode = txt_postalcode.getText();
				Variables.country = txt_country.getText();
				Variables.phone = txt_phone.getText();
				Variables.fax = txt_fax.getText();
				conexion.modificarCliente();
				Limpiar();
			}
		});
		btnNewButton_1_2.setBounds(370, 233, 142, 23);
		frame.getContentPane().add(btnNewButton_1_2);

		JLabel lblNewLabel = new JLabel("CustomerID");
		lblNewLabel.setBounds(10, 29, 100, 14);
		frame.getContentPane().add(lblNewLabel);

		txt_id = new JTextField();
		txt_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_id.getText().length()>=5) {
					e.consume();
				}
			}
		});
		txt_id.setBounds(120, 26, 110, 20);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);

		txt_comname = new JTextField();
		txt_comname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_comname.getText().length()>=40) {
					e.consume();
				}
			}
		});
		txt_comname.setColumns(10);
		txt_comname.setBounds(120, 57, 110, 20);
		frame.getContentPane().add(txt_comname);

		JLabel lblNewLabel_1 = new JLabel("CompanyName");
		lblNewLabel_1.setBounds(10, 60, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);

		txt_contacname = new JTextField();
		txt_contacname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_contacname.getText().length()>=30) {
					e.consume();
				}
			}
		});
		txt_contacname.setColumns(10);
		txt_contacname.setBounds(120, 88, 110, 20);
		frame.getContentPane().add(txt_contacname);

		JLabel lblNewLabel_2 = new JLabel("ContactName");
		lblNewLabel_2.setBounds(10, 91, 100, 14);
		frame.getContentPane().add(lblNewLabel_2);

		txt_contactitle = new JTextField();
		txt_contactitle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_contactitle.getText().length()>=30) {
					e.consume();
				}
			}
		});
		txt_contactitle.setColumns(10);
		txt_contactitle.setBounds(120, 122, 110, 20);
		frame.getContentPane().add(txt_contactitle);

		JLabel lblNewLabel_3 = new JLabel("ContactTitle");
		lblNewLabel_3.setBounds(10, 125, 100, 14);
		frame.getContentPane().add(lblNewLabel_3);

		txt_address = new JTextField();
		txt_address.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_address.getText().length()>=60) {
					e.consume();
				}
			}
		});
		txt_address.setColumns(10);
		txt_address.setBounds(120, 156, 110, 20);
		frame.getContentPane().add(txt_address);

		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(10, 159, 100, 14);
		frame.getContentPane().add(lblNewLabel_4);

		txt_city = new JTextField();
		txt_city.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_city.getText().length()>=15) {
					e.consume();
				}
			}
			
		});
		txt_city.setColumns(10);
		txt_city.setBounds(120, 187, 110, 20);
		frame.getContentPane().add(txt_city);

		JLabel lblNewLabel_5 = new JLabel("City");
		lblNewLabel_5.setBounds(10, 190, 100, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Region");
		lblNewLabel_6.setBounds(292, 29, 100, 14);
		frame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_1_1 = new JLabel("PostalCode");
		lblNewLabel_1_1.setBounds(292, 60, 100, 14);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Country");
		lblNewLabel_2_1.setBounds(292, 91, 100, 14);
		frame.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("Phone");
		lblNewLabel_3_1.setBounds(292, 125, 100, 14);
		frame.getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1 = new JLabel("Fax");
		lblNewLabel_4_1.setBounds(292, 159, 100, 14);
		frame.getContentPane().add(lblNewLabel_4_1);

		txt_fax = new JTextField();
		txt_fax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_fax.getText().length()>=24) {
					e.consume();
				}
			}
		});
		txt_fax.setColumns(10);
		txt_fax.setBounds(402, 156, 110, 20);
		frame.getContentPane().add(txt_fax);

		txt_phone = new JTextField();
		txt_phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_phone.getText().length()>=24) {
					e.consume();
				}
			}
		});
		txt_phone.setColumns(10);
		txt_phone.setBounds(402, 122, 110, 20);
		frame.getContentPane().add(txt_phone);

		txt_country = new JTextField();
		txt_country.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_country.getText().length()>=15) {
					e.consume();
				}
			}
		});
		txt_country.setColumns(10);
		txt_country.setBounds(402, 88, 110, 20);
		frame.getContentPane().add(txt_country);

		txt_postalcode = new JTextField();
		txt_postalcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_postalcode.getText().length()>=10) {
					e.consume();
				}
			}
		});
		txt_postalcode.setColumns(10);
		txt_postalcode.setBounds(402, 57, 110, 20);
		frame.getContentPane().add(txt_postalcode);

		txt_reg = new JTextField();
		txt_reg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_reg.getText().length()>=15 ) {
					e.consume();
				}
			}
		});
		txt_reg.setColumns(10);
		txt_reg.setBounds(402, 26, 110, 20);
		frame.getContentPane().add(txt_reg);
	}

	public void Limpiar() {
		txt_id.getText();
		txt_comname.getText();
		txt_contacname.getText();
		txt_contactitle.getText();
		txt_address.getText();
		txt_city.getText();
		txt_reg.getText();
		txt_postalcode.getText();
		txt_country.getText();
		txt_phone.getText();
		txt_fax.getText();
	}
}
