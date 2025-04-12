package Sistema;

import java.util.Timer;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import Ventanas.VentanaContactos;

public class IniciarSistema {

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		try {

			VentanaContactos contactos = new VentanaContactos();
			contactos.setVisible(true);
			contactos.setLocationRelativeTo(null);
			contactos.obtenerUltimoId();
			contactos.txtNombre.requestFocus();
			contactos.obtenerUltimoId();
			contactos.construirTabla();
			contactos.btnActualizar.setEnabled(false);
			Timer time = new Timer();
			time.schedule(contactos.tarea, 0, 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
