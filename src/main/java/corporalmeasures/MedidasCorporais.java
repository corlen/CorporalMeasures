package corporalmeasures;

public class MedidasCorporais{

    private double peso;
    private double cintura;
	private double pescoco;
	private double altura;
	private double quadril;
	private double peito;
	private double abdomen;
	private double perna;
	private double massaMagraPerc;
	private double massaGordaPerc;
	private double massaMagraPercAdipometro;
	private double massaGordaPercAdipometro;
	private double massaGordaPercDesejada;
	private double nivelAtividadeFisica;
	private int sexo = 1;
	private int idade;
	public static final int SEXO_MASCULINO = 0;
	public static final int SEXO_FEMININO = 1;
	

	public void calculate(){
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public void setPeito(double peito) {
        this.peito = peito;
    }

    public void setAbdomen(double abdomen) {
        this.abdomen = abdomen;
    }

    public void setPerna(double perna) {
        this.perna = perna;
    }

    public double getMassaMagraPerc() {
        return massaMagraPerc;
    }

    public double getMassaGordaPerc() {
        return massaGordaPerc;
    }

    public double getMassaMagraPercAdipometro() {
        return massaMagraPercAdipometro;
    }

    public double getMassaGordaPercAdipometro() {
        return massaGordaPercAdipometro;
    }

    public void setMassaGordaPercDesejada(double massaGordaPercDesejada) {
        this.massaGordaPercDesejada = massaGordaPercDesejada;
    }

    public void setNivelAtividadeFisica(double nivelAtividadeFisica) {
        this.nivelAtividadeFisica = nivelAtividadeFisica;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
