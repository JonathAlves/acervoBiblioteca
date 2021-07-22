package Avisos;

public class MensagemSucesso {
	
	
	private String mensagem;
	
	
	public MensagemSucesso() {

	}
	
	public MensagemSucesso(String mensagem) {
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
