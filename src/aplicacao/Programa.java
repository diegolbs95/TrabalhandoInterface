package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.AluguelCarro;
import model.entidades.Veiculo;
import model.servico.ServicoDeAluguel;
import model.servico.ServicoTributarioBrasil;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Digite a data do aluguel");
		System.out.print("Modelo do Carro: ");
		String modeloCarro = sc.nextLine();
		System.out.print("Pegou (dd/MM/yyyy hh:ss): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Entregou (dd/MM/yyyy hh:ss): ");
		Date finish = sdf.parse(sc.nextLine());
		
		AluguelCarro car = new AluguelCarro(start, finish, new Veiculo(modeloCarro));
		
		System.out.print("Entre com preco por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.print("Entre com preco por dia: ");
		double precoPorDia = sc.nextDouble();
		
		ServicoDeAluguel serv = new ServicoDeAluguel(precoPorDia, precoPorHora, new ServicoTributarioBrasil());
		
		serv.ProcessoFatura(car);
		
		System.out.println("Nota Fiscal:");
		System.out.println("Pagamento basico: " + String.format("%.2f", car.getNotafiscal().getPagamentoBasico()));
		System.out.println("Taxa: " + String.format("%.2f", car.getNotafiscal().getTaxa()));
		System.out.println("Total a pagar: " + String.format("%.2f", car.getNotafiscal().TotalPagamento()));
		
		
		
		sc.close();
	}

}
