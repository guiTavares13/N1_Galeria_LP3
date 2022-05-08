package com.example.backend_LP3.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/autor")
public class AutorController {
	public String Teste() {
		String teste = "teste";
		
		return teste;
	}
}
