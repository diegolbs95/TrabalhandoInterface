package model.servico;

import model.entidades.AluguelCarro;
import model.entidades.NotaFiscal;

public class ServicoDeAluguel{ 

	private Double PrecoPorDia;
	private Double PrecoPorHora;
	
	private ServicoTributarioBrasil servicoTributarioBrasil;

	public ServicoDeAluguel(Double precoPorDia, Double precoPorHora, ServicoTributarioBrasil servicoTributarioBrasil) {
		super();
		PrecoPorDia = precoPorDia;
		PrecoPorHora = precoPorHora;
		this.servicoTributarioBrasil = servicoTributarioBrasil;
	}
	
	public void ProcessoFatura(AluguelCarro aluguelCarro) {
		long temp1 = aluguelCarro.getStart().getTime();//O getTime PEGA O VALOR EM MILISEGUNDOS
		long temp2 = aluguelCarro.getFinish().getTime();
		double horas = (double)(temp2 - temp1) / 1000 / 60 / 60;//CONVERTENDO PARA HORAS 
		
		double pagamentoBasico;
		if(horas < 12.0) {
			pagamentoBasico = Math.ceil(horas) * PrecoPorHora; //Mathceil PARA ARREDONDAR O VALOR PARA CIMA
		}
		else {
			pagamentoBasico = Math.ceil(horas / 24) * PrecoPorDia;
		}
		
		double taxa = servicoTributarioBrasil.taxa(pagamentoBasico);//ESSA PARTE CALCULA PRA MIM O VALOR DO IMPOSTO
		
		aluguelCarro.setNotafiscal(new NotaFiscal(pagamentoBasico, taxa));
		//CRIEI UM NOVO OBJETO DE NOTA DE PAGAMENTO E ASSOCIEI ELE COM MEU OBJETO DE ALUGUEL"aluguelCarro"
	}
	
	

}
