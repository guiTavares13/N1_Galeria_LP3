package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TagModel;

public class DaoTag implements Dao<TagModel>{

	private Connection connection;
	
	public DaoTag() {
		this.connection = ConexaoDao.getConnection();
	}
	
	@Override
	public void insert(TagModel obj) {
		try {
            PreparedStatement preparedStatement = connection.prepareStatement("exec tb_tag (?)");

            // Parameters start with 1
            preparedStatement.setString(1, obj.getTag());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void update(TagModel obj) {
		try {
            PreparedStatement preparedStatement = connection.prepareStatement("spInsert_tbtag(?, ?)");
            preparedStatement.setString(1, String.valueOf(obj.getId()));
            preparedStatement.setString(2, obj.getTag());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void delete(TagModel obj) {
		try {
            
        	PreparedStatement preparedStatement = connection.prepareStatement("delete from tb_tag where id=?");
            
            preparedStatement.setString(1, String.valueOf(obj.getId()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        		e.printStackTrace();
        } //try
		
	}

	@Override
	public TagModel find(TagModel obj) {
		try {            
            PreparedStatement preparedStatement = connection.prepareStatement("spConsulta_tbTag(?)");
            preparedStatement.setString(1, String.valueOf(obj.getId()));
            preparedStatement.executeQuery();
            
            return obj;

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return obj;
	}

	@Override
	public ArrayList<TagModel> findAll(TagModel obj) {
		try {
            
        	PreparedStatement preparedStatement = connection.prepareStatement("spListagem_tbTags");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        		e.printStackTrace();
        } //try

		return null;
	}

}
