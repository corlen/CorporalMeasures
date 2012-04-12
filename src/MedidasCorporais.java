import java.text.DecimalFormat;



public class MedidasCorporais {

	double peso;
	double cintura;
	double pescoco;
	double altura;
	double massa_magra_perc;
	double massa_gorda_perc;
	double massa_gorda_perc_desejada;

	public MedidasCorporais(double peso, double cintura, double pescoco, double altura, double massa_gorda_perc_desejada){
		this.peso = peso;
		this.cintura = cintura;
		this.pescoco = pescoco;
		this.altura = altura;
		this.massa_gorda_perc_desejada = massa_gorda_perc_desejada;
		this.setMassaGordaPerc();
		this.setMassaMagraPerc();
	}
	
	public static void main(String[] args) {

		double MASSA_GORDA_DESEJADA_PERCENT = 19.0;
		double ALTURA_EM_CM = 173.0;
		double PESCOCO_EM_CM = 42.0;
		double CINTURA_EM_CM = 115.0;
		double PESO_EM_KGS = 102.0;
		
		MedidasCorporais mc = new MedidasCorporais(PESO_EM_KGS,CINTURA_EM_CM,PESCOCO_EM_CM,ALTURA_EM_CM,MASSA_GORDA_DESEJADA_PERCENT);
		
		System.out.println("Massa Gorda(%): " + new DecimalFormat("#,###.00").format(mc.massa_gorda_perc));
		System.out.println("Massa Gorda(Kg): " + new DecimalFormat("#,###.00").format(mc.getMassaGordaKgs()));
		System.out.println("Massa Magra(%): " + new DecimalFormat("#,###.00").format(mc.massa_magra_perc));
		System.out.println("Massa Magra(Kg): " + new DecimalFormat("#,###.00").format(mc.getMassaMagraKgs()));
		System.out.println();
		System.out.println("Peso Ideal(Kg): "+new DecimalFormat("#,###.00").format(mc.getPesoIdeal()));
		System.out.println("Preciso Perder(Kg): "+new DecimalFormat("#,###.00").format(mc.peso-mc.getPesoIdeal()));
		
	}
	
	public double getPesoIdeal() {
		return (this.peso - (this.massa_gorda_perc / 100 * this.peso)) / (1 - (this.massa_gorda_perc_desejada / 100));
	}

	private void setMassaGordaPerc(){
		this.massa_gorda_perc = (495/((1.0324-((Math.log(cintura-pescoco)/Math.log(10))*0.19077)) + (Math.log(altura)/Math.log(10))*0.15456))-450;
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
