package com.ldve.siad.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.swing.text.MaskFormatter;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Profissional implements Serializable{
	
	private static final long serialVersionUID = 7780956915989539590L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfissional;
	@NotNull
	private String nome;
	private String apelido;
	@NotNull
	private int tipoPessoa;
	private String cpf;
	private String cnpj;
	@OneToMany(mappedBy="profissional", targetEntity = Vale.class)
	private List<Vale> vales;
	@OneToMany(mappedBy="profissional", targetEntity = ReceitaProfissional.class)
	private List<ReceitaProfissional> receitasProfissional;
	@ManyToMany(mappedBy="profissionais")
	private List<ValeFixo> valesFixo;
	@ManyToOne
	@JoinColumn(name="idBanco", referencedColumnName="idBanco")
	private Banco banco;
	@OneToMany(mappedBy="profissional", targetEntity = FolhaPagamentoItem.class)
	private List<FolhaPagamentoItem> folhaPagamentoItens;
	@OneToMany(mappedBy="profissional", targetEntity = VendaItem.class)
	private List<VendaItem> vendasItems;
	@NotNull
	private boolean isAtivo;
	

	public String getCnpjFormatado() {
		String desc = "";
		if (!cnpj.equals("")){
			try {
				MaskFormatter mf = new MaskFormatter("##.###.###/####-##");  
				mf.setValueContainsLiteralCharacters(false);  
				desc = mf.valueToString(cnpj);	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return desc;
	}
	
	public String getCpfFormatado() {
		String desc = "";
		if (!cpf.equals("")){
			try {
				MaskFormatter mf = new MaskFormatter("###.###.###-##");  
				mf.setValueContainsLiteralCharacters(false);  
				desc = mf.valueToString(cpf);	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return desc;
	}
	
}
