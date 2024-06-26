package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import Controller.HostController;
import Controller.ReservController;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.HashMap;


@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	private ReservController reservController;
	private HostController hostController;
	JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		this.reservController =  new ReservController();
		this.hostController =  new HostController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("Search");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 500, 42);
		contentPane.add(lblNewLabel_4);
		
		
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);
	
		
		tbReservas = new JTable() {
			 public boolean isCellEditable(int row,int column){
				    if(column == 0) return false;
				    return true;
				  }
		};
		tbReservas.setAutoResizeMode(tbReservas.AUTO_RESIZE_ALL_COLUMNS);
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Reservation id");
		modelo.addColumn("Check in date");
		modelo.addColumn("Check out date");
		modelo.addColumn("Amount");
		modelo.addColumn("Payment method");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservations", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		
		tbHuespedes = new JTable(){
			 public boolean isCellEditable(int row,int column){
				 if(column == 0 || column == 6) return false;//the 4th column is not editable
				    return true;
				  }
		};
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		tbHuespedes.setAutoResizeMode(tbHuespedes.AUTO_RESIZE_ALL_COLUMNS);
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Guest id");
		modeloHuesped.addColumn("Name");
		modeloHuesped.addColumn("Last name");
		modeloHuesped.addColumn("Birthdate");
		modeloHuesped.addColumn("Nacionality");
		modeloHuesped.addColumn("Phone number");
		modeloHuesped.addColumn("Reservation id");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Guests", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
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
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		
		panel.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				txtBuscar.setText("");
				if (panel.getSelectedIndex() == 0) {
					while (modeloHuesped.getRowCount() > 0) {
						modeloHuesped.removeRow(modeloHuesped.getRowCount() - 1);
					}
				}
				
				if (panel.getSelectedIndex() == 1) {
					while (modelo.getRowCount() > 0) {
						modelo.removeRow(modelo.getRowCount() - 1);
					}
				}
				
			}
		});
		
		
		txtBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchEvent();
			}
		});
		
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
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
		
		
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		

		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchEvent();
			}
		});
		
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("Go!");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDIT");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		
		
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e ) {
				if (panel.getSelectedIndex() == 0 && tbReservas.getSelectedRow() >= 0 && reservController.reservationUpdated(tbReservas.getValueAt(tbReservas.getSelectedRow(), 1).toString(), tbReservas.getValueAt(tbReservas.getSelectedRow(), 2).toString(), tbReservas.getValueAt(tbReservas.getSelectedRow(), 3).toString(), tbReservas.getValueAt(tbReservas.getSelectedRow(), 4).toString(), tbReservas.getValueAt(tbReservas.getSelectedRow(), 0).toString()) == true) {
					JOptionPane.showMessageDialog(null, "Sucessfully updated");
				} 
				
				if (panel.getSelectedIndex() == 1 && tbHuespedes.getSelectedRow() >= 0) {
					
					if (hostController.hostEditing(tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 0).toString(), tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 1).toString(), tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 2).toString(), tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 3).toString(),  tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 4).toString(), tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 5).toString(), tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 6).toString()) == true) {
						JOptionPane.showMessageDialog(null, "Data saved successfully");
					} else {
						JOptionPane.showMessageDialog(null, "Something went wrong");
					}
				}
			}
			
		});
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("DELETE");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
		
		
		
		
		
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e ) {
				
				if (panel.getSelectedIndex() == 0 && tbReservas.getSelectedRow() >= 0 && reservController.reservationDeletion(tbReservas.getValueAt(tbReservas.getSelectedRow(), 0).toString()) == true) {
					modelo.removeRow(tbReservas.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Sucessfully deleted");
				} 
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				if (panel.getSelectedIndex() == 1 && tbHuespedes.getSelectedRow() >= 0 && hostController.hostReservdeletion(tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 6).toString()) == true) {
					modeloHuesped.removeRow(tbHuespedes.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Sucessfully deleted");
				} 
			}
			
		});
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
	    
	    
	    private void searchEvent() {
			try {
				
				if (panel.getSelectedIndex() == 0) {
					while (modelo.getRowCount() > 0) {
						modelo.removeRow(modelo.getRowCount() - 1);
					}
					//When not empty single reservation search will take place
					if (txtBuscar.getText().length() > 0) {
						ArrayList<String> singleArray;
						try {
							singleArray = reservController.getSingleReservation(txtBuscar.getText());
							for (int i = 0; i < 1; i++) {
								try {
									modelo.insertRow(0, new Object[] {singleArray.get(0), singleArray.get(1), singleArray.get(2),  singleArray.get(3),  singleArray.get(4)});
								} catch (IndexOutOfBoundsException e2) {
									JOptionPane.showMessageDialog(null, "What you typed in doesn't exist", "Unknown value",  JOptionPane.WARNING_MESSAGE);
								}
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Only enter the reservation id", "Invalid value", JOptionPane.ERROR_MESSAGE);
						}
						
						
	
						
					} else {
						HashMap<String, ArrayList<String>> ReservArray =  reservController.reservHashMap();
						
						for (int i = 0; i < ReservArray.get("numero").size(); i++) {
							modelo.insertRow(0, new Object[] {ReservArray.get("numero").get(i),ReservArray.get("checkin").get(i), ReservArray.get("checkout").get(i),  ReservArray.get("valor").get(i),  ReservArray.get("pago").get(i)});
						}
					}
				} 
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null,"Numbers only", "Wrong value", JOptionPane.WARNING_MESSAGE);
			}
			
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------				
			
			if (panel.getSelectedIndex() == 1) {
				while (modeloHuesped.getRowCount() > 0) {
					modeloHuesped.removeRow(modeloHuesped.getRowCount() - 1);
				}
				
				String guestTxt = txtBuscar.getText();
				
				if (guestTxt.split(" ").length == 2) {
					HashMap<String, ArrayList<String>> hosts = hostController.hostSearch2(guestTxt.split(" ")[0],guestTxt.split(" ")[1]);
					System.out.println("length is " + hosts.get("name").size());
					if (hosts.get("name").size() > 0) {
						for (int i = 0; i <hosts.get("name").size(); i++) {
							modeloHuesped.insertRow(0, new Object[] {hosts.get("idUser").get(i), hosts.get("name").get(i), hosts.get("lastName").get(i), hosts.get("birthDate").get(i), hosts.get("nacionality").get(i), hosts.get("phoneNumber").get(i), hosts.get("numeroReserva").get(i)});
						}
					} else {
						JOptionPane.showMessageDialog(null,"You did not enter an existent name...please try again", "Wrong input", JOptionPane.WARNING_MESSAGE);
					}
					
					
				} else {
					HashMap<String, ArrayList<String>> hosts = hostController.hostSearch(guestTxt);
					System.out.println(hostController.hostSearch(guestTxt).get("name"));
					if (hostController.hostSearch(guestTxt).get("name").size() > 0) {
						for (int i = 0; i <hosts.get("name").size(); i++) {
							modeloHuesped.insertRow(0, new Object[] {hosts.get("idUser").get(i), hosts.get("name").get(i), hosts.get("lastName").get(i), hosts.get("birthDate").get(i), hosts.get("nacionality").get(i), hosts.get("phoneNumber").get(i), hosts.get("numeroReserva").get(i)});
						}
					} else {
						JOptionPane.showMessageDialog(null,"You did not enter an existent name...please try again", "Wrong input", JOptionPane.WARNING_MESSAGE);
					}
				} 
				
				if (guestTxt.split(" ").length > 2) {
					JOptionPane.showMessageDialog(null,"You are only allowed to enter name and last name...please try again", "Wrong input", JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
	}
}
