package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import factory.ConnectionFactory;
import model.Guests;
import model.Reserves;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class RegistroHuesped extends JFrame {

	private static RegistroReservas reservas;
	private JPanel contentPane;
	private static JTextField txtNombre;
	private static JTextField txtApellido;
	private static JTextField txtTelefono;
//	private static JTextField txtNreserva;
	private static JDateChooser txtFechaN;
	private static JComboBox<Format> txtNacionalidad;
	private JLabel labelExit;
	private JLabel labelAtras;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHuesped frame = new RegistroHuesped(reservas);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RegistroHuesped(final RegistroReservas reservas) {
		super("Registro huésped - Hotel Alura");
		RegistroHuesped.reservas = reservas;
		
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/imagenes/lOGO-50PX.png")));
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
		header.setLayout(null);
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

//		TO DO: cuando hago click en siguiente me abre una nueva ventana sin cerrar esta, si la muevo puedo ver las dos ventanas
//		si voy para atrás en reservas o si la cierro sin cerrar huésped se me duplica el árbol
//		Para resolverlo, o hago que los datos se guarden incluso cuando se cierra registro reservas y me lleva al registro huespedes
//		o que por más que se puedan ver las dos ventanas, registro reservas no se pueda tocar hasta haber accionado algún botón en registro huespedes
		final JPanel btnAtras = new JPanel();
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
		txtFechaN.getCalendarButton()
				.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaN.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtFechaN);

		txtNacionalidad = new JComboBox();
		txtNacionalidad.setBounds(560, 350, 289, 36);
		txtNacionalidad.setBackground(SystemColor.text);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
//		TO DO: emprolijar esto...
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] { "afgano-afgana", "alemán-", "alemana",
				"árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana",
				"brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china",
				"colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana",
				"danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña",
				"escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia",
				"etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa",
				"griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa",
				"hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní",
				"irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana",
				"laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí",
				"mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa",
				"panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa",
				"puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca",
				"suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana",
				"uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita" }));
		String selectedNationality = (String) txtNacionalidad.getSelectedItem();
		contentPane.add(txtNacionalidad);

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

		JLabel lblTelefono = new JLabel("TELÉFONO");
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

		JLabel lblTitulo = new JLabel("REGISTRO DE NUEVO HUÉSPED");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(560, 55, 289, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		contentPane.add(lblTitulo);

//		JLabel lblNumeroReserva = new JLabel("NÚMERO DE RESERVA");
//		lblNumeroReserva.setBounds(560, 474, 253, 14);
//		lblNumeroReserva.setForeground(SystemColor.textInactiveText);
//		lblNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
//		contentPane.add(lblNumeroReserva);
//
//		txtNreserva = new JTextField();
//		txtNreserva.setFont(new Font("Roboto", Font.PLAIN, 16));
//		txtNreserva.setBounds(560, 495, 285, 33);
//		txtNreserva.setColumns(10);
//		txtNreserva.setBackground(Color.WHITE);
//		txtNreserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		contentPane.add(txtNreserva);

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

//		JSeparator separator_1_2_5 = new JSeparator();
//		separator_1_2_5.setBounds(560, 529, 289, 2);
//		separator_1_2_5.setForeground(new Color(12, 138, 199));
//		separator_1_2_5.setBackground(new Color(12, 138, 199));
//		contentPane.add(separator_1_2_5);

		JPanel btnguardar = new JPanel();
		btnguardar.setBounds(723, 560, 122, 35);
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (RegistroHuesped.txtNombre.getText() != null && RegistroHuesped.txtFechaN.getDate() != null) {
//					TO DO: guardar en base de datos
					ConnectionFactory factory = new ConnectionFactory();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Connection con = factory.createConnection();
						Guests guests = new Guests(con);
						Reserves reserves = new Reserves(con);
//						TO DO: Casi perfecto, están fallando los get de contenido de los drop down selectedNationality y selectedPayment
						reserves.createReserve(
								guests.createGuest(
										txtNombre.getText().toString(),
										txtApellido.getText().toString(),
										sdf.format(txtFechaN.getDate()).toString(),
										selectedNationality,
										txtTelefono.getText().toString()),
								sdf.format(reservas.txtFechaEntrada.getDate()).toString(),
								sdf.format(reservas.txtFechaSalida.getDate()).toString(),
								reservas.txtValor.getText().toString(),
								reservas.selectedPayment);
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					reservas.dispose();
					dispose();
					Exito exito = new Exito();
					exito.setVisible(true);			
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
				}
			}
		});
		btnguardar.setLayout(null);
		btnguardar.setBackground(new Color(12, 138, 199));
		contentPane.add(btnguardar);
		btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel labelGuardar = new JLabel("GUARDAR");
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
		logo.setBounds(194, 39, 104, 107);
		panel.add(logo);
		logo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/Ha-100px.png")));

		final JPanel btnexit = new JPanel();
		btnexit.setBounds(857, 0, 53, 36);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				reservas.dispose();
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
		btnexit.setBackground(Color.white);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setForeground(SystemColor.black);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
	}

	// Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
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