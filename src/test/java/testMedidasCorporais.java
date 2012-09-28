import java.text.DecimalFormat;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class testMedidasCorporais {

	private static final double MASSA_GORDA_DESEJADA_PERCENT = 19.0;
	private static final double ALTURA_EM_CM = 173.0;
	private static final double PESCOCO_EM_CM = 42.0;
	private static final double CINTURA_EM_CM = 115.0;
	private static final double PESO_EM_KGS = 102.0;
	private static final double QUADRIL = 0.0;
	private static final int SEXO = 0;
	private static final int IDADE = 33;
	private static final double NIVEL_ATIVIDADE_FISICA = 1.375;
	private static final double PEITO = 0d;
	private static final double ABDOMEN = 0d;
	private static final double PERNA = 0d;
	
	
	private MedidasCorporais mc;

	@Before
	public void setUp() throws Exception {
		mc = new MedidasCorporais(PESO_EM_KGS, CINTURA_EM_CM, PESCOCO_EM_CM, ALTURA_EM_CM, QUADRIL,MASSA_GORDA_DESEJADA_PERCENT,SEXO, NIVEL_ATIVIDADE_FISICA, IDADE, PEITO, ABDOMEN, PERNA);
	}
	
	@Test
	public void testPesoIdeal() {
		System.out.println("RESULTADOS: \n\nMassa Gorda(%): " + formatValues(mc.massaGordaPerc) +
		"\nMassa Gorda(Kg): " + formatValues(mc.getMassaGordaKgs()) +  
		"\nMassa Magra(%): " + formatValues(mc.massaMagraPerc) + 
		"\nMassa Magra(Kg): " + formatValues(mc.getMassaMagraKgs()) + 
		"\n\nPeso Ideal(Kg): "+ formatValues(mc.getPesoIdeal()) + 
		"\nPreciso Perder(Kg): " + formatValues((mc.peso-mc.getPesoIdeal())));
		Assert.assertEquals(83.18203785517917, mc.getPesoIdeal());
	}

	@Test
	public void testMassaGordaEmKgs() {
		Assert.assertEquals(34.622549337304854, mc.getMassaGordaKgs());
	}

	
	@Test
	public void testConstrutorIsNull() {
		MedidasCorporais mc1 = new MedidasCorporais(0, 0, 0, 0, 0,0,0,0,0,0,0,0);
		Assert.assertEquals(Double.NaN, mc1.getPesoIdeal());
	}
	
	
	private String formatValues(double number){
		return new DecimalFormat("#,###.00").format(number);
	}	

	
}
