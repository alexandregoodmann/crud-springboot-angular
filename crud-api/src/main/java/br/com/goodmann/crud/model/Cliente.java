package br.com.goodmann.crud.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "IDRISCO")
	private Risco risco;

	@NotNull(message = "Nome do cliente não pode ser nulo")
	private String nome;

	@NotNull(message = "Limite de crédito do cliente não pode ser nulo")
	@Column(name = "LIMITECREDITO")
	@Min(value = 0, message = "O valor informado não pode ser negativo")
	private BigDecimal limiteCredito;

	@Column(name = "TAXAJUROS")
	private Double taxaJuros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public void setRisco(Risco risco) {
		this.risco = risco;
	}

	public Risco getRisco() {
		return risco;
	}

	public Double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(Double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

}
