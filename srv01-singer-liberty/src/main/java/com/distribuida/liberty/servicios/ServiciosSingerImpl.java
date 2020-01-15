package com.distribuida.liberty.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.liberty.dto.Singer;

@ApplicationScoped
public class ServiciosSingerImpl implements ServiciosSinger {
	
	private static final String FIND_ALL_SINGERS = "SELECT * FROM singer;";
	private static final String FIND_SINGER_BY_ID = "SELECT * FROM singer WHERE id = ?;";
	
	@Inject private DataSource dataSource;
	
	@Override
	public Singer getSingerById(Integer id) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Singer> listaSing = new ArrayList<Singer>();
        try {
        	con = dataSource.getConnection();
            pstm = con.prepareStatement(FIND_SINGER_BY_ID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Singer sing = new Singer();
                sing.setId(rs.getInt(1));
                sing.setFirstName(rs.getString(2));
                sing.setLastName(rs.getString(3));
                sing.setBirthDate(rs.getDate(4));
                sing.setVersion(rs.getInt(5));
                listaSing.add(sing);
            }
            pstm.close();
            rs.close();
            con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaSing.get(0);
	}

	@Override
	public List<Singer> getSingers() {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Singer> listaSing = new ArrayList<Singer>();

        try {
            con = dataSource.getConnection();
            pstm = con.prepareStatement(FIND_ALL_SINGERS);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Singer sing = new Singer();
                sing.setId(rs.getInt(1));
                sing.setFirstName(rs.getString(2));
                sing.setLastName(rs.getString(3));
                sing.setBirthDate(rs.getDate(4));
                sing.setVersion(rs.getInt(5));
                listaSing.add(sing);
            }
            pstm.close();
            rs.close();
            con.close();
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER CONSULTA");
            e.printStackTrace();
        }
        return listaSing;
	}
}
