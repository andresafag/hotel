package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import Controller.HostController;
import Controller.ReservController;
import Database.BindReservation;
import Database.ConfirmaReservation;
import Model.ReservationModel;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import Controller.ReservController;

@SuppressWarnings("serial")
public class RegistroHuesped extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNreserva;
	private JDateChooser txtFechaN;
	private JComboBox<Format> txtNacionalidad;
	private JLabel labelExit;
	private JLabel labelAtras;
	int xMouse, yMouse;
	private HostController hostController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHuesped frame = new RegistroHuesped(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroHuesped(long reservation) {
		this.hostController =  new HostController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 944, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(new Color(12, 138, 199));
			     labelAtras.setForeground(Color.white);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(12, 138, 199));
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.WHITE);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNombre.setBounds(560, 135, 285, 33);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtApellido.setBounds(560, 204, 285, 33);
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtApellido);
		
		txtFechaN = new JDateChooser();
		txtFechaN.setBounds(560, 278, 285, 36);
		txtFechaN.getCalendarButton().setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaN.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtFechaN);
		
		txtNacionalidad = new JComboBox();
		txtNacionalidad.setBounds(560, 350, 289, 36);
		txtNacionalidad.setBackground(SystemColor.text);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] {
				 "Afghanistan", 
				  "Albania",
				  "Algeria",
				  "American Samoa",
				  "Andorra", 
				  "Angola", 
				  "Anguilla", 
				  "Antarctica", 
				  "Antigua and Barbuda", 
				  "Argentina",  
				  "Armenia",
				  "Aruba", 
				  "Australia", 
				  "Austria", 
				  "Azerbaijan", 
				  "Bahamas", 
				  "Bahrain",
				  "Bangladesh", 
				  "Barbados", 
				  "Belarus", 
				  "Belgium", 
				  "Belize", 
				  "Benin", 
				  "Bermuda", 
				  "Bhutan", 
				  "Bolivia",
				  "Bosnia and Herzegovina",
				  "Botswana",  
				  "Bouvet Island", 
				  "Brazil", 
				  "British Indian Ocean Territory",  
				  "Brunei Darussalam",  
				  "Bulgaria",  
				  "Burkina Faso", 
				  "Burundi", 
				  "Cambodia", 
				  "Cameroon", 
				  "Canada", 
				  "Cape Verde", 
				  "Cayman Islands", 
				  "Central African Republic", 
				  "Chad", 
				  "Chile", 
				  "China", 
				  "Christmas Island",  
				  "Cocos (Keeling) Islands", 
				  "Colombia", 
				  "Comoros", 
				  "Congo", 
				  "Congo, The Democratic Republic of the", 
				  "Cook Islands", 
				  "Costa Rica", 
				  "Cote D\"Ivoire", 
				  "Croatia", 
				  "Cuba", 
				  "Cyprus", 
				  "Czech Republic",
				  "Denmark", 
				  "Djibouti", 
				  "Dominica", 
				  "Dominican Republic",  
				   "Ecuador", 
				   "Egypt", 
				   "El Salvador", 
				   "Equatorial Guinea", 
				   "Eritrea", 
				   "Estonia", 
				   "Ethiopia", 
				   "Falkland Islands (Malvinas)",  
				   "Faroe Islands", 
				   "Fiji", 
				   "Finland", 
				   "France", 
				   "French Guiana", 
				   "French Polynesia", 
				   "French Southern Territories", 
				   "Gabon", 
				   "Gambia", 
				   "Georgia", 
				   "Germany", 
				   "Ghana", 
				   "Gibraltar",  
				   "Greece", 
				   "Greenland", 
				   "Grenada", 
				   "Guadeloupe",
				   "Guam",  
				   "Guatemala", 
				   "Guernsey", 
				   "Guinea", 
				   "Guinea-Bissau", 
				   "Guyana", 
				   "Haiti", 
				   "Heard Island and Mcdonald Islands", 
				   "Holy See (Vatican City State)", 
				   "Honduras", 
				   "Hong Kong", 
				   "Hungary", 
				   "Iceland", 
				   "India", 
				   "Indonesia", 
				   "Iran, Islamic Republic Of", 
				   "Iraq", 
				   "Ireland", 
				   "Israel", 
				   "Italy", 
				   "Jamaica", 
				   "Japan", 
				   "Jersey", 
				   "Jordan", 
				   "Kazakhstan", 
				   "Kenya", 
				   "Kiribati", 
				   "Korea, Democratic Republic of",  
				   "Korea, Republic of",
				   "Kuwait", 
				   "Kyrgyzstan", 
				   "Lao Democratic Republic", 
				   "Latvia", 
				   "Lebanon", 
				   "Lesotho", 
				   "Liberia", 
				   "Libyan Arab Jamahiriya",  
				   "Liechtenstein", 
				   "Lithuania", 
				   "Luxembourg", 
				   "Macao", 
				   "Macedonia, The Former Yugoslav Republic of", 
				   "Madagascar", 
				   "Malawi", 
				   "Malaysia", 
				   "Maldives",
				   "Mali", 
				   "Malta",
				   "Marshall Islands", 
				   "Martinique",  
				   "Mauritania", 
				   "Mauritius", 
				   "Mayotte", 
				   "Mexico", 
				   "Micronesia, Federated States of", 
				   "Moldova, Republic of", 
				   "Monaco", 
				   "Mongolia",
				   "Montserrat", 
				   "Morocco", 
				   "Mozambique", 
				   "Myanmar", 
				   "Namibia", 
				   "Nauru", 
				   "Nepal", 
				   "Netherlands", 
				   "Netherlands Antilles", 
				   "New Caledonia", 
				   "New Zealand", 
				   "Nicaragua", 
				   "Niger", 
				   "Nigeria", 
				   "Niue", 
				   "Norfolk Island",
				   "Northern Mariana Islands", 
				   "Norway", 
				   "Oman", 
				   "Pakistan",
				   "Palau", 
				   "Palestinian Territory",
				   "Panama", 
				   "Papua New Guinea", 
				   "Paraguay", 
				   "Peru", 
				   "Philippines", 
				   "Pitcairn",
				   "Poland",
				   "Portugal",
				   "Puerto Rico", 
				   "Qatar",  
				   "Reunion", 
				   "Romania", 
				   "Russian Federation",  
				   "RWANDA",  
				   "Saint Helena",  
				   "Saint Kitts and Nevis", 
				   "Saint Lucia", 
				   "Saint Pierre and Miquelon", 
				   "Saint Vincent and the Grenadines",  
				   "Samoa",  
				   "San Marino",  
				   "Sao Tome and Principe", 
				   "Saudi Arabia", 
				   "Senegal", 
				   "Serbia and Montenegro", 
				   "Seychelles", 
				   "Sierra Leone", 
				   "Singapore",
				   "Slovakia", 
				   "Slovenia",  
				   "Solomon Islands", 
				   "Somalia", 
				   "South Africa", 
				   "South Georgia and the South Sandwich Islands", 
				   "Spain",  
				   "Sri Lanka", 
				   "Sudan", 
				   "Suriname",  
				   "Svalbard and Jan Mayen",  
				   "Swaziland",  
				   "Sweden",  
				   "Switzerland", 
				   "Syrian Arab Republic", 
				   "Taiwan, Province of China", 
				   "Tajikistan", 
				   "Tanzania, United Republic of", 
				   "Thailand", 
				   "Timor-Leste", 
				   "Togo", 
				   "Tokelau",
				   "Tonga", 
				   "Trinidad and Tobago", 
				   "Tunisia",
				   "Turkey", 
				   "Turkmenistan",  
				   "Turks and Caicos Islands", 
				   "Tuvalu", 
				   "Uganda", 
				   "Ukraine", 
				   "United Arab Emirates", 
				   "United Kingdom",
				   "United States",
				   "United States Minor Outlying Islands", 
				   "Uruguay", 
				   "Uzbekistan", 
				   "Vanuatu", 
				   "Venezuela",
				   "Viet Nam", 
				   "Virgin Islands British", 
				   "Virgin Islands, U.S.",
				   "Wallis and Futuna", 
				   "Western Sahara",
				   "Yemen", 
				   "Zambia", 
				   "Zimbabwe"
		}));
		
		contentPane.add(txtNacionalidad);
		
		JLabel lblNombre = new JLabel("NAME");
		lblNombre.setBounds(562, 119, 253, 14);
		lblNombre.setForeground(SystemColor.textInactiveText);
		lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("LAST NAME");
		lblApellido.setBounds(560, 189, 255, 14);
		lblApellido.setForeground(SystemColor.textInactiveText);
		lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblApellido);
		
		JLabel lblFechaN = new JLabel("BIRTH DATE");
		lblFechaN.setBounds(560, 256, 255, 14);
		lblFechaN.setForeground(SystemColor.textInactiveText);
		lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblFechaN);
		
		JLabel lblNacionalidad = new JLabel("NACIONALITY");
		lblNacionalidad.setBounds(560, 326, 255, 14);
		lblNacionalidad.setForeground(SystemColor.textInactiveText);
		lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNacionalidad);
		
		JLabel lblTelefono = new JLabel("PHONE NUMBER");
		lblTelefono.setBounds(562, 406, 253, 14);
		lblTelefono.setForeground(SystemColor.textInactiveText);
		lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefono.setBounds(560, 424, 285, 33);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtTelefono);
		
		JLabel lblTitulo = new JLabel("GUEST RESERVATION");
		lblTitulo.setBounds(606, 55, 400, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 23));
		contentPane.add(lblTitulo);
		
		JLabel lblNumeroReserva = new JLabel("RESERVATION ID");
		lblNumeroReserva.setBounds(560, 474, 253, 14);
		lblNumeroReserva.setForeground(SystemColor.textInactiveText);
		lblNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNumeroReserva);
		
		txtNreserva = new JTextField();
		txtNreserva.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNreserva.setBounds(560, 495, 285, 33);
		txtNreserva.setColumns(10);
		txtNreserva.setBackground(Color.WHITE);
		txtNreserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNreserva);
		
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(560, 170, 289, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(560, 240, 289, 2);
		separator_1_2_1.setForeground(new Color(12, 138, 199));
		separator_1_2_1.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_1);
		
		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(560, 314, 289, 2);
		separator_1_2_2.setForeground(new Color(12, 138, 199));
		separator_1_2_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_2);
		
		JSeparator separator_1_2_3 = new JSeparator();
		separator_1_2_3.setBounds(560, 386, 289, 2);
		separator_1_2_3.setForeground(new Color(12, 138, 199));
		separator_1_2_3.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_3);
		
		JSeparator separator_1_2_4 = new JSeparator();
		separator_1_2_4.setBounds(560, 457, 289, 2);
		separator_1_2_4.setForeground(new Color(12, 138, 199));
		separator_1_2_4.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_4);
		
		JSeparator separator_1_2_5 = new JSeparator();
		separator_1_2_5.setBounds(560, 529, 289, 2);
		separator_1_2_5.setForeground(new Color(12, 138, 199));
		separator_1_2_5.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_5);
		
		JPanel btnguardar = new JPanel();
		
		
		btnguardar.setBounds(723, 560, 122, 35);
		
		btnguardar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
		
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
				java.sql.Date dat = java.sql.Date.valueOf(dateFormat.format(txtFechaN.getDate()));
				
				boolean binded = hostController.bindHostReserv(txtNombre.getText(), txtApellido.getText(), dat, txtNacionalidad.getSelectedItem().toString(), txtTelefono.getText(), Long.parseLong(txtNreserva.getText()));
				
				if (binded) {
					Exito exito = new Exito();
					exito.setVisible(true);
					dispose();
				} else {
					Object[] options2 = { "Understood" };
					JOptionPane.showOptionDialog(null, "Hubo una inconveniente almacenando los datos, intente de nuevo", "Advertencia",
					        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					        null, options2, options2[0]);
					return;
				}
			
			}
		});
		
		
		btnguardar.setLayout(null);
		btnguardar.setBackground(new Color(12, 138, 199));
		contentPane.add(btnguardar);
		btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel labelGuardar = new JLabel("SAVE");
		labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		labelGuardar.setForeground(Color.WHITE);
		labelGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelGuardar.setBounds(0, 0, 122, 35);
		btnguardar.add(labelGuardar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 489, 634);
		panel.setBackground(new Color(12, 138, 199));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 121, 479, 502);
		panel.add(imagenFondo);
		imagenFondo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/registro.png")));
		
		JLabel logo = new JLabel("");
		logo.setBounds(194, 59, 104, 107);
		panel.add(logo);
		logo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/Ha-100px.png")));
		
		JPanel btnexit = new JPanel();
		
		btnexit.setBounds(850, 0, 60, 45); 
		contentPane.add(btnexit);
		
		btnexit.setLayout(null);
		btnexit.setBackground(Color.white);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.black);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		
		String reserv = new Long(reservation).toString();
		txtNreserva.setText(reserv);
		txtNreserva.setEditable(false);
	
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		
//		lblMisDatos.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("hay");
//			}
//		
//		});
		
	}
	
	//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
