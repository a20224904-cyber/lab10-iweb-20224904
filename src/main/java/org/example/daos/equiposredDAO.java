package org.example.daos;
import org.example.dtos.equiposredDTO;
import org.example.dtos.sedesDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class equiposredDAO extends DaoBase {
    public ArrayList<sedesDTO> listarSedes() throws SQLException {
        ArrayList<sedesDTO> lista = new ArrayList<>();
        String sql = "SELECT id_sede, nombre, ciudad "
                + "FROM sedes ORDER BY id_sede";
        try (Connection conn = getConection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                sedesDTO sedes = new sedesDTO(
                        rs.getInt("id_docente"), rs.getString("nombre"),
                        rs.getString("especialidad"));
                lista.add(sedes);
            }
        }
        return lista;
    }
    // El POST solo envía el ID. Aquí recuperamos los datos para la tarjeta.
    public boolean completarDocente(DocenteDTO docente) throws SQLException {
        String sql = "SELECT nombre, especialidad FROM docente "
                + "WHERE id_docente = ?";
        try (Connection con = getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, docente.getIdDocente());
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return false;
                docente.setNombre(rs.getString("nombre"));
                docente.setEspecialidad(rs.getString("especialidad"));
                return true;
            }
        }
    }
    public void registrar(CursoDTO curso) throws SQLException {
        String sql = "INSERT INTO curso (codigo, nombre, creditos, id_docente) "
                + "VALUES (?, ?, ?, ?)";
        try (Connection con = getConection()) {
            con.setAutoCommit(false);
            try (PreparedStatement ps = con.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, curso.getCodigo());
                ps.setString(2, curso.getNombre());
                ps.setInt(3, curso.getCreditos());
                ps.setInt(4, curso.getDocente().getIdDocente());
                ps.executeUpdate();
                // MySQL asigna id_curso. Lo devolvemos en el mismo DTO.
                try (ResultSet claves = ps.getGeneratedKeys()) {
                    if (!claves.next()) {
                        throw new SQLException("No se obtuvo el ID del curso.");
                    }
                    curso.setIdCurso(claves.getInt(1));
                }
                con.commit();
            } catch (SQLException ex) {
                con.rollback();
                throw ex;
            }
        }
    }
}
