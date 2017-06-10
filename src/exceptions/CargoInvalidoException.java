package exceptions;

public class CargoInvalidoException extends DadosDoFuncionarioInvalidosException{
	
	public CargoInvalidoException() {
		super("O cargo � inv�lido.");
	}
	
	public CargoInvalidoException(final String message) {
		super(message);
	}		
}
