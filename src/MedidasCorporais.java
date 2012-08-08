import java.text.DecimalFormat;
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
	int sexo = 1;
	public static final int SEXO_MASCULINO = 0;
	public static final int SEXO_FEMININO = 1;

	public MedidasCorporais(double peso, double cintura, double pescoco, double altura, double quadril,double massa_gorda_perc_desejada, int sexo){
		this.peso = peso;
		this.cintura = cintura;
		this.pescoco = pescoco;
		this.altura = altura;
		this.quadril = quadril;
		this.massa_gorda_perc_desejada = massa_gorda_perc_desejada;
		this.sexo = sexo;
		this.setMassaGordaPerc(sexo);
		this.setMassaMagraPerc();
	}
	
	public static void main(String[] args) {

		Double peso, cintura, pescoco, altura,quadril=0.0;
		int sexo;
		Scanner scan = new Scanner(System.in);

		System.out.println("Sexo(0 para Masculino e 1 para Feminino): ");
		sexo = Integer.parseInt(scan.nextLine());

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
		}
		
		scan.close();

		double MASSA_GORDA_DESEJADA_PERCENT = 19.0;
		
		MedidasCorporais mc = new MedidasCorporais(peso,cintura,pescoco,altura,quadril,MASSA_GORDA_DESEJADA_PERCENT, sexo);
		
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

}
