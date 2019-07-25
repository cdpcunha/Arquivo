package Entidades.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Pessoa {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	protected String nome;
	protected Date dtNasc;
	protected String cidadeNasc;
	protected String estado;
	
	public Pessoa(String nome, Date dtNasc, String cidadeNasc, String estado) {
		super();
		this.nome = nome;
		this.dtNasc = dtNasc;
		this.cidadeNasc = cidadeNasc;
		this.estado = estado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDtNasc() {
		return dtNasc;
	}
	public String getCidadeNasc() {
		return cidadeNasc;
	}
	public String getEstado() {
		return estado;
	}
	
	public Integer calculaIdade() {
		long diff = (new Date()).getTime() - this.dtNasc.getTime();
		return ((int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS))/365; 
	}
	@Override
	public String toString() {
		return "Nome = " + nome + ", Data de Nascimento = " + sdf.format(dtNasc) +", Idade = "+ this.calculaIdade()+ ", Naturalidade = " + cidadeNasc + ", Eestado = " + estado;
	}
	
	
}
