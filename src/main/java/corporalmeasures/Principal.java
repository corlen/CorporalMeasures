package corporalmeasures;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {

		Double massaGordaDesejadaPercent = 0D;
		Double peso;
        Double cintura = 0D;
        Double pescoco = 0D;
        Double altura;
        Double quadril=0.0;
        Double nivelAtividadeFisica=0D;
		Integer sexo;
        Integer idade;
        Integer menuEscolhido;

		Scanner scan = new Scanner(System.in);

		System.out.println("Menu:");
		System.out.println("1 - Peso Ideal");
		System.out.println("2 - Gasto Calórico Basal");
		menuEscolhido = Integer.parseInt(scan.nextLine());

		System.out.println("Sexo: ");
		System.out.println("0 - Masculino");
		System.out.println("1 - Feminino");
		sexo = Integer.parseInt(scan.nextLine());
		
		System.out.println("Idade: ");
		idade = Integer.parseInt(scan.nextLine());
		
		System.out.println("Peso(em kg): ");
		peso = Double.parseDouble(scan.nextLine());
		
		System.out.println("Altura(em cm): ");
		altura = Double.parseDouble(scan.nextLine());

		if(menuEscolhido == 1){
			System.out.println("Cintura(em cm): ");
			cintura = Double.parseDouble(scan.nextLine());

			System.out.println("Pescoco(em cm): ");
			pescoco = Double.parseDouble(scan.nextLine());

			if(sexo.equals(MedidasCorporais.SEXO_FEMININO)){
				System.out.println("Quadril(em cm): ");
				quadril = Double.parseDouble(scan.nextLine());
				
				System.out.println("% gordura corporal	\tMulheres");
				System.out.println("Nivel de Competicao\t\t9%-12%");
				System.out.println("Bastante em forma	\t<= 15%");
				System.out.println("Em forma			\t16%-20%");
				System.out.println("Media 				\t21%-25%");
				System.out.println("Abaixo da media		\t26%-30%");
				System.out.println("Precisa de atencao	\t31%-40%+");
				System.out.println();
				System.out.println("% de gordura corporal desejada:");
				massaGordaDesejadaPercent = Double.parseDouble(scan.nextLine());
			}else{
				System.out.println("% gordura corporal\t\tHomens");
				System.out.println("Nivel de Competicao \t3%-6%");
				System.out.println("Bastante em forma	\t<= 9%");
				System.out.println("Em forma			\t10%-14%");
				System.out.println("Media 				\t15%-19%");
				System.out.println("Abaixo da media		\t20%-25%");
				System.out.println("Precisa de atencao 	\t26%-30%+");
				System.out.println();
				System.out.println("% de gordura corporal desejada:");
				massaGordaDesejadaPercent = Double.parseDouble(scan.nextLine());
			}
		}
		
		if(menuEscolhido == 2){
			HashMap<Integer, Double> NIVEL_ATIVIDADE_FISICA = new HashMap<Integer, Double>();
			NIVEL_ATIVIDADE_FISICA.put(1, 1.2);
			NIVEL_ATIVIDADE_FISICA.put(2, 1.375);
			NIVEL_ATIVIDADE_FISICA.put(3, 1.55);
			NIVEL_ATIVIDADE_FISICA.put(4, 1.725);
			NIVEL_ATIVIDADE_FISICA.put(5, 1.9);
				
			
			System.out.println("Nivel Atividade Fisica:");
			System.out.println("1 - Sedentario (praticamente nenhum exercicio)");
			System.out.println("2 - Levemente ativo (exercicio leve/esportes 1-3 dias/semana)");
			System.out.println("3 - Moderadamente ativo (exercicio moderado/esportes 3-5 dias/semana)");
			System.out.println("4 - Bastante ativo (exercicio forte/esportes 6-7 dias/semana)");
			System.out.println("5 - Extra ativo (trabalho fisico ou treinamento muito intenso)");
			System.out.println();
			Integer nivel_escolhido = Integer.parseInt(scan.nextLine());
			nivelAtividadeFisica = NIVEL_ATIVIDADE_FISICA.get(nivel_escolhido);

		}
		
		scan.close();

		MedidasCorporais mc = new MedidasCorporais();
        mc.setPeso(peso);
        mc.setCintura(cintura);
        mc.setPescoco(pescoco);
        mc.setAltura(altura);
        mc.setQuadril(quadril);
        mc.setMassaGordaPercDesejada(massaGordaDesejadaPercent);
        mc.setSexo(sexo);
        mc.setNivelAtividadeFisica(nivelAtividadeFisica);
        mc.setIdade(idade);
        mc.calculate();

		System.out.println();
		System.out.println("========RESULTADO============");
		if(menuEscolhido == 1){
			System.out.println("Massa Gorda(%): " + new DecimalFormat("#,###.00").format(mc.getMassaGordaPerc()));
			System.out.println("Massa Magra(%): " + new DecimalFormat("#,###.00").format(mc.getMassaMagraPerc()));
			System.out.println();
			System.out.println("Massa Gorda(Kg): " + new DecimalFormat("#,###.00").format(mc.getMassaGordaKgs()));
			System.out.println("Massa Magra(Kg): " + new DecimalFormat("#,###.00").format(mc.getMassaMagraKgs()));
			System.out.println();
			System.out.println("Peso Ideal(Kg): "+new DecimalFormat("#,###.00").format(mc.getPesoIdeal()));
			System.out.println("Preciso Perder(Kg): "+new DecimalFormat("#,###.00").format(mc.getPeso()-mc.getPesoIdeal()));
			System.out.println();
		}else if(menuEscolhido == 2){
			System.out.println("Gasto Calorico Basal: "+new DecimalFormat("#,###.00").format(mc.getGastoCaloricoBasal()));
			System.out.println("Gasto Calorico Basal para dieta emagrecimento: "+new DecimalFormat("#,###.00").format(mc.getGastoCaloricoBasalNivelDietaEmagrecimento()));
			System.out.println("Gasto Calorico Basal para hipertrofia: "+new DecimalFormat("#,###.00").format(mc.getGastoCaloricoBasalNivelDietaHipertrofia()));
			System.out.println();
		}
	}	
}
