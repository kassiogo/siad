package com.ldve.siad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ldve.siad.model.Profissional;
import com.ldve.siad.service.ProfissionalService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("profissional")
public class ProfissionalController {
	
	@Autowired
	private ProfissionalService service;
	
	//INDEX
	@GetMapping("novo")
	public ModelAndView novo(Profissional profissional){
		ModelAndView modelAndView = new ModelAndView("profissional/form");
		modelAndView.addObject("operacao", "novo");
		return modelAndView;
	}
	
	//INCLUIR NOVO PROFISSIONAL
	@PostMapping("save")
	public ModelAndView save(@Valid Profissional profissional, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		
		if(bindingResult.hasErrors()){
			if (profissional.getIdProfissional() == null)
				return novo(profissional);
			else
				return edit(profissional.getIdProfissional());
		}
		
		// limpar máscara de cpf
		if (!profissional.getCpf().equals("")) {
			String tempCpf = profissional.getCpf();
			tempCpf = tempCpf.replace(".", "").replace("-", "");
			profissional.setCpf(tempCpf);
		}
		
		// limpar máscara de cnpj
		if (!profissional.getCnpj().equals("")) {
			String tempCnpj = profissional.getCnpj();
			tempCnpj = tempCnpj.replace(".", "").replace("-", "").replace("/", "");
			profissional.setCnpj(tempCnpj);
		}
		
		
		service.save(profissional);
		
		
		return new ModelAndView("redirect:/profissional/show/" + profissional.getIdProfissional());
	}
	
	//MOSTRAR UM PROFISSIONAL
	@GetMapping("show/{id}")
	public ModelAndView show(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView("profissional/show");
		modelAndView.addObject("profissional", service.findById(id));
		return modelAndView;
	}
	
	//EXCLUIR UM PROFISSIONAL
	@PostMapping("remove/{id}")
	public ModelAndView delete(@PathVariable("id") int id){
		service.deleteById(id);
		return new ModelAndView("redirect:/profissional/search");
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView("profissional/edit");
		modelAndView.addObject("profissional", service.findById(id));
		modelAndView.addObject("operacao", "alterar");
		return modelAndView;
	}
	
	@GetMapping("search")
	public ModelAndView search(){
		return new ModelAndView("profissional/search");
	}
	
	@GetMapping("list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("profissional/list");
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipoPessoa");
		String ativo = request.getParameter("ativo");
		
		modelAndView.addObject( "profissionais", service.find( nome, Integer.parseInt(tipo), Boolean.parseBoolean(ativo) ) );
		return modelAndView;
	}
}
