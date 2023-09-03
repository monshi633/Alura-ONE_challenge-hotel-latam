package com.alura.hotelalura.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.alura.hotelalura.utils.UserCredentials;

public class Login extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	int xMouse, yMouse;
	private JLabel labelExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		super("Login - Hotel Alura");
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 527);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 788, 527);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(12, 138, 199));
		panel_1.setBounds(484, 0, 304, 527);
		panel_1.setLayout(null);
		panel.add(panel_1);

		final JPanel btnexit = new JPanel();
		btnexit.setBounds(251, 0, 53, 36);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setLayout(null);
		btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Confirmacion confirmacion = new Confirmacion();
				confirmacion.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(new Color(12, 138, 199));
				labelExit.setForeground(Color.white);
			}
		});
		panel_1.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		btnexit.add(labelExit);

		JLabel imgHotel = new JLabel("");
		imgHotel.setBounds(0, 0, 304, 538);
		imgHotel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/img-hotel-login-.png")));
		panel_1.add(imgHotel);

		JPanel header = new JPanel();
		header.setBackground(SystemColor.window);
		header.setBounds(0, 0, 788, 36);
		header.setLayout(null);
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
		panel.add(header);

		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/imagenes/lOGO-50PX.png")));
		lblLogo.setBounds(65, 65, 48, 59);
		panel.add(lblLogo);

		JLabel labelTitulo = new JLabel("INICIAR SESIÓN");
		labelTitulo.setForeground(SystemColor.textHighlight);
		labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		labelTitulo.setBounds(65, 149, 202, 26);
		panel.add(labelTitulo);

		JLabel LabelUsuario = new JLabel("USUARIO");
		LabelUsuario.setForeground(SystemColor.textInactiveText);
		LabelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		LabelUsuario.setBounds(65, 219, 107, 26);
		panel.add(LabelUsuario);

		JLabel lblContrasena = new JLabel("CONTRASEÑA");
		lblContrasena.setForeground(SystemColor.textInactiveText);
		lblContrasena.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblContrasena.setBounds(65, 316, 140, 26);
		panel.add(lblContrasena);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 120, 215));
		separator_1.setBounds(65, 292, 324, 2);
		panel.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(SystemColor.textHighlight);
		separator_2.setBounds(65, 393, 324, 2);
		panel.add(separator_2);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUsuario.setText("Ingrese su nombre de usuario");
		txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(65, 256, 324, 32);
		txtUsuario.setColumns(10);
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
					txtUsuario.setText("");
					txtUsuario.setForeground(Color.black);
				}
				if (String.valueOf(txtContrasena.getPassword()).isEmpty()) {
					txtContrasena.setText("********");
					txtContrasena.setForeground(Color.gray);
				}
			}
		});
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		panel.add(txtUsuario);

		txtContrasena = new JPasswordField();
		txtContrasena.setColumns(10);
		txtContrasena.setText("********");
		txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		txtContrasena.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtContrasena.setBounds(65, 353, 324, 32);
		txtContrasena.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(txtContrasena.getPassword()).equals("********")) {
					txtContrasena.setText("");
					txtContrasena.setForeground(Color.black);
				}
				if (txtUsuario.getText().isEmpty()) {
					txtUsuario.setText("Ingrese su nombre de usuario");
					txtUsuario.setForeground(Color.gray);
				}
			}
		});
		txtContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		panel.add(txtContrasena);

		final JPanel btnLogin = new JPanel();
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setBounds(65, 431, 122, 44);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 156, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(SystemColor.textHighlight);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				login();
			}
		});
		panel.add(btnLogin);

		JLabel lblNewLabel = new JLabel("ENTRAR");
		lblNewLabel.setBounds(0, 0, 122, 44);
		lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnLogin.add(lblNewLabel);
	}

	private void login() {
		UserCredentials credentials = new UserCredentials();
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		String inputPassword = new String(txtContrasena.getPassword());

		if (txtUsuario.getText().equals(username) && inputPassword.equals(password)) {
			MenuPrincipal menu = new MenuPrincipal();
			menu.setVisible(true);
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Usuario o Contraseña no válidos");
		}

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