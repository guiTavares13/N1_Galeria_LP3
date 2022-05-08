package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import model.AutorModel;

public class DaoAutor implements Dao<AutorModel> {
	
	private Connection connection;
	
	public DaoAutor() {
		this.connection = ConexaoDao.getConnection();
	}
	


	@Override
	public void update(AutorModel obj) {
		
		try {
            PreparedStatement preparedStatement = connection.prepareStatement("spUpdate_tbautor(?, ?, ?)");
            preparedStatement.setString(1, String.valueOf(obj.getId()));
            preparedStatement.setString(2, obj.getName());
            preparedStatement.setString(3, obj.getDescricao());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void delete(AutorModel obj) {
		
		try {
            
        	PreparedStatement preparedStatement = connection.prepareStatement("delete from tb_autor where id=?");
            
            // Parameters start with 1
            preparedStatement.setString(1, String.valueOf(obj.getId()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        		e.printStackTrace();
        } //try
	}

	@Override
	public AutorModel find(AutorModel obj) {
		try {            
            PreparedStatement preparedStatement = connection.prepareStatement("spConsulta_tbautor(?)");
            preparedStatement.setString(1, String.valueOf(obj.getId()));
            preparedStatement.executeQuery();
            
            return obj;

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return obj;
	}

	
	@Override
	public ArrayList<AutorModel> findAll(AutorModel obj) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("spListagem_tbautor");
	        preparedStatement.setString(1, String.valueOf(obj.getId()));
	        
	        preparedStatement.executeQuery();
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		return null;
	}



	@Override
	public void insert(AutorModel autor) {
		
		try {
            PreparedStatement preparedStatement = connection.prepareStatement("spInsert_tbautor(?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, autor.getName());
            preparedStatement.setString(2, autor.getDescricao());
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}

}
