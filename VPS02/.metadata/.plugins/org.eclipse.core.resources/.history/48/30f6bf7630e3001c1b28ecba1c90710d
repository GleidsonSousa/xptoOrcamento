package models;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Vector;

public class Manutencao {

	private int id;
	private Date data;
	private String equipamento;
	private double custoHora;
	private double tempoGasto;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat df = new DecimalFormat("#.00");
	private final Locale BRASIL = new Locale("pt", "BR");


	
	
	public Manutencao(int id) {
		this.id = id;
	}
	
	public Manutencao(String id, String data, String equipamento, String custoHora, String tempoGasto) {
		df.setCurrency(Currency.getInstance(BRASIL));
		try {
			this.id = Integer.parseInt(id);
			this.data = sdf.parse(data);
			this.equipamento = equipamento;
			this.custoHora = Double.parseDouble(df.parse(custoHora).toString());
			this.tempoGasto = Double.parseDouble(df.parse(tempoGasto).toString());
		} catch (ParseException e) {
			System.out.println(e);
		}
	}
	
	public Manutencao(String id, String equipamento, String custoHora, String tempoGasto) {
		df.setCurrency(Currency.getInstance(BRASIL));
		try {
			this.id = Integer.parseInt(id);
			this.data = new Date();
			this.equipamento = equipamento;
			this.custoHora = Double.parseDouble(df.parse(custoHora).toString());
			this.tempoGasto = Double.parseDouble(df.parse(tempoGasto).toString());
		} catch (ParseException e) {
			System.out.println(e);
		}
	}


	
	public Manutencao(String linha) {	
			try {
				df.setCurrency(Currency.getInstance(BRASIL));
				this.id = Integer.parseInt(linha.split(";")[0]);
			this.data = sdf.parse(linha.split(";")[1]);
			this.equipamento = linha.split(";")[2];
			this.custoHora = Double.parseDouble(df.parse(linha.split(";")[3]).toString());
			this.tempoGasto = Double.parseDouble(df.parse(linha.split(";")[4]).toString());
				
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
	
	public Date getData() {
		return data;
	}

	public String getData(String s) {
		return sdf.format(data);
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public double getcustoHora() {
		return custoHora;
	}
	public String getcustoHora(String s) {
		return String.format("%.2f", custoHora);
	}

	public void setcustoHora(double custoHora) {
		this.custoHora = custoHora;
	}
	
	public double gettempoGasto() {
		return tempoGasto;
	}
	public String gettempoGasto(String s) {
		return String.format("%.2f", tempoGasto);
	}

	public void settempoGasto(double tempoGasto) {
		this.tempoGasto = tempoGasto;
	}
	public String getobterTotal() {
		return df.format(custoHora * tempoGasto);
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
		Manutencao other = (Manutencao) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return id + "\t" + sdf.format(data) + "\t" + equipamento + "\t" + String.format("%.2f", custoHora) + "\t" + 
	String.format("%.2f", tempoGasto) +getobterTotal()+ "\t"+ "\n";
	}

	public String toCSV() {
		return id + ";" + sdf.format(data) + ";" + equipamento + ";" + String.format("%.2f", custoHora) 
		+ ";" + String.format("%.2f", tempoGasto)+"\r\n";
	}

	public String[] toVetor() {
		return new String[] { getId(""), getData(""), equipamento, getcustoHora(""), gettempoGasto(""), getobterTotal() };
	}

}