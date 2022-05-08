package com.example.backend_LP3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Dao.DaoAutor;
import Dao.DaoImagem;
import Dao.DaoTag;
import model.AutorModel;
import model.ImagemModel;
import model.TagModel;

@SpringBootApplication
@RestController
public class BackendLp3Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendLp3Application.class, args);
	}
	
	// rodar no cmd mvn spring-boot:run
	
	
	//Metodo responsável por obter o autor cadastrado
	@RequestMapping(value="/getAutor", method = RequestMethod.GET)
	public ResponseEntity<String> get() {
		
		DaoAutor dao = new DaoAutor();
		AutorModel autor = new AutorModel();
		
		
		String retorno = "OK";
		autor = dao.find(autor);
		
		return ResponseEntity.ok().body("FOI");
	}
	
	
	//Metodo responsável por inserir o Autor
	@RequestMapping(value="/Autor", method = RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody AutorModel autorObj) {
		DaoAutor daoAutor = new DaoAutor();
		
		daoAutor.insert(autorObj);
		
		return ResponseEntity.ok("Ok");
	}
	
	
	//Metodo responsável por atualizar o Autor 
	@RequestMapping(value="/updAutor", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@RequestBody AutorModel autorObj) {
		DaoAutor daoAutor = new DaoAutor();
		
		daoAutor.update(autorObj);
		
		return ResponseEntity.ok("Ok");
	}
	
	//Metodo responsável por eliminar o Autor
		@RequestMapping(value="/delAutor", method = RequestMethod.DELETE)
		public ResponseEntity<String> delete(@RequestBody AutorModel autorObj) {
			DaoAutor daoAutor = new DaoAutor();
			
			daoAutor.delete(autorObj);
			
			return ResponseEntity.ok("Ok");
		}
		
		
	//------------------------------------ Imagem ----------------------------------------------------
		
		//Metodo responsável por obter a imagem cadastrada
		@RequestMapping(value="/getImagem", method = RequestMethod.GET)
		public ResponseEntity<String> getimagem() {
			
			DaoImagem dao = new DaoImagem();
			ImagemModel autor = new ImagemModel();
			
			
			String retorno = "OK";
			autor = dao.find(autor);
			
			return ResponseEntity.ok().body("FOI");
		}
		
		
		//Metodo responsável por inserir a imagem
		@RequestMapping(value="/Imagem", method = RequestMethod.POST)
		public ResponseEntity<String> insert(@RequestBody ImagemModel imagemObj) {
			DaoImagem daoImagem = new DaoImagem();
			
			daoImagem.insert(imagemObj);
			
			return ResponseEntity.ok("Ok");
		}
		
		
		//Metodo responsável por atualizar o Autor 
		@RequestMapping(value="/updImagem", method = RequestMethod.PUT)
		public ResponseEntity<String> update(@RequestBody ImagemModel imagemObj) {
			DaoImagem daoImagem = new DaoImagem();
			
			daoImagem.update(imagemObj);
			
			return ResponseEntity.ok("Ok");
		}
		
		//Metodo responsável por deletar a imagem 
			@RequestMapping(value="/delImagem", method = RequestMethod.DELETE)
			public ResponseEntity<String> deleteImagem(@RequestBody ImagemModel imagemObj) {
				DaoImagem daoImagem = new DaoImagem();
				
				daoImagem.delete(imagemObj);
				
				return ResponseEntity.ok("Ok");
			}
			
			//------------------------------------ Tag ----------------------------------------------------
			
			//Metodo responsável por obter a imagem cadastrada
			@RequestMapping(value="/getTag", method = RequestMethod.GET)
			public ResponseEntity<String> getTag() {
				
				DaoTag dao = new DaoTag();
				TagModel tag = new TagModel();
				
				
				String retorno = "OK";
				tag = dao.find(tag);
				
				return ResponseEntity.ok().body("FOI");
			}
			
			
			//Metodo responsável por inserir a imagem
			@RequestMapping(value="/Tag", method = RequestMethod.POST)
			public ResponseEntity<String> insert(@RequestBody TagModel tagObj) {
				DaoTag daoTag = new DaoTag();
				
				daoTag.insert(tagObj);
				
				return ResponseEntity.ok("Ok");
			}
			
			
			//Metodo responsável por atualizar o Autor 
			@RequestMapping(value="/updTag", method = RequestMethod.PUT)
			public ResponseEntity<String> update(@RequestBody TagModel tagObj) {
				DaoTag daoTag = new DaoTag();
				
				daoTag.update(tagObj);
				
				return ResponseEntity.ok("Ok");
			}
			
			//Metodo responsável por deletar a imagem 
				@RequestMapping(value="/delTag", method = RequestMethod.DELETE)
				public ResponseEntity<String> delete(@RequestBody TagModel tagObj) {
					DaoTag daoTag = new DaoTag();
					
					daoTag.delete(tagObj);
					
					return ResponseEntity.ok("Ok");
				}
}
