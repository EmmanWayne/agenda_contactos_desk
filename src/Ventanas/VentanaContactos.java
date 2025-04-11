package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaContactos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaContactos frame = new VentanaContactos();
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
	public VentanaContactos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1185, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1150, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AGENDA DE CONTACTOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 1130, 36);
		panel.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(590, 76, 570, 56);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(10, 10, 548, 36);
		panel_1_1.add(lblFecha);
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Arial Black", Font.BOLD, 30));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(10, 142, 1150, 172);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(10, 10, 319, 36);
		panel_1_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Télefono:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(10, 56, 319, 36);
		panel_1_2.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Correo:");
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_1_1_1_2.setBounds(10, 102, 319, 36);
		panel_1_2.add(lblNewLabel_1_1_1_2);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBounds(10, 531, 1150, 222);
		contentPane.add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnNewButton.setBounds(10, 465, 280, 56);
		contentPane.add(btnNewButton);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnActualizar.setBounds(300, 465, 280, 56);
		contentPane.add(btnActualizar);
		
		JButton btnVer = new JButton("Ver");
		btnVer.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnVer.setBounds(590, 465, 280, 56);
		contentPane.add(btnVer);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnEliminar.setBounds(880, 465, 280, 56);
		contentPane.add(btnEliminar);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBounds(10, 76, 570, 56);
		contentPane.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("ACERCA DE.");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(12, 10, 548, 36);
		panel_1_1_1.add(lblNewLabel_1_1);
	}
}
