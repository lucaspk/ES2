package cargos;

import exceptions.SalarioInvalidoException;

public abstract class Cargo {
	
	private double salarioLiquido;
	private double desconto;
	private double salarioBase;
	private double minimaPorcentagemDesconto;
	private double maximaPorcentagemDesconto = 100.0;
	
	public Cargo() {
		this.salarioLiquido = 0.0;
		this.desconto = 0.0;
		this.salarioBase = 0.0;
	}

	// �til para os testes de cargos
	public Cargo(final double salario) throws SalarioInvalidoException {
		final boolean salarioEhNegativo = salario < 0.0;
		if(salarioEhNegativo){
			throw new SalarioInvalidoException();
		}
		this.setSalarioLiquido(salario);
	}

	public abstract double calcularPorcentagemDesconto();

	public abstract double calcularSalario();
	
	public void setMinimaPorcentagemDesconto(final double novaMinPorcentDesconto) {
		
		if (maximaPorcentagemDesconto <= novaMinPorcentDesconto || novaMinPorcentDesconto < 0.0) {
			try {
				throw new Exception("Porcentagem m�nima de desconto deve ser menor que a m�xima.");
			} catch (Exception e) {
				e.getMessage();
			}
		} else {
			this.minimaPorcentagemDesconto = novaMinPorcentDesconto;
		}
	}
	
	public void setMaximaPorcentagemDesconto(final double novaMaxPorcentDesconto) {
		if (minimaPorcentagemDesconto >= novaMaxPorcentDesconto || novaMaxPorcentDesconto < 0.0) {
			try {
				throw new Exception("Porcentagem m�xima de desconto deve ser maior que a m�nima.");
			} catch (Exception e) {
				e.getMessage();
			}
		} else {
			this.maximaPorcentagemDesconto = novaMaxPorcentDesconto;
		}
	}
	
	public double getMaximaPorcentagemDesconto() {
		return maximaPorcentagemDesconto;
	}

	public double getMinimaPorcentagemDesconto() {
		return minimaPorcentagemDesconto;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public final void setSalarioLiquido(final double novoSalarioLiquido) {
		this.salarioLiquido = novoSalarioLiquido;
	}

	public double getDesconto() {
		return desconto;
	}
	
	public void setDesconto(final double desconto) {
		this.desconto = desconto;
	}
	
	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(final double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
}
