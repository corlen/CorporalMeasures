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
	private MedidasCorporais mc;

	@Before
	public void setUp() throws Exception {
		mc = new MedidasCorporais(PESO_EM_KGS, CINTURA_EM_CM, PESCOCO_EM_CM, ALTURA_EM_CM, MASSA_GORDA_DESEJADA_PERCENT);
	}
	
	@Test
	public void testPesoIdeal() {
		Assert.assertEquals(83.18203785517917, mc.getPesoIdeal());
	}

	@Test
	public void testMassaGordaEmKgs() {
		Assert.assertEquals(34.622549337304854, mc.getMassaGordaKgs());
	}

	
	@Test
	public void testConstrutorIsNull() {
		MedidasCorporais mc1 = new MedidasCorporais(0, 0, 0, 0, 0);
		Assert.assertEquals(Double.NaN, mc1.getPesoIdeal());
	}
	
	@Test
	public void testMassaMagraEmKgs(){
		Assert.assertEquals(67.37745066269515, mc.getMassaMagraKgs());
	}
	
//	private String formatValues(double number){
//		return new DecimalFormat("#,###.00").format(number);

//	System.out.println("RESULTADOS: \n\nMassa Gorda(%): " + formatValues(mc.massa_gorda_perc) +
//	"\nMassa Gorda(Kg): " + formatValues(mc.getMassaGordaKgs()) +  
//	"\nMassa Magra(%): " + formatValues(mc.massa_magra_perc) + 
//	"\nMassa Magra(Kg): " + formatValues(mc.getMassaMagraKgs()) + 
//	"\n\nPeso Ideal(Kg): "+ formatValues(mc.getPesoIdeal()) + 
//	"\nPreciso Perder(Kg): " + formatValues((mc.peso-mc.getPesoIdeal()))
//  );
	
}
