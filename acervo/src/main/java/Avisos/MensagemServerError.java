package Avisos;

public class MensagemServerError {
	
	private String mensagem;
	
	public MensagemServerError(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return mensagem;
	}
	
	
}
