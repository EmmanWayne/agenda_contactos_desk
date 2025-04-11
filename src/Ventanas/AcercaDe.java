package Ventanas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AcercaDe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public float n1;
	public float n2;
	public String num1;
	public String num2;
	public String operador;

	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JTextArea txt4;
	public JButton btnWhatsApp;

	public AcercaDe() {
		setResizable(false);
		setTitle("Ventana - Acerca De.");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AcercaDe.class.getResource("/Recursos/contactos.png")));
		final ImageIcon logo = new ImageIcon(getClass().getResource("/Recursos/contactos.png"));
		final ImageIcon logoW = new ImageIcon(getClass().getResource("/Recursos/whatsapp.png"));
		setBounds(100, 100, 496, 737);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
				close();
			}

		});

		lbl1 = new JLabel("ACERCA DE.");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbl1.setBounds(8, 75, 462, 41);
		contentPane.add(lbl1);

		lbl3 = new JLabel("by Lic. Emmanuel Díaz");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Arial Black", Font.BOLD, 18));
		lbl3.setBounds(8, 153, 462, 41);
		contentPane.add(lbl3);

		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setBounds(74, 216, 212, 218);
		contentPane.add(lblLogo_1);
		final ImageIcon icono2 = new ImageIcon(
				logo.getImage().getScaledInstance(lblLogo_1.getWidth(), lblLogo_1.getHeight(), Image.SCALE_DEFAULT));
		lblLogo_1.setIcon(icono2);

		txt4 = new JTextArea();
		txt4.setText(
				"    Todos los derechos reservados a:\r\n           Programador y Diseñador:\r\n              Lic. Cristian Emmanuel \r\n                    Díaz Rodríguez\r\n_________________________________________\r\n Contacto: krizemandiaz11@gmail.com\r\n Teléfono: +504 8883-9089 \r\n El Paraíso, El Paraíso - Honduras 2020.\r\n");
		txt4.setFont(new Font("Arial", Font.PLAIN, 18));
		txt4.setEditable(false);
		txt4.setBounds(74, 461, 336, 203);
		contentPane.add(txt4);

		lbl2 = new JLabel("AGENDA DE CONTACTOS");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Arial Black", Font.BOLD, 28));
		lbl2.setBounds(8, 112, 462, 41);
		contentPane.add(lbl2);

		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaContactos contactos = new VentanaContactos();
				contactos.setVisible(true);
				contactos.setLocationRelativeTo(null);
				contactos.txtNombre.requestFocus();
				Timer time = new Timer();
				time.schedule(contactos.tarea, 0, 1000);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnNewButton.setBounds(159, 37, 155, 34);
		contentPane.add(btnNewButton);

		btnWhatsApp = new JButton("");
		btnWhatsApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToURL("https://wa.me/50488839089?text=%C2%A1Hola%20mucho%20gusto!%20estoy%20interesad@%20en%20tu%20trabajo,%20%C2%BFpodemos%20hablar%20un%20poco?");
			}
		});
		btnWhatsApp.setFont(new Font("Franklin Gothic Heavy", Font.BOLD | Font.ITALIC, 25));
		btnWhatsApp.setBackground(Color.WHITE);
		btnWhatsApp.setBounds(298, 278, 90, 90);
		contentPane.add(btnWhatsApp);
		final ImageIcon icono11 = new ImageIcon(logoW.getImage().getScaledInstance(btnWhatsApp.getWidth(),
				btnWhatsApp.getHeight(), Image.SCALE_DEFAULT));
		btnWhatsApp.setIcon(icono11);

	}

	public void goToURL(String URL) {
		if (java.awt.Desktop.isDesktopSupported()) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
				try {
					java.net.URI uri = new java.net.URI(URL);
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex) {
					Logger.getLogger(AcercaDe.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	private void close() {
		if (JOptionPane.showConfirmDialog(rootPane, "¿Desea cerrar la calculadora?", "",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}

}
