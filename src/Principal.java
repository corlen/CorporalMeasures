import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {

		double MASSA_GORDA_DESEJADA_PERCENT = 0;
		
		Double peso, cintura, pescoco, altura,quadril=0.0, nivelAtividadeFisica;
		int sexo, idade;
		Scanner scan = new Scanner(System.in);

		System.out.println("Sexo(0 para Masculino e 1 para Feminino): ");
		sexo = Integer.parseInt(scan.nextLine());

		System.out.println("Idade: ");
		idade = Integer.parseInt(scan.nextLine());
		
		System.out.println("Peso(em kg): ");
		peso = Double.parseDouble(scan.nextLine());
		
		System.out.println("Cintura(em cm): ");
		cintura = Double.parseDouble(scan.nextLine());

		System.out.println("Pescoco(em cm): ");
		pescoco = Double.parseDouble(scan.nextLine());

		System.out.println("Altura(em cm): ");
		altura = Double.parseDouble(scan.nextLine());
		
		if(sexo == MedidasCorporais.SEXO_FEMININO){
			System.out.println("Quadril(em cm): ");
			quadril = Double.parseDouble(scan.nextLine());
			
			System.out.println("% gordura corporal	\tMulheres");
			System.out.println("Nível de competição	\t9%-12%");
			System.out.println("Bastante em forma	\t<= 15%");
			System.out.println("Em forma			16%-20%");
			System.out.println("Média				21%-25%");
			System.out.println("Abaixo da média		\t26%-30%");
			System.out.println("Precisa de atenção	\t31%-40%+");
			System.out.println();
			System.out.println("% de gordura corporal desejada:");
			MASSA_GORDA_DESEJADA_PERCENT = Double.parseDouble(scan.nextLine());
		}else{
			System.out.println("% gordura corporal	\tHomens");
			System.out.println("Nível de competição	\t3%-6%");
			System.out.println("Bastante em forma	\t<= 9%");
			System.out.println("Em forma			10%-14%");
			System.out.println("Média				15%-19%");
			System.out.println("Abaixo da média		\t20%-25%");
			System.out.println("Precisa de atenção	\t26%-30%+");
			System.out.println();
			System.out.println("% de gordura corporal desejada:");
			MASSA_GORDA_DESEJADA_PERCENT = Double.parseDouble(scan.nextLine());
		}
		
		HashMap<Integer, Double> NIVEL_ATIVIDADE_FISICA = new HashMap<Integer, Double>();
		NIVEL_ATIVIDADE_FISICA.put(1, 1.2);
		NIVEL_ATIVIDADE_FISICA.put(2, 1.375);
		NIVEL_ATIVIDADE_FISICA.put(3, 1.55);
		NIVEL_ATIVIDADE_FISICA.put(4, 1.725);
		NIVEL_ATIVIDADE_FISICA.put(5, 1.9);
		
		System.out.println("Nivel Atividade Fisica:");
		System.out.println("1 - Sedentário (praticamente nenhum exercício)");
		System.out.println("2 - Levemente ativo (exercício leve/esportes 1-3 dias/semana)");
		System.out.println("3 - Moderadamente ativo (exercício moderado/esportes 3-5 dias/semana)");
		System.out.println("4 - Bastante ativo (exercício forte/esportes 6-7 dias/semana)");
		System.out.println("5 - Extra ativo (trabalho físico ou treinamento muito intenso)");
		System.out.println();
		Integer nivel_escolhido = Integer.parseInt(scan.nextLine());
		nivelAtividadeFisica = NIVEL_ATIVIDADE_FISICA.get(nivel_escolhido);
		
		scan.close();

		//double MASSA_GORDA_DESEJADA_PERCENT = 27.5;
		/**
		 * % gordura corporal	Homens		Mulheres
			Nível de competição	3%-6%		9%-12%
			Bastante em forma	<= 9%		<= 15%
			Em forma			10%-14%		16%-20%
			Média				15%-19%		21%-25%
			Abaixo da média		20%-25%		26%-30%
			Precisa de atenção	26%-30%+	31%-40%+
		 */
		
		double peito = 3.0d, abdomen = 3.0d, perna = 3.0d;
		
		MedidasCorporais mc = new MedidasCorporais(peso,cintura,pescoco,
													altura,quadril,MASSA_GORDA_DESEJADA_PERCENT, 
														sexo, nivelAtividadeFisica, idade, 
															peito, abdomen, perna);
		
		System.out.println();
		System.out.println("========RESULTADO============");
		System.out.println("Massa Gorda(%): " + new DecimalFormat("#,###.00").format(mc.massaGordaPerc));
		System.out.println("Massa Magra(%): " + new DecimalFormat("#,###.00").format(mc.massaMagraPerc));
		System.out.println();
		System.out.println("Massa Gorda(Kg): " + new DecimalFormat("#,###.00").format(mc.getMassaGordaKgs()));
		System.out.println("Massa Magra(Kg): " + new DecimalFormat("#,###.00").format(mc.getMassaMagraKgs()));
		System.out.println();
		System.out.println("Peso Ideal(Kg): "+new DecimalFormat("#,###.00").format(mc.getPesoIdeal()));
		System.out.println("Preciso Perder(Kg): "+new DecimalFormat("#,###.00").format(mc.peso-mc.getPesoIdeal()));
		System.out.println();
		System.out.println("Gasto Calorico Basal: "+new DecimalFormat("#,###.00").format(mc.getGastoCaloricoBasal()));
		System.out.println("Gasto Calorico Basal para dieta emagrecimento: "+new DecimalFormat("#,###.00").format(mc.getGastoCaloricoBasalNivelDietaEmagrecimento()));
		System.out.println("Gasto Calorico Basal para hipertrofia: "+new DecimalFormat("#,###.00").format(mc.getGastoCaloricoBasalNivelDietaHipertrofia()));
		System.out.println();
		System.out.println("#Com Adpometro#");
		System.out.println("Massa Gorda(%): " + new DecimalFormat("#,###.00").format(mc.massaGordaPercAdipometro));
		System.out.println("Massa Magra(%): " + new DecimalFormat("#,###.00").format(mc.massaMagraPercAdipometro));
		System.out.println();
		System.out.println("Massa Gorda(Kg): " + new DecimalFormat("#,###.00").format(mc.getMassaGordaKgsComAdipometro()));
		System.out.println("Massa Magra(Kg): " + new DecimalFormat("#,###.00").format(mc.getMassaMagraKgsComAdipometro()));
	}

}
