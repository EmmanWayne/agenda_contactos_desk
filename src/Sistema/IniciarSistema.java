package Sistema;

import java.util.Timer;
import javax.swing.JFrame;
import Ventanas.VentanaContactos;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

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
			Timer time = new Timer();
			time.schedule(contactos.tarea, 0, 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
