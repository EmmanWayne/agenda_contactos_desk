package Consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Clases.Contacto;
import Conexion.Conexion;

public class ConsultasContactos extends Conexion {

	public boolean insertar(Contacto contactos) {
		PreparedStatement ps = null;
		Connection con = conectar();
		String sql = "INSERT INTO contacts (name, phone, email, image) VALUES (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, contactos.getName());
			ps.setString(2, contactos.getPhone());
			ps.setString(3, contactos.getEmail());
			ps.setString(4, contactos.getImage());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

	public boolean actualizar(Contacto contactos) {
		PreparedStatement ps = null;
		Connection con = conectar();

		String sql = "UPDATE contacts SET name=?, phone=?, email=?, image=? WHERE id=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, contactos.getName());
			ps.setString(2, contactos.getPhone());
			ps.setString(3, contactos.getEmail());
			ps.setString(4, contactos.getImage());
			ps.setInt(5, contactos.getId());
			ps.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}

	}

}
