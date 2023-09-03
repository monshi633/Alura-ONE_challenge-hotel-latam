package com.alura.hotelalura.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exito extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Integer nReserve = 0;
			Exito dialog = new Exito(nReserve);
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 *
	 * @param nReserve
	 */
	public Exito(Integer nReserve) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Exito.class.getResource("/imagenes/aH-40px.png")));
		setBounds(100, 100, 400, 230);
		setLocationRelativeTo(null);
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(Exito.class.getResource("/imagenes/Ha-100px.png")));
		lblImg.setBounds(139, 4, 100, 100);
		contentPanel.add(lblImg);

		JLabel lblLine_1 = new JLabel("Datos guardados satisfactoriamente");
		lblLine_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLine_1.setForeground(new Color(12, 138, 199));
		lblLine_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblLine_1.setBounds(0, 108, 378, 21);
		contentPanel.add(lblLine_1);

		JLabel lblLine_2 = new JLabel("Número de reserva: " + nReserve);
		lblLine_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLine_2.setForeground(new Color(12, 138, 199));
		lblLine_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblLine_2.setBounds(0, 133, 378, 21);
		contentPanel.add(lblLine_2);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();// sirve para cerrar la ventana actual
				MenuPrincipal usuario = new MenuPrincipal();
				usuario.setVisible(true);
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	}
}
