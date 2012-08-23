import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;



public class MedidasCorporais {

	double peso;
	double cintura;
	double pescoco;
	double altura;
	double quadril;
	double massa_magra_perc;
	double massa_gorda_perc;
	double massa_gorda_perc_desejada;
	double nivelAtividadeFisica;
	int sexo = 1;
	int idade;
	public static final int SEXO_MASCULINO = 0;
	public static final int SEXO_FEMININO = 1;
	

	public MedidasCorporais(double peso, double cintura, double pescoco, double altura, double quadril,double massa_gorda_perc_desejada, int sexo, double nivelAtividadeFisica, int idade){
		this.peso = peso;
		this.cintura = cintura;
		this.pescoco = pescoco;
		this.altura = altura;
		this.quadril = quadril;
		this.massa_gorda_perc_desejada = massa_gorda_perc_desejada;
		this.sexo = sexo;
		this.idade = idade;
		this.nivelAtividadeFisica = nivelAtividadeFisica;
		this.setMassaGordaPerc(sexo);
		this.setMassaMagraPerc();

		
	}
	
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
		
		if(sexo == SEXO_FEMININO){
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
		
		MedidasCorporais mc = new MedidasCorporais(peso,cintura,pescoco,altura,quadril,MASSA_GORDA_DESEJADA_PERCENT, sexo, nivelAtividadeFisica, idade);
		
		System.out.println();
		System.out.println("========RESULTADO============");
		System.out.println("Massa Gorda(%): " + new DecimalFormat("#,###.00").format(mc.massa_gorda_perc));
		System.out.println("Massa Magra(%): " + new DecimalFormat("#,###.00").format(mc.massa_magra_perc));
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
		
	}
	
	public double getPesoIdeal() {
		return  (this.peso - (this.massa_gorda_perc / 100 * this.peso)) / (1 - (this.massa_gorda_perc_desejada / 100));
	}

	private void setMassaGordaPerc(int sexo){
		if(sexo == SEXO_MASCULINO){
			this.massa_gorda_perc = (495/((1.0324-((Math.log(cintura-pescoco)/Math.log(10))*0.19077)) + (Math.log(altura)/Math.log(10))*0.15456))-450;
		}else{
			this.massa_gorda_perc = ( 495 / ((1.29579 - (0.35004*(Math.log((quadril+cintura)-pescoco)/Math.log(10)))) + (Math.log(altura)/Math.log(10)) * 0.22100) )-450;
		}
	}
	
	private void setMassaMagraPerc(){
		this.massa_magra_perc = (100.0 - this.massa_gorda_perc);
	}
	
	public double getMassaMagraKgs(){
		return (this.massa_magra_perc/100)*this.peso; 
	}

	public double getMassaGordaKgs(){
		return (this.massa_gorda_perc/100)*this.peso; 
	}
	
	public double getGastoCaloricoBasal(){
		return ((10*this.peso)+(6.25*this.altura)-(5*this.idade)+5)*this.nivelAtividadeFisica;
	}

	public double getGastoCaloricoBasalNivelDietaEmagrecimento(){
		return (((10*this.peso)+(6.25*this.altura)-(5*this.idade)+5)*this.nivelAtividadeFisica)*0.8;
	}

	public double getGastoCaloricoBasalNivelDietaHipertrofia(){
		return (((10*this.peso)+(6.25*this.altura)-(5*this.idade)+5)*this.nivelAtividadeFisica)*1.2;
	}

}
