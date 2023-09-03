package com.alura.hotelalura.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

import com.alura.hotelalura.utils.ReservePrice;
import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.beans.PropertyChangeEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class RegistroReserva extends JFrame {

	private JPanel contentPane;
	protected JTextField txtValor;
	protected JDateChooser txtFechaEntrada;
	protected JDateChooser txtFechaSalida;
	protected JComboBox<String> txtFormaPago;
	protected String selectedPayment = "";
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
					RegistroReserva frame = new RegistroReserva();
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
	public RegistroReserva() {
		super("Registro reserva - Hotel Alura");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroReserva.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		panel.setLayout(null);
		contentPane.add(panel);

//		Panel_1
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel_1.setLayout(null);
		panel.add(panel_1);
		
		JLabel logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		logo.setIcon(new ImageIcon(RegistroReserva.class.getResource("/imagenes/Ha-100px.png")));
		panel_1.add(logo);
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 140, 482, 420);
		imagenFondo.setBackground(Color.WHITE);
		imagenFondo.setIcon(new ImageIcon(RegistroReserva.class.getResource("/imagenes/reservas-img-3.png")));
		panel_1.add(imagenFondo);
		
		final JPanel btnexit = new JPanel();
		btnexit.setBounds(429, 0, 53, 36);
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
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
				btnexit.setBackground(new Color(12, 138, 199));
				labelExit.setForeground(Color.white);
			}
		});
		panel_1.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnexit.add(labelExit);
		
//		Header
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		panel.add(header);

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
		labelAtras.setBounds(0, 0, 53, 36);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		btnAtras.add(labelAtras);
		

//		Form
		JLabel lblTitulo = new JLabel("REGISTRO DE RESERVA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(70, 60, 290, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		panel.add(lblTitulo);

		JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(70, 110, 290, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckIn);

		JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(70, 195, 290, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckOut);

		JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(70, 280, 290, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValor);

		JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
		lblFormaPago.setForeground(SystemColor.textInactiveText);
		lblFormaPago.setBounds(70, 365, 290, 14);
		lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFormaPago);

		JLabel lblHuesped = new JLabel("HUÉSPED");
		lblHuesped.setForeground(SystemColor.textInactiveText);
		lblHuesped.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		lblHuesped.setBounds(70, 450, 290, 14);
		panel.add(lblHuesped);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(70, 170, 290, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.textHighlight);
		separator_2.setBounds(70, 255, 290, 2);
		separator_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(SystemColor.textHighlight);
		separator_3.setBounds(70, 340, 290, 2);
		separator_3.setBackground(SystemColor.textHighlight);
		panel.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(SystemColor.textHighlight);
		separator_4.setBackground(SystemColor.textHighlight);
		separator_4.setBounds(70, 425, 290, 2);
		panel.add(separator_4);

//		Campos que guardaremos en la base de datos
		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setBackground(SystemColor.text);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(70, 305, 290, 35);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtValor.setColumns(10);
		panel.add(txtValor);
		
		txtFechaEntrada = new JDateChooser();
		txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaEntrada.getCalendarButton()
				.setIcon(new ImageIcon(RegistroReserva.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtFechaEntrada.setBounds(70, 135, 290, 35);
		txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaEntrada.setBackground(Color.WHITE);
		txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
		txtFechaEntrada.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				checkDates();
			}
		});
		panel.add(txtFechaEntrada);

		txtFechaSalida = new JDateChooser();
		txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaSalida.getCalendarButton()
				.setIcon(new ImageIcon(RegistroReserva.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtFechaSalida.setBounds(70, 220, 290, 35);
		txtFechaSalida.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaSalida.setBackground(Color.WHITE);
		txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtFechaSalida.setDateFormatString("yyyy-MM-dd");
		txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				checkDates();
			}
		});
		panel.add(txtFechaSalida);

		txtFormaPago = new JComboBox<String>();
		txtFormaPago.setBounds(70, 390, 290, 35);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel<>(new String[] {
				"Tarjeta de crédito", "Tarjeta de débito", "Dinero en efectivo", "Bitcoin"
				}));
		txtFormaPago.setSelectedIndex(-1);
		txtFormaPago.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					JComboBox<?> cb = (JComboBox<?>) e.getSource();
					selectedPayment = (String) cb.getSelectedItem();
				}
			}
		});
		panel.add(txtFormaPago);

		JPanel btnGuestStored = new JPanel();
		btnGuestStored.setToolTipText("");
		btnGuestStored.setLayout(null);
		btnGuestStored.setBackground(SystemColor.textHighlight);
		btnGuestStored.setBounds(70, 475, 130, 35);
		btnGuestStored.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnGuestStored.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtFechaEntrada.getDate() != null
						&& txtFechaSalida.getDate() != null
						&& !txtValor.getText().isEmpty()
						&& selectedPayment != "") {
					RegistroHuespedExistente registro = new RegistroHuespedExistente(RegistroReserva.this);
					registro.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos correctamente.");
				}
			}
		});
		panel.add(btnGuestStored);

		JLabel lblGuestStored = new JLabel("EXISTENTE");
		lblGuestStored.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuestStored.setForeground(new Color(255, 255, 255));
		lblGuestStored.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblGuestStored.setBounds(0, 0, 130, 35);
		btnGuestStored.add(lblGuestStored);
		
		JPanel btnGuestNew = new JPanel();
		btnGuestNew.setToolTipText("");
		btnGuestNew.setLayout(null);
		btnGuestNew.setBackground(SystemColor.textHighlight);
		btnGuestNew.setBounds(230, 475, 130, 35);
		btnGuestNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnGuestNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtFechaEntrada.getDate() != null
						&& txtFechaSalida.getDate() != null
						&& !txtValor.getText().isEmpty()
						&& selectedPayment != "") {
					RegistroHuespedNuevo registro = new RegistroHuespedNuevo(RegistroReserva.this);
					registro.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos correctamente.");
				}
			}
		});
		panel.add(btnGuestNew);

		JLabel lblGuestNew = new JLabel("NUEVO");
		lblGuestNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuestNew.setForeground(new Color(255, 255, 255));
		lblGuestNew.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblGuestNew.setBounds(0, 0, 130, 35);
		btnGuestNew.add(lblGuestNew);
	}
	
	private void checkDates() {
		if (txtFechaEntrada.getDate() != null&& txtFechaSalida.getDate() != null) {
			Date dateIn = txtFechaEntrada.getDate();
			Date dateOut = txtFechaSalida.getDate();
			Integer daysDifference = (int) TimeUnit.MILLISECONDS.toDays(dateOut.getTime() - dateIn.getTime());
//			TO DO: Cuando borro una fecha a mano el txtValor debería ser ""
			if (dateOut.after(dateIn)|| dateOut.equals(dateIn)) {
				ReservePrice rp = new ReservePrice(daysDifference);
				txtValor.setText("$ " + rp.getTotalPrice().toString());
			} else {
				txtValor.setText("");
			}
		}
	}

}