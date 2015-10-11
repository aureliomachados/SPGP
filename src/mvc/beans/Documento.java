package mvc.beans;


public class Documento {
	
	private int numProtolo; 
	private String nomeInteressado;
	private String cpf_cnpj;
	private int numDoc;
	private String dataDoc;
	private String assunto;
	private String dataEntrada;
	private String dataEncerramento;
	private String tipo;
	private String providencia;
	private String status;
	private int analista;
	
	
		
	public Documento(int numProtolo, String status) {
		this.numProtolo = numProtolo;
		this.status = status;
	}
	
	public Documento( String nomeInteressado, String cpf_cnpj,
			int numDoc, String dataDoc, String assunto, String dataEntrada,
			String tipo, String status, int analista) {
	
		this.nomeInteressado = nomeInteressado;
		this.cpf_cnpj = cpf_cnpj;
		this.numDoc = numDoc;
		this.dataDoc = dataDoc;
		this.assunto = assunto;
		this.dataEntrada = dataEntrada;
		this.tipo = tipo;
		this.status = status;
		this.analista = analista;
		
		
	}
	
	public Documento(int numProtolo,String nomeInteressado, String cpf_cnpj,
			int numDoc, String dataDoc, String assunto, String dataEntrada,
			String tipo, String status, int analista) {
		
		this.numProtolo = numProtolo;
		this.nomeInteressado = nomeInteressado;
		this.cpf_cnpj = cpf_cnpj;
		this.numDoc = numDoc;
		this.dataDoc = dataDoc;
		this.assunto = assunto;
		this.dataEntrada = dataEntrada;
		this.tipo = tipo;
		this.status = status;
		this.analista = analista;
		
		
	}

	public Documento(int numProtolo, String nomeInteressado, String cpf_cnpj,
			int numDoc, String dataDoc, String assunto, String dataEntrada,
			String dataEncerramento, String tipo, String providencia,
			String status, int analista) {
	
		this.numProtolo = numProtolo;
		this.nomeInteressado = nomeInteressado;
		this.cpf_cnpj = cpf_cnpj;
		this.numDoc = numDoc;
		this.dataDoc = dataDoc;
		this.assunto = assunto;
		this.dataEntrada = dataEntrada;
		this.dataEncerramento = dataEncerramento;
		this.tipo = tipo;
		this.providencia = providencia;
		this.status = status;
		this.analista = analista;
		
	}
	
	public Documento() {
		
	}

	public int getNumProtolo() {
		return numProtolo;
	}
	public void setNumProtolo(int numProtolo) {
		this.numProtolo = numProtolo;
	}
	public String getNomeInteressado() {
		return nomeInteressado;
	}
	public void setNomeInteressado(String nomeInteressado) {
		this.nomeInteressado = nomeInteressado;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public int getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(int numDoc) {
		this.numDoc = numDoc;
	}
	public String getDataDoc() {
		return dataDoc;
	}
	public void setDataDoc(String dataDoc) {
		this.dataDoc = dataDoc;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(String dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getProvidencia() {
		return providencia;
	}
	public void setProvidencia(String providencia) {
		this.providencia = providencia;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAnalista() {
		return analista;
	}
	public void setAnalista(int analista) {
		this.analista = analista;
	}
}
