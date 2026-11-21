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
}
