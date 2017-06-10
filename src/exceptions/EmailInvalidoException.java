package exceptions;

public class EmailInvalidoException extends DadosDoFuncionarioInvalidosException {

	public EmailInvalidoException() {
		super("O email digitado � inv�lido.");
	}
	
	public EmailInvalidoException(final String message) {
		super(message);
	}
}
