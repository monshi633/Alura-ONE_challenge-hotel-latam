package com.alura.hotelalura.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.alura.hotelalura.controller.GuestController;
import com.alura.hotelalura.controller.ReserveController;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbGuests;
	private JTable tbReserves;
	private DefaultTableModel modelReserves;
	private DefaultTableModel modelGuests;
	private JLabel labelAtras;
	private JLabel labelExit;
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
		super("B�squeda reservas - Hotel Alura");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
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
		contentPane.add(header);

		final JPanel btnAtras = new JPanel();
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal usuario = new MenuPrincipal();
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
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		final JPanel btnexit = new JPanel();
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Bienvenida principal = new Bienvenida();
				principal.setVisible(true);
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
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblLogo.setBounds(56, 51, 104, 107);
		contentPane.add(lblLogo);

		JLabel lblTitulo = new JLabel("SISTEMA DE B�SQUEDA");
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblTitulo.setBounds(331, 62, 280, 42);
		contentPane.add(lblTitulo);

		txtBuscar = new JTextField();
		txtBuscar.setText("Ingrese apellido o n�mero de reserva");
		txtBuscar.setForeground(SystemColor.textInactiveText);
		txtBuscar.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtBuscar.setBounds(530, 127, 200, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtBuscar.setColumns(10);
		String defaultText = "Ingrese apellido o n�mero de reserva";
		txtBuscar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtBuscar.getText().equals(defaultText)) {
					txtBuscar.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtBuscar.getText().equals("")) {
					txtBuscar.setText(defaultText);
				}
			}
		});
		contentPane.add(txtBuscar);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(12, 138, 199));
		separator.setBackground(new Color(12, 138, 199));
		separator.setBounds(530, 159, 200, 2);
		contentPane.add(separator);

		JPanel btnBuscar = new JPanel();
		btnBuscar.setLayout(null);
		btnBuscar.setBackground(new Color(12, 138, 199));
		btnBuscar.setBounds(748, 125, 122, 35);
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtBuscar.getText().length() > 0) {
					readFromDB(txtBuscar.getText().toString());
				}
			}
		});
		contentPane.add(btnBuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnBuscar.add(lblBuscar);

//		Results panel
		final JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		tbReserves = new JTable();
		tbReserves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReserves.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelReserves = (DefaultTableModel) tbReserves.getModel();
		modelReserves.addColumn("Numero de Reserva");
		modelReserves.addColumn("Numero de Huesped");
		modelReserves.addColumn("Fecha Check In");
		modelReserves.addColumn("Fecha Check Out");
		modelReserves.addColumn("Valor");
		modelReserves.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReserves);
		scroll_table.setVisible(true);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table,
				null);

		tbGuests = new JTable();
		tbGuests.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbGuests.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelGuests = (DefaultTableModel) tbGuests.getModel();
		modelGuests.addColumn("N�mero de Huesped");
		modelGuests.addColumn("Nombre");
		modelGuests.addColumn("Apellido");
		modelGuests.addColumn("Fecha de Nacimiento");
		modelGuests.addColumn("Nacionalidad");
		modelGuests.addColumn("Telefono");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbGuests);
		scroll_tableHuespedes.setVisible(true);
		panel.addTab("Hu�spedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")),
				scroll_tableHuespedes, null);

		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int tab = panel.getSelectedIndex();
				updateToDB(tab);
			}
		});
		contentPane.add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int tab = panel.getSelectedIndex();
				deleteFromDB(tab);
			}
		});
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
	}

	private void readFromDB(String input) {
//		Clear view
		modelReserves.setRowCount(0);
		modelGuests.setRowCount(0);
		
		ReserveController rc = new ReserveController();
		GuestController gc = new GuestController();

		if (input.matches("\\d+")) { // input is a number
			// read reserve
			Integer reserveNumber = Integer.parseInt(input);
			if (!rc.readReserveId(reserveNumber).isEmpty()) {
				modelReserves.addRow(rc.readReserveId(reserveNumber));
				// read guest
				Integer guestId = Integer.valueOf(modelReserves.getValueAt(0, 1).toString());
				modelGuests.addRow(gc.readGuestId(guestId));
			}
		} else if (input.matches("[a-zA-Z ]+")) { // input is a string
			// read guest
			if (!gc.readGuestLastName(input).isEmpty()) {
				Integer guestListSize = gc.readGuestLastName(input).size();
				for (int i = 0; i < guestListSize; i++) {
					modelGuests.addRow(gc.readGuestLastName(input).get(i));
					Integer guestId = Integer.valueOf(modelGuests.getValueAt(i, 0).toString());
					Integer reserveListSize = rc.readReserveGuestId(guestId).size();
					// read reserve
					for (int j = 0; j < reserveListSize; j++) {
						modelReserves.addRow(rc.readReserveGuestId(guestId).get(j));
					}
				}
			}
		}
	}

	private void updateToDB(int tab) {
		Integer index;
		if (tab == 0 && tbReserves.getSelectedRow() != -1) {
			index = tbReserves.getSelectedRow();
			
			Integer id = Integer.valueOf(tbReserves.getValueAt(index, 0).toString());
			Integer guestId = Integer.valueOf(tbReserves.getValueAt(index, 1).toString());
			String dateIn = tbReserves.getValueAt(index, 2).toString();
			String dateOut = tbReserves.getValueAt(index, 3).toString();
			String price = tbReserves.getValueAt(index, 4).toString();
			String paymentMethod = tbReserves.getValueAt(index, 5).toString();

			ReserveController rc = new ReserveController();
			rc.updateReserve(id, guestId, dateIn, dateOut, price, paymentMethod);

			JOptionPane.showMessageDialog(null, "Reserva actualizada.");
		} else if (tab == 1 && tbGuests.getSelectedRow() != -1) {
			index = tbGuests.getSelectedRow();

			Integer id = Integer.valueOf(tbGuests.getValueAt(index, 0).toString());
			String name = tbGuests.getValueAt(index, 1).toString();
			String lastName = tbGuests.getValueAt(index, 2).toString();
			String birthDate = tbGuests.getValueAt(index, 3).toString();
			String nationality = tbGuests.getValueAt(index, 4).toString();
			String phone = tbGuests.getValueAt(index, 5).toString();

			GuestController gc = new GuestController();
			gc.updateGuest(id, name, lastName, birthDate, nationality, phone);

			JOptionPane.showMessageDialog(null, "Huesped actualizado.");
		}
	}

	/*
	 * When an int is entered, it deletes a reserve with matching id When a string
	 * is entered, it deletes a guest with matching id AND all the reserves linked
	 * to that guest id
	 */
	private void deleteFromDB(Integer tab) {
		if (tab == 0 && tbReserves.getSelectedRow() != -1) {
			ReserveController rc = new ReserveController();
			Object selectedValue = tbReserves.getValueAt(tbReserves.getSelectedRow(), 0);
			Integer id = Integer.parseInt(selectedValue.toString());

			rc.deleteReserveId(id);

			modelReserves.removeRow(tbReserves.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Reserva eliminada.");
		} else if (tab == 1 && tbGuests.getSelectedRow() != -1) {
			ReserveController rc = new ReserveController();
			GuestController gc = new GuestController();

			Object selectedValue = tbGuests.getValueAt(tbGuests.getSelectedRow(), 0);
			Integer id = Integer.parseInt(selectedValue.toString());

			gc.deleteGuest(id);
			rc.deleteReserveGuestId(id);

			modelGuests.removeRow(tbGuests.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Huesped eliminado junto con todas sus reservas.");
		}
	}

	private void headerMousePressed(MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}