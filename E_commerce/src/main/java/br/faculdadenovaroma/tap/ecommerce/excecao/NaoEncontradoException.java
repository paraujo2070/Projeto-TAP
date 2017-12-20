package br.faculdadenovaroma.tap.ecommerce.excecao;

@SuppressWarnings("serial")
public class NaoEncontradoException extends Exception {
	public NaoEncontradoException(String message) {
		super(message);
	}
}
