package com.distribuida.liberty.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.liberty.dto.Album;

@ApplicationScoped
public class ServiciosAlbumImpl implements ServiciosAlbum {

	private static final String FIND_ALL_ALBUMS = "SELECT * FROM album;";
	private static final String FIND_ALBUM_BY_ID = "SELECT * FROM album WHERE id = ?;";
	
	@Inject private DataSource dataSource;
	
	@Override
	public Album getAlbumById(Integer id) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Album> listaAlb = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			pstm = con.prepareStatement(FIND_ALBUM_BY_ID);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
                Album alb = new Album();
                alb.setId(rs.getInt(1));
                alb.setSingerId(rs.getInt(2));
                alb.setTitle(rs.getString(3));
                alb.setReleaseDate(rs.getDate(4));
                listaAlb.add(alb);
                
            }
			pstm.close();
            rs.close();
            con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAlb.get(0);
	}

	@Override
	public List<Album> getAlbums() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Album> listaAlb = new ArrayList<>();
		try {
            con = dataSource.getConnection();
            pstm = con.prepareStatement(FIND_ALL_ALBUMS);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Album alb = new Album();
                alb.setId(rs.getInt(1));
                alb.setSingerId(rs.getInt(2));
                alb.setTitle(rs.getString(3));
                alb.setReleaseDate(rs.getDate(4));
                listaAlb.add(alb);
            }
            pstm.close();
            rs.close();
            con.close();
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER CONSULTA");
            e.printStackTrace();
        }
        return listaAlb;
	}

}
