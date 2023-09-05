package com.alura.hotelalura.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblExit;
	private JLabel lblRegistro;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		super("Menú principal - Hotel Alura");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(12, 138, 199));
		panelMenu.setBounds(0, 0, 257, 609);
		panelMenu.setLayout(null);
		contentPane.add(panelMenu);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(50, 58, 150, 150);
		lblLogo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/aH-150px.png")));
		panelMenu.add(lblLogo);

		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);

		final JPanel btnRegistro = new JPanel();
		btnRegistro.setBounds(0, 255, 257, 56);
		btnRegistro.setBackground(new Color(12, 138, 199));
		btnRegistro.setLayout(null);
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(118, 187, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(new Color(12, 138, 199));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RegistroReserva reservas = new RegistroReserva();
				reservas.setVisible(true);
				dispose();
			}
		});
		panelMenu.add(btnRegistro);

		lblRegistro = new JLabel("Registro de reservas");
		lblRegistro.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/reservado.png")));
		lblRegistro.setForeground(SystemColor.text);
		lblRegistro.setBounds(25, 11, 205, 34);
		lblRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.add(lblRegistro);

		final JPanel btnBusqueda = new JPanel();
		btnBusqueda.setBounds(0, 312, 257, 56);
		btnBusqueda.setBackground(new Color(12, 138, 199));
		btnBusqueda.setLayout(null);
		btnBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBusqueda.setBackground(new Color(118, 187, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBusqueda.setBackground(new Color(12, 138, 199));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda = new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}
		});
		panelMenu.add(btnBusqueda);

		JLabel lblBusqueda = new JLabel("Búsqueda");
		lblBusqueda.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/pessoas.png")));
		lblBusqueda.setBounds(27, 11, 200, 34);
		lblBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		lblBusqueda.setForeground(Color.WHITE);
		lblBusqueda.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnBusqueda.add(lblBusqueda);

		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(Color.WHITE);
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
		contentPane.add(header);

		final JPanel btnexit = new JPanel();
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(891, 0, 53, 36);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Bienvenida mp = new Bienvenida();
				mp.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				lblExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(Color.white);
				lblExit.setForeground(Color.black);
			}
		});
		header.add(btnexit);

		lblExit = new JLabel("X");
		lblExit.setBounds(0, 0, 53, 36);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnexit.add(lblExit);

		JPanel panelFecha = new JPanel();
		panelFecha.setBackground(new Color(118, 187, 223));
		panelFecha.setBounds(256, 84, 688, 121);
		panelFecha.setLayout(null);
		contentPane.add(panelFecha);

		JLabel lblTitulo = new JLabel("Sistema de reservas Hotel Alura");
		lblTitulo.setBounds(180, 11, 356, 42);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Roboto", Font.PLAIN, 24));
		panelFecha.add(lblTitulo);

		JLabel labelFecha = new JLabel("New label");
		Date fechaActual = new Date(); // fecha y hora actual
		String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual); // formatear la fecha en una cadena
		labelFecha.setBounds(35, 64, 294, 36);
		labelFecha.setForeground(Color.WHITE);
		labelFecha.setFont(new Font("Roboto", Font.PLAIN, 33));
		labelFecha.setText("Hoy es " + fecha);
		panelFecha.add(labelFecha);

		JLabel lblSubTitulo = new JLabel("Bienvenido");
		lblSubTitulo.setFont(new Font("Roboto", Font.BOLD, 24));
		lblSubTitulo.setBounds(302, 234, 147, 46);
		contentPane.add(lblSubTitulo);

		String txtDescripcion_1 = "<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima y fácil<br>el flujo de reservas y de huéspedes del hotel</body></html>";
		JLabel lblDescripcion_1 = new JLabel(txtDescripcion_1);
		lblDescripcion_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblDescripcion_1.setBounds(312, 291, 598, 66);
		contentPane.add(lblDescripcion_1);

		String txtDescripcion_2 = "<html><body>Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas como lo son:</body></html>";
		JLabel lblDescripcion_2 = new JLabel(txtDescripcion_2);
		lblDescripcion_2.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblDescripcion_2.setBounds(311, 345, 569, 88);
		contentPane.add(lblDescripcion_2);

		JLabel lblList_1 = new JLabel("- Registro de Reservas y Huéspedes");
		lblList_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblList_1.setBounds(312, 444, 295, 27);
		contentPane.add(lblList_1);

		JLabel lblList_2 = new JLabel("- Edición de Reservas y Huéspedes existentes");
		lblList_2.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblList_2.setBounds(312, 482, 355, 27);
		contentPane.add(lblList_2);

		JLabel lblList_3 = new JLabel("- Eliminar todo tipo de registros");
		lblList_3.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblList_3.setBounds(312, 520, 295, 27);
		contentPane.add(lblList_3);
	}

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