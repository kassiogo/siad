package com.ldve.siad.util;

public class GlobalEnum {

	public static enum TipoItemPagamento {
		VALE,
		VALE_FIXO,
		CREDITO,
		RECEITA;
		
		//******************************************
		int getId() {
			switch (this) {
				case VALE:
					return 1;
				case VALE_FIXO:
					return 2;
				case CREDITO:
					return 3;
				case RECEITA:
					return 4;
				default:
					return 0;
			}
		}
		//******************************************
		
		
		//******************************************
		String getDescricao(){
			switch (this) {
				case VALE:
					return "Vale";
				case VALE_FIXO:
					return "Vale Fixo";
				case CREDITO:
					return "Credito";
				case RECEITA:
					return "Receita";
				default:
					return "";
			}
		}
		//******************************************
		
	}
	
	public static enum TipoVale {
		VALE,
		CREDITO;
		
		//******************************************
		public int getId() {
			switch (this) {
				case VALE:
					return 1;
				case CREDITO:
					return 2;
				default:
					return 0;
			}
		}
		//******************************************
		
		
		//******************************************
		public String getDescricao(){
			switch (this) {
				case VALE:
					return "Vale";
				case CREDITO:
					return "Crédito";
				default:
					return "";
			}
		}
		//******************************************
		
	}
}
