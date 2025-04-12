package Ventanas;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Clases.Contacto;
import Conexion.Conexion;
import Consultas.ConsultasContactos;

public class VentanaContactos extends JFrame {

	private JPanel contentPane;
	public static JLabel lblVentana;
	public JLabel lblId;
	public JTextField txtNombre;
	public JTextField txtTelefono;
	public JTextField txtCorreo;
	public JTextField txtFotografia;
	public JLabel lblFotografia;

	public JLabel lblFecha;
	public JLabel lblHora;

	private JLabel lblIconoFecha;
	private JLabel lblIconoHora;
	private JLabel lblContacto;
	private JLabel lblLogo;
	private JLabel lblAcercaDe;

	public static String totalDatos;
	public JTable tabla;
	public JScrollPane barra;
	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;
	public JTextField txtBuscar;
	public JButton btnGuardar, btnActualizar, btnEliminar, btnEditar, btnLimpiar;
	final ImageIcon foto = new ImageIcon(getClass().getResource("/Recursos/perfil.png"));

	public VentanaContactos() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 830);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Ventana - Agenda de contactos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Recursos/contactos.png")));
		final ImageIcon logo1 = new ImageIcon(getClass().getResource("/Recursos/fecha.png"));
		final ImageIcon logo2 = new ImageIcon(getClass().getResource("/Recursos/hora.png"));
		final ImageIcon logo = new ImageIcon(getClass().getResource("/Recursos/contactos.png"));
		final ImageIcon logo4 = new ImageIcon(getClass().getResource("/Recursos/foto.png"));
		final ImageIcon logo5 = new ImageIcon(getClass().getResource("/Recursos/recargar.png"));
		final ImageIcon logo7 = new ImageIcon(getClass().getResource("/Recursos/acercade.png"));
		
		final ImageIcon guardar = new ImageIcon(getClass().getResource("/Recursos/guardar.png"));
		final ImageIcon actualizar = new ImageIcon(getClass().getResource("/Recursos/actualizar.png"));
		final ImageIcon eliminar = new ImageIcon(getClass().getResource("/Recursos/eliminar.png"));
		final ImageIcon ver = new ImageIcon(getClass().getResource("/Recursos/mostrar.png"));
		final ImageIcon limpiar = new ImageIcon(getClass().getResource("/Recursos/limpiar.png"));
		final ImageIcon editar = new ImageIcon(getClass().getResource("/Recursos/editar.png"));
		final ImageIcon imprimir = new ImageIcon(getClass().getResource("/Recursos/imprimir.png"));
		final ImageIcon adjuntar = new ImageIcon(getClass().getResource("/Recursos/adjuntar.png"));

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
				close();
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(10, 11, 914, 762);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblIconoFecha = new JLabel("");
		lblIconoFecha.setBounds(170, 53, 33, 33);
		panel_1.add(lblIconoFecha);
		final ImageIcon icono = new ImageIcon(logo1.getImage().getScaledInstance(lblIconoFecha.getWidth(),
				lblIconoFecha.getHeight(), Image.SCALE_DEFAULT));
		lblIconoFecha.setIcon(icono);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(10, 97, 392, 655);
		panel_1.add(panel_2_1_1);
		panel_2_1_1.setLayout(null);

		JLabel lblNombre = new JLabel("Télefono");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblNombre.setBounds(10, 119, 205, 27);
		panel_2_1_1.add(lblNombre);

		txtTelefono = new JTextField();
		txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		txtTelefono.setToolTipText("Escriba el número del contacto.");
		txtTelefono.setBounds(10, 146, 372, 35);
		panel_2_1_1.add(txtTelefono);
		txtTelefono.setColumns(10);

		btnGuardar = new JButton("");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(0, 128, 0));
		btnGuardar.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnGuardar.setBounds(332, 595, 50, 50);
		panel_2_1_1.add(btnGuardar);
		final ImageIcon iconoGuardar = new ImageIcon(guardar.getImage().getScaledInstance(btnGuardar.getWidth(),
				btnGuardar.getHeight(), Image.SCALE_DEFAULT));
		btnGuardar.setIcon(iconoGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtNombre.getText().isEmpty() && txtTelefono.getText().isEmpty() && txtCorreo.getText().isEmpty()
						&& txtFotografia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Porfavor llene los campos requeridos para guardar el registro!");
				} else {
					Contacto clase = new Contacto();
					ConsultasContactos consulta = new ConsultasContactos();
					clase.setName(txtNombre.getText().toString());
					clase.setPhone(txtTelefono.getText().toString());
					clase.setEmail(txtCorreo.getText().toString());
					clase.setImage(txtFotografia.getText().toString());

					if (consulta.insertar(clase)) {
						JOptionPane.showMessageDialog(null, "Guardado correctamente");
						limpiar();
						construirTabla();
						obtenerUltimoId();
						btnGuardar.setEnabled(true);
						btnActualizar.setEnabled(false);
						btnEliminar.setEnabled(true);
						btnLimpiar.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
						limpiar();
						construirTabla();
						obtenerUltimoId();
						btnGuardar.setEnabled(true);
						btnActualizar.setEnabled(false);
						btnEliminar.setEnabled(true);
						btnLimpiar.setEnabled(true);

					}
				}
			}

		});

		btnActualizar = new JButton("");
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setBackground(new Color(0, 128, 128));
		btnActualizar.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnActualizar.setBounds(272, 595, 50, 50);
		panel_2_1_1.add(btnActualizar);
		final ImageIcon iconoActualizar = new ImageIcon(actualizar.getImage().getScaledInstance(btnActualizar.getWidth(),
				btnActualizar.getHeight(), Image.SCALE_DEFAULT));
		btnActualizar.setIcon(iconoActualizar);
		btnActualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtNombre.getText().isEmpty() && txtTelefono.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Porfavor llene los campos requeridos para actualizar el registro!");
				} else {
					Contacto clase = new Contacto();
					ConsultasContactos consulta = new ConsultasContactos();
					clase.setName(txtNombre.getText().toString());
					clase.setPhone(txtTelefono.getText().toString());
					clase.setEmail(txtCorreo.getText().toString());
					clase.setImage(txtFotografia.getText().toString());
					clase.setId(Integer.parseInt(lblId.getText().toString()));

					if (consulta.actualizar(clase)) {
						JOptionPane.showMessageDialog(null, "Actualizado correctamente");
						limpiar();
						construirTabla();
						obtenerUltimoId();
						btnGuardar.setEnabled(true);
						btnActualizar.setEnabled(false);
						btnEliminar.setEnabled(true);
						btnLimpiar.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
						limpiar();
						construirTabla();
						obtenerUltimoId();
						btnGuardar.setEnabled(true);
						btnActualizar.setEnabled(false);
						btnEliminar.setEnabled(true);
						btnLimpiar.setEnabled(true);

					}
				}
			}

		});

		JLabel lblN = new JLabel("N°:");
		lblN.setForeground(Color.BLACK);
		lblN.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblN.setBounds(288, 11, 38, 38);
		panel_2_1_1.add(lblN);

		lblId = new JLabel("");
		lblId.setForeground(new Color(0, 128, 0));
		lblId.setBounds(336, 11, 46, 38);
		panel_2_1_1.add(lblId);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Segoe UI Black", Font.BOLD, 25));

		JLabel lblCodigoDelRol = new JLabel("Nombre");
		lblCodigoDelRol.setForeground(Color.BLACK);
		lblCodigoDelRol.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblCodigoDelRol.setBounds(10, 59, 205, 27);
		panel_2_1_1.add(lblCodigoDelRol);

		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setToolTipText("Escriba el nombre del contacto.");
		txtNombre.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 86, 372, 35);
		panel_2_1_1.add(txtNombre);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.BLACK);
		lblCorreo.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblCorreo.setBounds(10, 179, 205, 27);
		panel_2_1_1.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setToolTipText("Escriba el email del contacto.");
		txtCorreo.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(10, 206, 372, 35);
		panel_2_1_1.add(txtCorreo);

		JLabel lblFotog = new JLabel("Fotografía");
		lblFotog.setForeground(Color.BLACK);
		lblFotog.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblFotog.setBounds(10, 242, 372, 35);
		panel_2_1_1.add(lblFotog);

		lblFotografia = new JLabel("");
		lblFotografia.setBounds(42, 10, 285, 285);
		final ImageIcon icono8 = new ImageIcon(foto.getImage().getScaledInstance(lblFotografia.getWidth(),
				lblFotografia.getHeight(), Image.SCALE_DEFAULT));
		lblFotografia.setIcon(icono8);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		panel_3.setBounds(10, 279, 372, 306);
		panel_2_1_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.add(lblFotografia);
		
				JButton btnAdjuntar = new JButton("");
				btnAdjuntar.setBounds(327, 10, 35, 35);
				panel_3.add(btnAdjuntar);
				btnAdjuntar.setToolTipText("Seleccione la fotografía del contacto.");
				btnAdjuntar.setForeground(Color.BLACK);
				btnAdjuntar.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
				btnAdjuntar.setBackground(Color.LIGHT_GRAY);
				final ImageIcon iconoAdjuntar = new ImageIcon(adjuntar.getImage().getScaledInstance(btnAdjuntar.getWidth(),
						btnAdjuntar.getHeight(), Image.SCALE_DEFAULT));
				btnAdjuntar.setIcon(iconoAdjuntar);
				btnAdjuntar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						selecionarLogo();
					}
				});

		txtFotografia = new JTextField();
		txtFotografia.setEditable(false);
		txtFotografia.setBounds(129, 251, 253, 20);
		panel_2_1_1.add(txtFotografia);
		txtFotografia.setToolTipText("");
		txtFotografia.setFont(new Font("Segoe UI Light", Font.PLAIN, 10));
		txtFotografia.setColumns(10);
		txtFotografia.setVisible(false);

		lblContacto = new JLabel("REGISTRO DE CONTACTO");
		lblContacto.setHorizontalAlignment(SwingConstants.LEFT);
		lblContacto.setForeground(Color.BLACK);
		lblContacto.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblContacto.setBounds(10, 11, 372, 38);
		panel_2_1_1.add(lblContacto);
		
				btnLimpiar = new JButton("");
				btnLimpiar.setBounds(10, 595, 50, 50);
				panel_2_1_1.add(btnLimpiar);
				btnLimpiar.setForeground(Color.BLACK);
				btnLimpiar.setBackground(Color.WHITE);
				btnLimpiar.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
				final ImageIcon iconoLimpiar = new ImageIcon(limpiar.getImage().getScaledInstance(btnLimpiar.getWidth(),
						btnLimpiar.getHeight(), Image.SCALE_DEFAULT));
				btnLimpiar.setIcon(iconoLimpiar);
				
						btnLimpiar.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								limpiar();
								construirTabla();
								obtenerUltimoId();
							}
						});

		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1.setBounds(412, 97, 492, 655);
		panel_1.add(panel_2_1_1_1);
		panel_2_1_1_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(new Color(0, 139, 139), 2));
		panel_2.setBounds(10, 11, 472, 634);
		panel_2_1_1_1.add(panel_2);
		panel_2.setLayout(null);

		barra = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barra.setBounds(10, 101, 452, 523);
		panel_2.add(barra);
		tabla = new JTable();
		tabla.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		barra.setViewportView(tabla);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setForeground(Color.BLACK);
		lblBuscar.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblBuscar.setBounds(10, 56, 97, 35);
		panel_2.add(lblBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setToolTipText("");
		txtBuscar.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(89, 56, 373, 35);
		panel_2.add(txtBuscar);

		JLabel lblRegistros = new JLabel("LISTA DE CONTACTOS");
		lblRegistros.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistros.setBounds(10, 12, 282, 35);
		panel_2.add(lblRegistros);
		lblRegistros.setForeground(new Color(0, 0, 0));
		lblRegistros.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));

		JButton lblRecargar = new JButton("");
		lblRecargar.setBackground(Color.WHITE);
		lblRecargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				obtenerUltimoId();
				construirTabla();
			}
		});
		lblRecargar.setBounds(427, 12, 35, 35);
		panel_2.add(lblRecargar);
		final ImageIcon icono5 = new ImageIcon(logo5.getImage().getScaledInstance(lblRecargar.getWidth(),
				lblRecargar.getHeight(), Image.SCALE_DEFAULT));
		lblRecargar.setIcon(icono5);

		JButton btnImprimir = new JButton("");
		btnImprimir.setBounds(337, 10, 35, 35);
		panel_2.add(btnImprimir);
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnImprimir.setBackground(Color.WHITE);
		final ImageIcon iconoImprimir = new ImageIcon(imprimir.getImage().getScaledInstance(btnImprimir.getWidth(),
				btnImprimir.getHeight(), Image.SCALE_DEFAULT));
		btnImprimir.setIcon(iconoImprimir);

		btnEliminar = new JButton("");
		btnEliminar.setToolTipText("Eliminar contacto seleccionado.");
		btnEliminar.setBounds(382, 10, 35, 35);
		panel_2.add(btnEliminar);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnEliminar.setBackground(Color.WHITE);
		final ImageIcon iconoEliminar = new ImageIcon(eliminar.getImage().getScaledInstance(btnEliminar.getWidth(),
				btnEliminar.getHeight(), Image.SCALE_DEFAULT));
		btnEliminar.setIcon(iconoEliminar);

		btnEditar = new JButton("");
		btnEditar.setBounds(292, 10, 35, 35);
		panel_2.add(btnEditar);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnEditar.setBackground(Color.WHITE);
		final ImageIcon iconoEditar = new ImageIcon(actualizar.getImage().getScaledInstance(btnEditar.getWidth(),
				btnEditar.getHeight(), Image.SCALE_DEFAULT));
		btnEditar.setIcon(iconoEditar);

		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaseleccionada;
				try {
					filaseleccionada = tabla.getSelectedRow();
					if (filaseleccionada == -1) {
						JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					} else {
						String id = tabla.getValueAt(filaseleccionada, 0).toString();
						String name = tabla.getValueAt(filaseleccionada, 1).toString();
						String phone = tabla.getValueAt(filaseleccionada, 2).toString();
						String email = tabla.getValueAt(filaseleccionada, 3).toString();
						String image = tabla.getValueAt(filaseleccionada, 4).toString();

						lblId.setText(id);
						txtNombre.setText(name);
						txtTelefono.setText(phone);
						txtCorreo.setText(email);
						txtFotografia.setText(image);

						File ruta = new File(image);

						Image foto = getToolkit().getImage(txtFotografia.getText());
						foto = foto.getScaledInstance(lblFotografia.getHeight(), lblFotografia.getWidth(),
								Image.SCALE_DEFAULT);
						lblFotografia.setIcon(new ImageIcon(foto));

						btnGuardar.setEnabled(false);
						btnActualizar.setEnabled(true);
						btnEliminar.setEnabled(false);
						btnEditar.setEnabled(true);
						btnLimpiar.setEnabled(false);

					}

				} catch (HeadlessException ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInt�ntelo nuevamente",
							" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement ps = null;
				int filaseleccionada;
				try {
					filaseleccionada = tabla.getSelectedRow();
					if (filaseleccionada == -1) {
						JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					} else {
						Conexion objCon = new Conexion();
						Connection conn = objCon.conectar();
						int Fila = tabla.getSelectedRow();
						String codigo = tabla.getValueAt(Fila, 0).toString();
						ps = conn.prepareStatement("DELETE FROM contacts WHERE id=?");
						ps.setString(1, codigo);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
						limpiar();
					}

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error al Eliminar");
					System.out.println(ex.toString());
				}
			}
		});
		btnImprimir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				obtenerTotalDatosReporte();
				if (totalDatos == null) {
					JOptionPane.showMessageDialog(null, "No hay registros disponibles para imprimir un reporte");
				} else {
					String ampm;
					Calendar cal = new GregorianCalendar();
					ampm = cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
					String fecha = getFechaYHora() + ampm;
					int total = Integer.valueOf(totalDatos);
					String i = null;
					if (total <= 46) {
						i = "1";
					} else {
						if (total > 46 && total <= 92) {
							i = "2";
						} else {
							if (total > 92 && total <= 138) {
								i = "3";
							} else {
								if (total > 138 && total <= 184) {
									i = "4";
								} else {
									if (total > 184 && total <= 230) {
										i = "5";
									} else {
										if (total > 230 && total <= 276) {
											i = "6";
										} else {
											if (total > 276 && total <= 322) {
												i = "7";
											} else {
												if (total > 322 && total <= 368) {
													i = "8";
												} else {
													if (total > 368 && total <= 414) {
														i = "9";
													} else {
														if (total > 414 && total <= 460) {
															i = "10";
														} else {
															i = "Mas de 10 paginas";

														}

													}

												}
											}
										}
									}
								}
							}
						}
					}

					String encabezado = "REPORTE DE CONTACTOS REGISTRADOS";

					utilJTablePrint(tabla, encabezado,
							"Pagina {0} de " + i + "          AGENDA DE CONTACTOS          " + fecha, true);

				}
			}
		});

		lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblFecha.setBounds(87, 53, 454, 33);
		panel_1.add(lblFecha);
		lblFecha.setText(getFecha());

		lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.LEFT);
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblHora.setBounds(594, 53, 266, 33);
		panel_1.add(lblHora);

		lblVentana = new JLabel("AGENDA DE CONTACTOS");
		lblVentana.setBounds(10, 8, 894, 38);
		panel_1.add(lblVentana);
		lblVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentana.setForeground(Color.WHITE);
		lblVentana.setFont(new Font("Arial Black", Font.BOLD, 30));

		lblIconoHora = new JLabel("");
		lblIconoHora.setBounds(551, 53, 33, 33);
		panel_1.add(lblIconoHora);
		final ImageIcon icono2 = new ImageIcon(logo2.getImage().getScaledInstance(lblIconoHora.getWidth(),
				lblIconoHora.getHeight(), Image.SCALE_DEFAULT));
		lblIconoHora.setIcon(icono2);

		lblLogo = new JLabel("");
		lblLogo.setBounds(10, 11, 78, 75);
		panel_1.add(lblLogo);
		final ImageIcon icono9 = new ImageIcon(
				logo.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(icono9);

		lblAcercaDe = new JLabel("");
		lblAcercaDe.setBounds(826, 11, 78, 75);
		panel_1.add(lblAcercaDe);
		final ImageIcon icono7 = new ImageIcon(logo7.getImage().getScaledInstance(lblAcercaDe.getWidth(),
				lblAcercaDe.getHeight(), Image.SCALE_DEFAULT));
		lblAcercaDe.setIcon(icono7);
		lblAcercaDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AcercaDe ad = new AcercaDe();
				ad.setLocationRelativeTo(null);
				ad.setVisible(true);
				ad.btnWhatsApp.requestFocus();
				dispose();
			}
		});
		InputMap map6 = txtBuscar.getInputMap(JComponent.WHEN_FOCUSED);
		map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBuscar.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tabla.getModel());
				tabla.setRowSorter(trsfiltroCodigo);

				if (txtBuscar.getText().length() == 25) {
					ke.consume();
				}

				if (txtBuscar.getText().toString().equals(" ")) {
					JOptionPane.showMessageDialog(null, "No esta permitido escribir espacios vacios!");
					txtBuscar.setText("");
				}
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBuscar.getText().toString());
				txtBuscar.setText(cadena);
				repaint();
				filtro();
			}
		});

	}

	public void construirTabla() {
		String titulos[] = { "N°", "Nombre", "Télefono", "Correo", "Ruta Fotografía" };
		String informacion[][] = obtenerMatriz();
		tabla = new JTable(informacion, titulos);
		barra.setViewportView(tabla);
		for (int c = 0; c < tabla.getColumnCount(); c++) {
			Class<?> col_class = tabla.getColumnClass(c);
			tabla.setDefaultEditor(col_class, null);
			tabla.getTableHeader().setReorderingAllowed(false);
			tabla.getColumnModel().getColumn(0).setPreferredWidth(20);

		}
	}

	public static ArrayList<Contacto> buscarUsuariosConMatriz() {
		Conexion conex = new Conexion();
		ArrayList<Contacto> miLista = new ArrayList<>();
		Contacto roles;
		try {
			Statement estatuto = conex.conectar().createStatement();
			ResultSet rs = estatuto.executeQuery("select * from contacts");

			while (rs.next()) {
				roles = new Contacto();
				roles.setId(Integer.parseInt(rs.getString("id")));
				roles.setName(rs.getString("name"));
				roles.setPhone(rs.getString("phone"));
				roles.setEmail(rs.getString("email"));
				roles.setImage(rs.getString("image"));
				miLista.add(roles);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}
		return miLista;
	}

	public static String[][] obtenerMatriz() {
		ArrayList<Contacto> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][5];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId() + "";
			matrizInfo[i][1] = miLista.get(i).getName() + "";
			matrizInfo[i][2] = miLista.get(i).getPhone() + "";
			matrizInfo[i][3] = miLista.get(i).getEmail() + "";
			matrizInfo[i][4] = miLista.get(i).getImage() + "";

		}
		return matrizInfo;
	}

	public void filtro() {
		filtroCodigo = txtBuscar.getText().toString();
		trsfiltroCodigo.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscar.getText().toString(), 1, 2));
	}

	public void utilJTablePrint(JTable jTable, String header, String footer, boolean showPrintDialog) {
		boolean fitWidth = true;
		boolean interactive = true;
		JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
		try {
			boolean complete = jTable.print(mode, new MessageFormat(header), new MessageFormat(footer), showPrintDialog,
					null, interactive);
			if (complete) {
				JOptionPane.showMessageDialog(jTable, "Print complete (Impresión completa)",
						"Print result (Resultado de la Impresión)", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(jTable, "Print canceled (Impresión cancelada)",
						"Print result (Resultado de la Impresión)", JOptionPane.WARNING_MESSAGE);
			}
		} catch (PrinterException pe) {
			JOptionPane.showMessageDialog(jTable, "Print fail (Fallo de Impresión): " + pe.getMessage(),
					"Print result (Resultado de la Impresión)", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		Conexion objCon = new Conexion();
		Connection conn = objCon.conectar();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM contacts ORDER BY id DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id");
				valor = Integer.parseInt(ultimoValor);
				valor = valor + 1;
				id = String.valueOf(valor);
			}
			lblId.setText(id);

			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void obtenerTotalDatosReporte() {
		Conexion objCon = new Conexion();
		Connection conn = objCon.conectar();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM contacts ORDER BY id DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id");
			}
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getFechaYHora() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat df = new SimpleDateFormat("dd'/'MMMMM'/'yyyy HH:mm:ss ");
		date = cal.getTime();
		return df.format(date);
	}

	Timer time = new Timer();
	public TimerTask tarea = new TimerTask() {
		@Override
		public void run() {
			Calendar calendario = new GregorianCalendar();
			Date fechaHoraActual = new Date();
			calendario.setTime(fechaHoraActual);
			String horas;
			String minutos;
			String segundos;
			String ampm;
			Thread hilo = null;
			Thread hilo2;
			hilo2 = Thread.currentThread();
			hilo = new Thread();
			hilo.start();
			ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
			if (ampm.equals("PM")) {
				int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
				horas = h > 9 ? "" + h : "0" + h;
			} else {
				horas = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
						: "0" + calendario.get(Calendar.HOUR_OF_DAY);
			}
			minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
					: "0" + calendario.get(Calendar.MINUTE);
			segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
					: "0" + calendario.get(Calendar.SECOND);

			lblHora.setText(horas + ":" + minutos + ":" + segundos + " " + ampm);
		}
	};

	public static String getFecha() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat df = new SimpleDateFormat("EEEEEEEEE dd 'de' MMMMM 'del' yyyy");
		date = cal.getTime();
		return df.format(date);
	}

	private void close() {
		if (JOptionPane.showConfirmDialog(rootPane, "¿Deseas salir del programa?", "Salir del sistema",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private void limpiar() {
		lblId.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtFotografia.setText("");
		final ImageIcon icono8 = new ImageIcon(foto.getImage().getScaledInstance(lblFotografia.getWidth(),
				lblFotografia.getHeight(), Image.SCALE_DEFAULT));
		lblFotografia.setIcon(icono8);
		obtenerUltimoId();
		construirTabla();
	}

	public void selecionarLogo() {
		JFileChooser archivo = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg",
				"jpeg");
		archivo.addChoosableFileFilter(filtro);
		archivo.setDialogTitle("Abrir Archivo");
		File ruta = new File("\\\\" + Conexion.urlGlobal + "\\C:\\");
		archivo.setCurrentDirectory(ruta);
		int ventana = archivo.showOpenDialog(null);
		if (ventana == JFileChooser.APPROVE_OPTION) {
			File file = archivo.getSelectedFile();
			txtFotografia.setText(String.valueOf(file));
			Image foto = getToolkit().getImage(txtFotografia.getText());
			foto = foto.getScaledInstance(lblFotografia.getHeight(), lblFotografia.getWidth(), Image.SCALE_DEFAULT);
			lblFotografia.setIcon(new ImageIcon(foto));
		}
	}
}
