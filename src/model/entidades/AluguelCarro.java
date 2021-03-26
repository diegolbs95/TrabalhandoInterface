package model.entidades;

import java.util.Date;

public class AluguelCarro {
	
	private Date Start;
	private Date finish;
	
	private Veiculo veiculo;
	private NotaFiscal notafiscal;
	
	public AluguelCarro() {
		
	}

	public AluguelCarro(Date start, Date finish, Veiculo veiculo) {
		Start = start;
		this.finish = finish;
		this.veiculo = veiculo;
	}

	public Date getStart() {
		return Start;
	}

	public void setStart(Date start) {
		Start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public NotaFiscal getNotafiscal() {
		return notafiscal;
	}

	public void setNotafiscal(NotaFiscal notafiscal) {
		this.notafiscal = notafiscal;
	}
	
	
}
