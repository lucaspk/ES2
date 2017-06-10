package cargos;

import exceptions.SalarioInvalidoException;

public class Testador extends Cargo {

	/** Essa variáveis são usadas para a entidade Testador default */
	private static final double MIN_PORC_DESC_TESTADOR = 0.15;
	private static final double MAX_PORC_DESC_TESTADOR = 0.25;
	private static final double SALARIO_BASE_TESTADOR = 2000.0;
	
	public Testador() {
		setSalarioBase(SALARIO_BASE_TESTADOR);
		setSalarioLiquido(SALARIO_BASE_TESTADOR);
		setMinimaPorcentagemDesconto(MIN_PORC_DESC_TESTADOR);
		setMaximaPorcentagemDesconto(MAX_PORC_DESC_TESTADOR);
	}

	public Testador(final double salario) throws SalarioInvalidoException {
		super(salario);
		setSalarioBase(SALARIO_BASE_TESTADOR);
		setMinimaPorcentagemDesconto(MIN_PORC_DESC_TESTADOR);
		setMaximaPorcentagemDesconto(MAX_PORC_DESC_TESTADOR);
	}
	
	@Override
	public double calcularPorcentagemDesconto() {
		final double minPorcentDesconto = getMinimaPorcentagemDesconto();
		final double maxPorcentDesconto = getMaximaPorcentagemDesconto();
		
		this.setDesconto(minPorcentDesconto);
		if (this.getSalarioLiquido() >= this.getSalarioBase()) {
			this.setDesconto(maxPorcentDesconto);
		}
		return this.getDesconto();
	}

	@Override
	public double calcularSalario() {
		return getSalarioLiquido() - calcularPorcentagemDesconto()*getSalarioLiquido();
	}

}
