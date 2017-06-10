package exceptions;

public class EmailInvalidoException extends DadosDoFuncionarioInvalidosException {

	public EmailInvalidoException() {
		super("O email digitado é inválido.");
	}
	
	public EmailInvalidoException(final String message) {
		super(message);
	}
}
