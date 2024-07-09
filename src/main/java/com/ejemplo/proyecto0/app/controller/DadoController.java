package com.ejemplo.proyecto0.app.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dados")
public class DadoController {
	Random r = new Random();
	
	@GetMapping("/un-dado")
	public String dadoHandler(Model model) {

		model.addAttribute("titulo", "Dado Jesús");
		model.addAttribute("encabezado", "Lanzamiento de un dado al azar");
		model.addAttribute("texto", "Valor del dado lanzado ... ");
		model.addAttribute("valorDado", + r.nextInt(1, 7));
		
		return "dado/vista-dado1";
	}
	
	@GetMapping({"/dos-dados", "/2-dados"})
	public String dosDadosHandler(Model model) {

		model.addAttribute("titulo", "Dos Dados Jesús");
		model.addAttribute("encabezado", "Lanzamiento de dos dados al azar");
		model.addAttribute("texto", "El valor de los dos dados lanzados es ");
		model.addAttribute("valorDado1", + r.nextInt(1, 7));
		model.addAttribute("valorDado2", + r.nextInt(1, 7));
		return "dado/vista-dado2";
	}
}
