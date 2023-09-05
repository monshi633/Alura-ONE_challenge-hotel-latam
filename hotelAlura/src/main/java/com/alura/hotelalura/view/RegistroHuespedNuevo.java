package com.alura.hotelalura.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.alura.hotelalura.controller.GuestController;
import com.alura.hotelalura.controller.ReserveController;
import com.alura.hotelalura.model.Guest;
import com.alura.hotelalura.model.Reserve;
import com.alura.hotelalura.utils.Format;
import com.toedter.calendar.JDateChooser;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

@SuppressWarnings("serial")
public class RegistroHuespedNuevo extends JFrame {

	private static RegistroReserva reservas;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private Integer txtNreserva;
	private JDateChooser txtFechaN;
	private JComboBox<String> txtNacionalidad;
	private String selectedNationality = "";
	private JLabel labelExit;
	private JLabel labelAtras;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RegistroHuespedNuevo frame = new RegistroHuespedNuevo(reservas);
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
	public RegistroHuespedNuevo(final RegistroReserva reservas) {
		super("Registro huésped - Hotel Alura");
		RegistroHuespedNuevo.reservas = reservas;

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(RegistroHuespedNuevo.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);

		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.setLayout(null);
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		final JPanel btnAtras = new JPanel();
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(12, 138, 199));
		btnAtras.setBounds(0, 0, 53, 36);
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.WHITE);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		final JPanel btnexit = new JPanel();
		btnexit.setBounds(857, 0, 53, 36);
		btnexit.setLayout(null);
		btnexit.setBackground(Color.white);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal usuario = new MenuPrincipal();
				usuario.setVisible(true);
				try {
					reservas.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
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
		labelExit.setForeground(Color.black);
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnexit.add(labelExit);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 489, 634);
		panel.setBackground(new Color(12, 138, 199));
		panel.setLayout(null);
		contentPane.add(panel);

		JLabel logo = new JLabel("");
		logo.setBounds(194, 39, 104, 107);
		logo.setIcon(new ImageIcon(RegistroHuespedNuevo.class.getResource("/imagenes/Ha-100px.png")));
		panel.add(logo);

		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 121, 479, 502);
		imagenFondo.setIcon(new ImageIcon(RegistroHuespedNuevo.class.getResource("/imagenes/registro.png")));
		panel.add(imagenFondo);

		JLabel lblTitulo = new JLabel("REGISTRO DE NUEVO HU\u00C9SPED");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(560, 55, 289, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		contentPane.add(lblTitulo);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(562, 119, 253, 14);
		lblNombre.setForeground(SystemColor.textInactiveText);
		lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(560, 189, 255, 14);
		lblApellido.setForeground(SystemColor.textInactiveText);
		lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblApellido);

		JLabel lblFechaN = new JLabel("FECHA DE NACIMIENTO");
		lblFechaN.setBounds(560, 256, 255, 14);
		lblFechaN.setForeground(SystemColor.textInactiveText);
		lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblFechaN);

		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setBounds(560, 326, 255, 14);
		lblNacionalidad.setForeground(SystemColor.textInactiveText);
		lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNacionalidad);

		JLabel lblTelefono = new JLabel("TEL\u00C9FONO");
		lblTelefono.setBounds(562, 406, 253, 14);
		lblTelefono.setForeground(SystemColor.textInactiveText);
		lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblTelefono);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(560, 170, 289, 2);
		separator_1.setForeground(new Color(12, 138, 199));
		separator_1.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(560, 240, 289, 2);
		separator_2.setForeground(new Color(12, 138, 199));
		separator_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(560, 314, 289, 2);
		separator_3.setForeground(new Color(12, 138, 199));
		separator_3.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(560, 386, 289, 2);
		separator_4.setForeground(new Color(12, 138, 199));
		separator_4.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(560, 457, 289, 2);
		separator_5.setForeground(new Color(12, 138, 199));
		separator_5.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_5);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNombre.setBounds(560, 135, 285, 33);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBorder(BorderFactory.createEmptyBorder());
		txtNombre.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (!Format.isValidString(txtNombre.getText().toString())) {
					txtNombre.setForeground(Color.RED);
				} else {
					txtNombre.setForeground(Color.BLACK);
				}
			}
		});
		contentPane.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtApellido.setBounds(560, 204, 285, 33);
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBorder(BorderFactory.createEmptyBorder());
		txtApellido.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (!Format.isValidString(txtApellido.getText().toString())) {
					txtApellido.setForeground(Color.RED);
				} else {
					txtApellido.setForeground(Color.BLACK);
				}
			}
		});
		contentPane.add(txtApellido);

		txtFechaN = new JDateChooser();
		txtFechaN.setBounds(560, 278, 285, 36);
		txtFechaN.getCalendarButton()
				.setIcon(new ImageIcon(RegistroHuespedNuevo.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaN.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtFechaN);

		txtNacionalidad = new JComboBox<>();
		txtNacionalidad.setBounds(560, 350, 289, 36);
		txtNacionalidad.setBackground(SystemColor.text);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNacionalidad.setModel(new DefaultComboBoxModel<>(new String[] { "Argentina", "Boliviana", "Brasileña",
				"Canadiense", "Chilena", "Colombiana", "Costarricense", "Cubana", "Dominicana", "Ecuatoriana",
				"Estadounidense", "Guatemalteca", "Hondureña", "Mexicana", "Nicaragüense", "Panameña", "Paraguaya",
				"Peruana", "Salvadoreña", "Uruguaya", "Venezolana" }));
		txtNacionalidad.setSelectedIndex(-1);
		txtNacionalidad.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					JComboBox<?> cb = (JComboBox<?>) e.getSource();
					selectedNationality = (String) cb.getSelectedItem();
				}
			}
		});
		contentPane.add(txtNacionalidad);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefono.setBounds(560, 424, 285, 33);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBorder(BorderFactory.createEmptyBorder());
		txtTelefono.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (!Format.isValidNumber(txtTelefono.getText().toString())) {
					txtTelefono.setForeground(Color.RED);
				} else {
					txtTelefono.setForeground(Color.BLACK);
				}
			}
		});
		contentPane.add(txtTelefono);

		JPanel btnguardar = new JPanel();
		btnguardar.setBounds(723, 560, 122, 35);
		btnguardar.setLayout(null);
		btnguardar.setBackground(new Color(12, 138, 199));
		btnguardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Format.isValidString(txtNombre.getText().toString())
						&& Format.isValidString(txtApellido.getText().toString())
						&& txtFechaN.getDate() != null
						&& selectedNationality != ""
						&& Format.isValidNumber(txtTelefono.getText())
						) {
					saveToDB();
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos correctamente.");
				}
			}
		});
		contentPane.add(btnguardar);

		JLabel labelGuardar = new JLabel("GUARDAR");
		labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		labelGuardar.setForeground(Color.WHITE);
		labelGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelGuardar.setBounds(0, 0, 122, 35);
		btnguardar.add(labelGuardar);
	}

	private void saveToDB() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Guest guest = new Guest(txtNombre.getText().toString(), txtApellido.getText().toString(),
				sdf.format(txtFechaN.getDate()).toString(), selectedNationality, txtTelefono.getText().toString());

		Reserve reserve = new Reserve(guest.getId(), sdf.format(reservas.txtFechaEntrada.getDate()).toString(),
				sdf.format(reservas.txtFechaSalida.getDate()).toString(), reservas.txtValor.getText().toString(),
				reservas.selectedPayment);

		GuestController gc = new GuestController();
		gc.createGuest(guest);
		ReserveController rc = new ReserveController();
		rc.createReserve(reserve, guest.getId());

		txtNreserva = reserve.getId();

		reservas.dispose();
		dispose();
		Exito exito = new Exito(txtNreserva);
		exito.setVisible(true);
	}
}