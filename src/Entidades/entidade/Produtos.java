package Entidades.entidade;

public class Produtos {
	private String nome;
	private Double preço;
	private Integer qtd;
	
	public Produtos(String nome, Double preço, Integer qtd) {
		super();
		this.nome = nome;
		this.preço = preço;
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

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
	}

	public Integer getQtd() {
		return qtd;
	}
	
	public double totalEstoque () {
		return this.preço * this.qtd;
	}

	@Override
	public String toString() {
		return "Produto : Nome = " + nome + ", Preço = " + preço + ", Quantidade = " + qtd;
	}
}
