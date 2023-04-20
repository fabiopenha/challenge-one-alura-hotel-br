package model.entities;

import java.sql.Date;

public class Reservas {
	private Long id;
	private Date diaChegada;
	private Date diaSaida;
	private String valor;
	private String formaPagamento;
	
	public Reservas(Date diaChegada, Date diaSaida, String valor, String formaPagamento) {
		this.diaChegada = diaChegada;
		this.diaSaida = diaSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}
	

	public Reservas(Long id, Date diaChegada, Date diaSaida, String valor, String formaPagamento) {
		super();
		this.id = id;
		this.diaChegada = diaChegada;
		this.diaSaida = diaSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	

	public Reservas(Long id) {
		super();
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDiaChegada() {
		return diaChegada;
	}

	public void setDiaChegada(Date diaChegada) {
		this.diaChegada = diaChegada;
	}

	public Date getDiaSaida() {
		return diaSaida;
	}

	public void setDiaSaida(Date diaSaida) {
		this.diaSaida = diaSaida;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
	
	
	
}
