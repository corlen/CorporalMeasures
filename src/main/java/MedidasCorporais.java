public class MedidasCorporais {

	double peso;
	double cintura;
	double pescoco;
	double altura;
	double quadril;
	double peito;
	double abdomen;
	double perna;
	double massaMagraPerc;
	double massaGordaPerc;
	double massaMagraPercAdipometro;
	double massaGordaPercAdipometro;
	double massaGordaPercDesejada;
	double nivelAtividadeFisica;
	int sexo = 1;
	int idade;
	public static final int SEXO_MASCULINO = 0;
	public static final int SEXO_FEMININO = 1;
	

	public MedidasCorporais(double peso, double cintura, double pescoco, double altura, 
								double quadril,double massa_gorda_perc_desejada, int sexo, 
									double nivelAtividadeFisica, int idade,
										double peito, double abdomen, double perna){
		this.peso = peso;
		this.cintura = cintura;
		this.pescoco = pescoco;
		this.altura = altura;
		this.quadril = quadril;
		this.peito = peito;
		this.abdomen = abdomen;
		this.perna = perna;
		this.massaGordaPercDesejada = massa_gorda_perc_desejada;
		this.sexo = sexo;
		this.idade = idade;
		this.nivelAtividadeFisica = nivelAtividadeFisica;
		this.setMassaGordaPerc(sexo);
		this.setMassaMagraPerc();
		this.setMassaGordaPercComAdipometro();
		this.setMassaMagraPercComAdipometro();

		
	}
	
	public double getPesoIdeal() {
		return  (this.peso - (this.massaGordaPerc / 100 * this.peso)) / (1 - (this.massaGordaPercDesejada / 100));
	}

	private void setMassaGordaPerc(int sexo){
		if(sexo == SEXO_MASCULINO){
			this.massaGordaPerc = (495/((1.0324-((Math.log(cintura-pescoco)/Math.log(10))*0.19077)) + (Math.log(altura)/Math.log(10))*0.15456))-450;
		}else{
			this.massaGordaPerc = ( 495 / ((1.29579 - (0.35004*(Math.log((quadril+cintura)-pescoco)/Math.log(10)))) + (Math.log(altura)/Math.log(10)) * 0.22100) )-450;
		}
	}
	private void setMassaMagraPerc(){
		this.massaMagraPerc = (100.0 - this.massaGordaPerc);
	}
	public double getMassaMagraKgs(){
		return (this.massaMagraPerc/100)*this.peso; 
	}
	
	public double getMassaGordaKgs(){
		return (this.massaGordaPerc/100)*this.peso; 
	}
	
	private void setMassaGordaPercComAdipometro(){
		double soma = this.peito + this.abdomen + this.perna;
		this.massaGordaPercAdipometro = ((4.95/(((1.1093800 - 0.0008267*(soma))+ 0.0000016*(soma)*(soma)) - 0.0002574 * this.idade)) - 4.5) * 100;
	}
	
	private void setMassaMagraPercComAdipometro(){
		this.massaMagraPercAdipometro = (100.0 - this.massaGordaPercAdipometro);
	}
	
	public double getMassaMagraKgsComAdipometro(){
		return (this.massaMagraPercAdipometro/100)*this.peso; 
	}
	public double getMassaGordaKgsComAdipometro(){
		return (this.massaGordaPercAdipometro/100)*this.peso;
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
