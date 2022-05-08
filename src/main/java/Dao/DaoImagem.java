package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import model.ImagemModel;

public class DaoImagem implements Dao<ImagemModel>{
	
	private Connection connection;

	public DaoImagem() {
		this.connection = ConexaoDao.getConnection();
	}
	
	@Override
	public void insert(ImagemModel obj) {
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("exec spInsert_tbimagem (?, ?, ?)");

            // Parameters start with 1
            preparedStatement.setString(1, obj.getPath());
            preparedStatement.setString(2, obj.getDescricao());   
            preparedStatement.setDate(3, (java.sql.Date) obj.getDate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void update(ImagemModel obj) {
		try {
            PreparedStatement preparedStatement = connection.prepareStatement("spUpdate_tbimagens(?, ?, ?, ?)");
            preparedStatement.setString(1, String.valueOf(obj.getId()));
            preparedStatement.setString(2, obj.getPath());
            preparedStatement.setString(3, obj.getDescricao());
            preparedStatement.setDate(4, (java.sql.Date) obj.getDate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void delete(ImagemModel obj) {
		try {
            
        	PreparedStatement preparedStatement = connection.prepareStatement("delete from tb_imagem where id=?");
            
            preparedStatement.setString(1, String.valueOf(obj.getId()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        		e.printStackTrace();
        } //try
		
	}

	@Override
	public ImagemModel find(ImagemModel obj) {
		try {            
            PreparedStatement preparedStatement = connection.prepareStatement("spConsulta_tbimagens(?)");
            
            preparedStatement.executeQuery();
            
            return obj;

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return obj;
		
	}

	@Override
	public ArrayList<ImagemModel> findAll(ImagemModel obj) {
		try {
            
        	PreparedStatement preparedStatement = connection.prepareStatement("spListagem_tbimagens");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        		e.printStackTrace();
        } //try

		return null;
	}
	
}
