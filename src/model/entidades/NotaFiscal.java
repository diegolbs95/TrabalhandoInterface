package model.entidades;

public class NotaFiscal {
	
	private Double PagamentoBasico;
	private Double taxa;

	public NotaFiscal() {
		
	}

	public NotaFiscal(Double pagamentoBasico, Double taxa) {
		PagamentoBasico = pagamentoBasico;
		this.taxa = taxa;
	}

	public Double getPagamentoBasico() {
		return PagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		PagamentoBasico = pagamentoBasico;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public double TotalPagamento() {
		return getPagamentoBasico() + getTaxa();
	}

}
