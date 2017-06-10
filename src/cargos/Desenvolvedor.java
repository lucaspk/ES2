package cargos;

import exceptions.SalarioInvalidoException;

public class Desenvolvedor extends Cargo {

	private static final double DEZ_PORCENTO = 0.1;
	private static final double VINTE_PORCENTO = 0.2;
	private static final double SALARIO_BASE_DESENVOLVEDOR = 3000.0;
	
	public Desenvolvedor(final double salario) throws SalarioInvalidoException {
		super(salario);
		setSalarioBase(SALARIO_BASE_DESENVOLVEDOR);
	}

	public Desenvolvedor(){
		super();
		setSalarioBase(SALARIO_BASE_DESENVOLVEDOR);
	}

	@Override
	public double calcularPorcentagemDesconto() {
		setDesconto(DEZ_PORCENTO);
		if (getSalarioLiquido() >= getSalarioBase()) {
			setDesconto(VINTE_PORCENTO);
		}
		return getDesconto();
	}

	@Override
	public double calcularSalario() {
		return getSalarioLiquido() - calcularPorcentagemDesconto()*getSalarioLiquido();
	}

}
