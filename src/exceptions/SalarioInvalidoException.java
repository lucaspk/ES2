package exceptions;

public class SalarioInvalidoException extends DadosDoFuncionarioInvalidosException {

	public SalarioInvalidoException() {
		super("Não é aceitável salário negativo.");
	}
	
	public SalarioInvalidoException(final String message) {
		super(message);
	}
}
