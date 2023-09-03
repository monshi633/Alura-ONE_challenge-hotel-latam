package com.alura.hotelalura.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Vector;

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
import com.alura.hotelalura.model.Reserve;

@SuppressWarnings("serial")
public class RegistroHuespedExistente extends JFrame {

	private static RegistroReserva reservas;
	private JPanel contentPane;
	private JLabel labelExit;
	private JLabel labelAtras;
	private JComboBox<String> txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private Integer txtNreserva;
	private JTextField txtFechaN;
	private JTextField txtNacionalidad;
	private String selectedName;
	private Integer guestId;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RegistroHuespedExistente frame = new RegistroHuespedExistente(reservas);
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
	public RegistroHuespedExistente(final RegistroReserva reservas) {
		super("Registro huésped - Hotel Alura");
		RegistroHuespedExistente.reservas = reservas;

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(RegistroHuespedExistente.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.setLayout(null);
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		final JPanel btnAtras = new JPanel();
		btnAtras.setBounds(0, 0, 53, 36);
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(12, 138, 199));
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
		labelAtras.setBounds(0, 0, 53, 36);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.WHITE);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		btnAtras.add(labelAtras);

		final JPanel btnexit = new JPanel();
		btnexit.setBounds(857, 0, 53, 36);
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
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
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setForeground(Color.black);
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
		logo.setIcon(new ImageIcon(RegistroHuespedExistente.class.getResource("/imagenes/Ha-100px.png")));
		panel.add(logo);

		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 121, 479, 502);
		imagenFondo.setIcon(new ImageIcon(RegistroHuespedExistente.class.getResource("/imagenes/registro.png")));
		panel.add(imagenFondo);

		JLabel lblTitulo = new JLabel("REGISTRO DE HU\u00C9SPED EXISTENTE");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(499, 55, 401, 42);
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

		txtNombre = new JComboBox<>();
		txtNombre.setEnabled(false);
		txtNombre.setBounds(560, 135, 285, 33);
		txtNombre.setBackground(SystemColor.text);
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNombre.setModel(new DefaultComboBoxModel<>(new String[] {}));
		txtNombre.setSelectedIndex(-1);
		contentPane.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setBounds(560, 204, 253, 36);
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBorder(BorderFactory.createEmptyBorder());
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtNombre.setEnabled(false);
				txtNombre.removeAllItems();
			}
		});
		contentPane.add(txtApellido);

		JPanel btnBuscar = new JPanel();
		btnBuscar.setBounds(814, 204, 36, 36);
		btnBuscar.setLayout(null);
		btnBuscar.setBackground(new Color(12, 138, 199));
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GuestController gc = new GuestController();
				if (!gc.readGuestLastName(txtApellido.getText()).isEmpty()) {
					Integer guestListSize = gc.readGuestLastName(txtApellido.getText()).size();
					for (int i = 0; i < guestListSize; i++) {
						txtNombre.addItem(gc.readGuestLastName(txtApellido.getText()).get(i).get(1).toString());
					}
					txtNombre.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Ningún huésped encontrado con ese apellido.");
				}
			}
		});
		contentPane.add(btnBuscar);

		JLabel lblBuscar = new JLabel(new ImageIcon(Busqueda.class.getResource("/imagenes/lupa2.png")));
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 7));
		lblBuscar.setBounds(1, 1, 33, 33);
		btnBuscar.add(lblBuscar);

		txtFechaN = new JTextField();
		txtFechaN.setBounds(560, 278, 285, 33);
		txtFechaN.setEditable(false);
		txtFechaN.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFechaN.setBackground(Color.WHITE);
		txtFechaN.setForeground(Color.black);
		txtFechaN.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(txtFechaN);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(560, 350, 285, 33);
		txtNacionalidad.setEditable(false);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNacionalidad.setBackground(Color.WHITE);
		txtNacionalidad.setForeground(Color.black);
		txtNacionalidad.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(txtNacionalidad);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(560, 424, 285, 33);
		txtTelefono.setEditable(false);
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setForeground(Color.black);
		txtTelefono.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(txtTelefono);

		JPanel btnGuardar = new JPanel();
		btnGuardar.setBounds(723, 560, 122, 35);
		btnGuardar.setLayout(null);
		btnGuardar.setBackground(new Color(12, 138, 199));
		btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtApellido.getText() != "") {
					saveToDB();
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
				}
			}
		});
		contentPane.add(btnGuardar);

		txtNombre.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				GuestController gc = new GuestController();
				if (e.getStateChange() == ItemEvent.SELECTED) {
					JComboBox<?> cb = (JComboBox<?>) e.getSource();
					selectedName = (String) cb.getSelectedItem();
					Vector<String> retrievedGuest = gc.readGuestFullName(selectedName, txtApellido.getText());
					guestId = Integer.valueOf(retrievedGuest.get(0));
					txtFechaN.setText(retrievedGuest.get(3));
					txtNacionalidad.setText(retrievedGuest.get(4));
					txtTelefono.setText(retrievedGuest.get(5));
				}
			}
		});

		JLabel lblGuardar = new JLabel("GUARDAR");
		lblGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardar.setForeground(Color.WHITE);
		lblGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblGuardar.setBounds(0, 0, 122, 35);
		btnGuardar.add(lblGuardar);
	}

	private void saveToDB() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Reserve reserve = new Reserve(guestId, sdf.format(reservas.txtFechaEntrada.getDate()).toString(),
				sdf.format(reservas.txtFechaSalida.getDate()).toString(), reservas.txtValor.getText().toString(),
				reservas.selectedPayment);

		ReserveController rc = new ReserveController();
		rc.createReserve(reserve, guestId);

		txtNreserva = reserve.getId();

		reservas.dispose();
		dispose();
		Exito exito = new Exito(txtNreserva);
		exito.setVisible(true);
	}
}