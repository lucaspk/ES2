package exceptions;

public class SalarioInvalidoException extends DadosDoFuncionarioInvalidosException {

	public SalarioInvalidoException() {
		super("N�o � aceit�vel sal�rio negativo.");
	}
	
	public SalarioInvalidoException(final String message) {
		super(message);
	}
}
