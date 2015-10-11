package mvc.beans;

public class Departamento {
	private int codDpto;
	private String nome;
	
	public Departamento() {
	
	}

	public Departamento(String nome) {
		this.nome = nome;
	}

	public Departamento(int codDpto, String nome) {
		this.codDpto = codDpto;
		this.nome = nome;
	}

	public int getCodDpto() {
		return codDpto;
	}

	public void setCodDpto(int codDpto) {
		this.codDpto = codDpto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
