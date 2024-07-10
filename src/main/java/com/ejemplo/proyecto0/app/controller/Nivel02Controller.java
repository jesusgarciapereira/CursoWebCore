package com.ejemplo.proyecto0.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.proyecto0.app.model.Animal;

@Controller
@RequestMapping("/animales")
public class Nivel02Controller {

//	@Value("Animales")
//	private String miTitulo;
	
	@ModelAttribute("titulo")
	public String titulo() {
		return "Animales";
	}

	private List<Animal> miLista = dameListaAnimales();
	
	private List<Animal> dameListaAnimales() {
		List<Animal> lista = new ArrayList<>();
		lista.add(new Animal("perro", 350.0, 12350));
		lista.add(new Animal("gato", 125.0, 7220));
		lista.add(new Animal("pájaro", 70.0, 350));
		lista.add(new Animal("perro", 233.0, 15111));
		lista.add(new Animal("gato", 245.0, 6123));
		return lista;

	}

	@GetMapping("/ungato")
	public String unGato(Model model) {

		Animal miGato = new Animal("gato", 77.5, 3120);
		// miGato = null;

		model.addAttribute("cabecera", "Mostrando un gato");
		model.addAttribute("parrafo", "Estos son los datos de mi gato");
//		model.addAttribute("tipo", miGato.getTipo());
//		model.addAttribute("peso", miGato.getPeso());
//		model.addAttribute("precio", miGato.getPrecio());
		model.addAttribute("gato", miGato);

		return "animal/un-gato";
	}

	@GetMapping("/ningungato")
	public String ningunGato(Model model) {

		model.addAttribute("cabecera", "Mostrando ningún gato");
		model.addAttribute("parrafo", "No hay ningún gato para mostrar su información");
		model.addAttribute("gato", null);
		return "animal/un-gato";

	}

//	@GetMapping("/lista")
//	public String listaCompleta(Model model) {
//		model.addAttribute("titulo", miTitulo);
//		model.addAttribute("cabecera", "Mostrando lista de animales");
//		model.addAttribute("parrafo", "Estos son los datos de la lista de animales");
//		model.addAttribute("lista", miLista);
//
//		return "animal/lista-animales";
//	}

	@GetMapping({ "/lista/{cantidad}", "/lista" })
	public String listaPorCantidad1(Model model, @PathVariable(required = false) Integer cantidad) {

		List<Animal> listaFiltrada = new ArrayList<>();

		if (cantidad == null)
			cantidad = 0;
		else if (cantidad > miLista.size())
			cantidad = miLista.size();

		for (int i = 0; i < cantidad; i++) {
			listaFiltrada.add(miLista.get(i));
		}

		model.addAttribute("cabecera", "Mostrando lista de animales");
		model.addAttribute("parrafo", "Estos son los datos de la lista de animales");
		model.addAttribute("lista", listaFiltrada);

		// cantidad <= 0 !! cantidad > miLista.size() ? miLista : miLista.subList(0,
		// cantidad);
		return "animal/lista-animales";
	}

	@GetMapping("/lista2")
	public String listaPorCantidad2(Model model, @RequestParam Integer cantidad) {

		List<Animal> listaFiltrada = new ArrayList<>();

		if (cantidad == null)
			cantidad = 0;
		else if (cantidad > miLista.size())
			cantidad = miLista.size();

		for (int i = 0; i < cantidad; i++) {
			listaFiltrada.add(miLista.get(i));
		}

		model.addAttribute("cabecera", "Mostrando lista de animales");
		model.addAttribute("parrafo", "Estos son los datos de la lista de animales");
		model.addAttribute("lista", listaFiltrada);

		// cantidad <= 0 !! cantidad > miLista.size() ? miLista : miLista.subList(0,
		// cantidad);
		return "animal/lista-animales";
	}

	@GetMapping("/lista3")
	public String listaPorCantidadPorTipo(Model model, @RequestParam Integer cantidad, @RequestParam String tipo) {

		List<Animal> listaFiltrada = new ArrayList<>();

		if (cantidad == null)
			cantidad = 0;
		else if (cantidad > miLista.size())
			cantidad = miLista.size();

		int contadorAnimales = 0;

		for (int i = 0; i < miLista.size(); i++) {
			if (tipo == null)
				break;
			if (tipo.equals(miLista.get(i).getTipo()) && contadorAnimales < cantidad) {
				listaFiltrada.add(miLista.get(i));
				contadorAnimales++;
			}
			if (contadorAnimales > cantidad)
				break;
		}

		model.addAttribute("cabecera", "Mostrando lista de animales");
		model.addAttribute("parrafo", "Estos son los datos de la lista de animales");
		model.addAttribute("lista", listaFiltrada);

		// cantidad <= 0 !! cantidad > miLista.size() ? miLista : miLista.subList(0,
		// cantidad);
		return "animal/lista-animales";
	}

}
