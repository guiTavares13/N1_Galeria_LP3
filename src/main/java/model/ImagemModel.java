package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ImagemModel {
	private AutorModel autor = new AutorModel();
	private int idautor = autor.getId();
    private int id;
    private String path;
    private String descricao;
    private Date data;

    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setId(String id) {
		if (id == null) {
			setId(0);
		} else {
		 setId(Integer.valueOf(id));
		}
	}

	public String getPath() {
		return this.path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Date getDate() {
		return this.data;
	}
	public void setDate(Date dob) {
		this.data = data;
	}
	public void setData(Date date) {
		try { //Conversão de data pode dar erro!!!
			setData(brDateFormat(date));
		} catch (Exception e) {
			e.printStackTrace();
		} //Função brDateFormat definida abaixo...
	}
	
	private Date brDateFormat(Date date2) throws Exception { 
 		if (date2 == null || date2.equals(""))
 			return null;
 		
         java.sql.Date date = null;
         
         try {
             DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
             date = new java.sql.Date( ((java.util.Date)formatter.parse(date2)).getTime() );
         } catch (ParseException e) {            
             throw e;
         }
         return date;
 	}
}
