package com.ldve.siad.controller;

import java.util.Arrays;
import java.util.List;

import com.ldve.siad.model.Banco;
import com.ldve.siad.service.BancoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BancoController {

	@Autowired
	BancoService service;
	@GetMapping("/banco/novo")
	public ModelAndView novo(Banco banco) {
		ModelAndView modelAndView = new ModelAndView("banco/form");
		modelAndView.addObject("operacao", "novo");
		return modelAndView;
	}

	@GetMapping("/banco/search")
	public ModelAndView search(){
		return new ModelAndView("banco/search");
	}

	@GetMapping("/banco/list")
	public ModelAndView listNome(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("banco/list");
		String nome = request.getParameter("nome");
		String codigo = request.getParameter("codigo");
		
		List<Banco> bancos = service.find(nome, codigo);
		modelAndView.addObject("bancos", bancos);
		return modelAndView;
	}
	
	//MOSTRAR UM BANCO
	@GetMapping("/banco/show/{id}")
	public ModelAndView show(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView("banco/show");
		modelAndView.addObject("banco", service.findById(id));
		return modelAndView;
	}
	
	//EDITAR UM BANCO
	@GetMapping("/banco/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView("banco/form");
		modelAndView.addObject("banco", service.findById(id));
		modelAndView.addObject("operacao", "alterar");
		return modelAndView;
	}

	//SALVAR BANCO
	@PostMapping("/banco/save")
	public ModelAndView save(Banco banco){
		service.save(banco);
		return new ModelAndView( "redirect:/banco/show/" + banco.getIdBanco() );
	}
	
	//EXCLUIR UM BANCO
	//@RequestMapping(value="/banco/remove/{id}", method=RequestMethod.GET)
	@GetMapping("/banco/{id}")
	public ModelAndView delete(@PathVariable("id") int id){
		service.deleteById(id);
		return new ModelAndView("redirect:/banco/search");
	}
}
