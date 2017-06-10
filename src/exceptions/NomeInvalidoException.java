package exceptions;

public class NomeInvalidoException extends DadosDoFuncionarioInvalidosException {

	public NomeInvalidoException() {
		super("O nome s� pode conter letras e espa�os.");
	}
	
	public NomeInvalidoException(final String message) {
		super(message);
	}	
}
