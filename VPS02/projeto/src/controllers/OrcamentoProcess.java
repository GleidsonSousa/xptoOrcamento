package controllers;

import java.util.ArrayList;

import models.Orcamento;
import dao.OrcamentoDAO;



public class OrcamentoProcess{

	public static ArrayList<Orcamento> orcamentos = new ArrayList<>();
	private static OrcamentoDAO or = new OrcamentoDAO();
	
	public static void abrir() {
		orcamentos = or.ler();
		if(orcamentos.size() == 0) {
			orcamentos.add(new Orcamento("0","SAMSUNG","GALAXY-M32","1200,00",false));
		}
	}
	
	public static boolean salvar() {
		or.escrever(orcamentos);
		abrir();
		return false;
	}

	
	
	
	public static void calculo(String produto) {
		int index = 0;
		double maisBarato = 999999999;
		for (Orcamento orcamento : orcamentos) {
			if (orcamento.getProduto().equals(produto) && orcamento.getPreco() < maisBarato) {
				index = orcamentos.indexOf(orcamento);
				maisBarato = orcamento.getPreco();
			}
		}
		
		for (Orcamento orcamento : orcamentos) {
			if (orcamentos.indexOf(orcamento) == index) {
				orcamento.setMaisBarato(true);
			} else if(orcamento.getProduto() == produto){
				orcamento.setMaisBarato(false);
			}
		}
	}
}
