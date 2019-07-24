package Entidades.entidade;

public class Produtos {
	private String nome;
	private Double pre�o;
	private Integer qtd;
	
	public Produtos(String nome, Double pre�o, Integer qtd) {
		super();
		this.nome = nome;
		this.pre�o = pre�o;
		this.qtd = qtd;
	}
	
	public Produtos() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPre�o() {
		return pre�o;
	}

	public void setPre�o(Double pre�o) {
		this.pre�o = pre�o;
	}

	public Integer getQtd() {
		return qtd;
	}
	
	public double totalEstoque () {
		return this.pre�o * this.qtd;
	}

	@Override
	public String toString() {
		return "Produto : Nome = " + nome + ", Pre�o = " + pre�o + ", Quantidade = " + qtd;
	}
}
