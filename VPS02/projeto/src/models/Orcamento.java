package models;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;

import java.util.Locale;
import java.util.Objects;


public class 	Orcamento {

	private int id;
	private String fornecedor;
	private String produto;
	private double preco;
	private boolean Compararprecos;
	
	private DecimalFormat df = new DecimalFormat("#.00");
	private final Locale BRASIL = new Locale("pt", "BR");


	public Orcamento (int id) {
		this.id = id;
	}
	
	public Orcamento(String id, String fornecedor, String produto, String preco, boolean Compararprecos ) {
		df.setCurrency(Currency.getInstance(BRASIL));
		try {
			this.id = Integer.parseInt(id);
			this.fornecedor = fornecedor;
			this.produto = produto;
			this.preco = Double.parseDouble(df.parse(preco).toString());
			this.Compararprecos = Compararprecos;
			
		} catch (ParseException e) {
			System.out.println(e);
		}
	}
	



	
	public Orcamento(String linha) {	
			try {
				
				df.setCurrency(Currency.getInstance(BRASIL));
				
				String[] opam = linha.split(";");
				
				this.id = Integer.parseInt(linha.split(";")[0]);
			this.fornecedor = linha.split(";")[1];
			this.produto= linha.split(";")[2];
			this.preco = Double.parseDouble(df.parse(linha.split(";")[3]).toString());
			this.Compararprecos = Boolean.parseBoolean(opam[4]);
				
			} catch (ParseException e) {
				System.out.println(e);
			}
		}
		


	

	public int getId() {
		return id;
	}

	public String getId(String s) {
		return String.format("%d", id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
	public double getPreco() {
		return preco;
	}
	public String getPreco(String s) {
		return String.format("%.2f", preco);
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public boolean getMaisBarato() {
		return Compararprecos;
	}
	public String getMaisBarato( String Compararprecos) {
		return Compararprecos;
	}

	public void setMaisBarato(boolean Compararprecos) {
		this.Compararprecos = Compararprecos;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return id + "\t" + fornecedor + "\t" + produto + "\t" + String.format("%.2f", preco) + "\t" 
	+getMaisBarato()+"\t"+"\t"+ "\n";
	}

	public String toCSV() {
		return id + ";"+ fornecedor +";"+ produto+";"
	+ String.format("%.2f", preco) +";"+ Compararprecos +"\r\n";
	}

	public String[] toVetor() {
		return new String[] { getId(""), fornecedor, produto, getPreco(""),getMaisBarato("") };
	}

}