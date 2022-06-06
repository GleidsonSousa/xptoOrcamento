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
			orcamentos.add(new Orcamento("0","SAMSUNG","GALAXY-M32","1200,00"));
		}
	}
	
	public static void salvar() {
		or.escrever(orcamentos);
	}

	
}
