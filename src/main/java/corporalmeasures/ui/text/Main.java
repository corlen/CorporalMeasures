package corporalmeasures.ui.text;

import corporalmeasures.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu:");
        System.out.println("1 - Peso Ideal");
        System.out.println("2 - Gasto Calórico Basal");
        Integer mainMenu = Integer.parseInt(scanner.nextLine());

        if(mainMenu == 1) {

            System.out.println("Sexo: ");
            System.out.println("1 - Masculino");
            System.out.println("2 - Feminino");
            Integer genderSelected = Integer.parseInt(scanner.nextLine());

            if (genderSelected == 2) {
                FemalePersonData femalePersonData = new FemalePersonData();

                System.out.println("Peso(em Kgs): ");
                femalePersonData.setWeight(Double.parseDouble(scanner.nextLine()));

                System.out.println("Altura(em cm): ");
                femalePersonData.setHeight(Double.parseDouble(scanner.nextLine()));

                System.out.println("Cintura(em cm): ");
                femalePersonData.setWaist(Double.parseDouble(scanner.nextLine()));

                System.out.println("Pescoco(em cm): ");
                femalePersonData.setNeck(Double.parseDouble(scanner.nextLine()));

                System.out.println("Quadril(em cm): ");
                femalePersonData.setHip(Double.parseDouble(scanner.nextLine()));

                printFemaleFatPercExpected();
                Double femaleFatPercDesired = Double.parseDouble(scanner.nextLine());
                CorporalMeasures fcm = new FemaleCorporalMeasures(femalePersonData);
                fcm.setExpectedFatPercentage(femaleFatPercDesired);

                printIdealWeightResults(femalePersonData, fcm);


            } else {
                PersonData personData = new PersonData();

                System.out.println("Peso(em Kgs): ");
                personData.setWeight(Double.parseDouble(scanner.nextLine()));

                System.out.println("Altura(em cm): ");
                personData.setHeight(Double.parseDouble(scanner.nextLine()));

                System.out.println("Cintura(em cm): ");
                personData.setWaist(Double.parseDouble(scanner.nextLine()));

                System.out.println("Pescoco(em cm): ");
                personData.setNeck(Double.parseDouble(scanner.nextLine()));

                printMaleFatPercExpected();
                Double fatPercDesired = Double.parseDouble(scanner.nextLine());
                CorporalMeasures mcm = new MaleCorporalMeasures(personData);
                mcm.setExpectedFatPercentage(fatPercDesired);

                printIdealWeightResults(personData, mcm);
            }
        } else if(mainMenu == 2) {

            System.out.println("Idade: ");
            PersonData personData = new PersonData();
            personData.setAge(Integer.parseInt(scanner.nextLine()));

            System.out.println("Peso(em Kgs): ");
            personData.setWeight(Double.parseDouble(scanner.nextLine()));

            System.out.println("Altura(em cm): ");
            personData.setHeight(Double.parseDouble(scanner.nextLine()));

            HashMap<Integer, Double> PHYSICAL_ACTIVITY_LEVEL = new HashMap<>();
            PHYSICAL_ACTIVITY_LEVEL.put(1, 1.2);
            PHYSICAL_ACTIVITY_LEVEL.put(2, 1.375);
            PHYSICAL_ACTIVITY_LEVEL.put(3, 1.55);
            PHYSICAL_ACTIVITY_LEVEL.put(4, 1.725);
            PHYSICAL_ACTIVITY_LEVEL.put(5, 1.9);

            printPhysicalActivityLevelMenu();
            Integer levelChosen = Integer.parseInt(scanner.nextLine());
            personData.setPhysicalActivityLevel(PHYSICAL_ACTIVITY_LEVEL.get(levelChosen));

            BasalCaloricConsume gcb = new BasalCaloricConsume(personData);

            System.out.println("Gasto Calorico Basal: "+new DecimalFormat("#,###.00").format(gcb.getBasalCaloricConsume()));
            System.out.println("Gasto Calorico Basal para dieta emagrecimento: "+new DecimalFormat("#,###.00").format(gcb.getBasalCaloricConsumeForWeightLoss()));
            System.out.println("Gasto Calorico Basal para hipertrofia: "+new DecimalFormat("#,###.00").format(gcb.getBasalCaloricConsumeForIncreaseMuscleMass()));
            System.out.println();

        }
        scanner.close();
    }

    private static void printPhysicalActivityLevelMenu() {
        System.out.println("Nivel Atividade Fisica:");
        System.out.println("1 - Sedentario (praticamente nenhum exercicio)");
        System.out.println("2 - Levemente ativo (exercicio leve/esportes 1-3 dias/semana)");
        System.out.println("3 - Moderadamente ativo (exercicio moderado/esportes 3-5 dias/semana)");
        System.out.println("4 - Bastante ativo (exercicio forte/esportes 6-7 dias/semana)");
        System.out.println("5 - Extra ativo (trabalho fisico ou treinamento muito intenso)");
        System.out.println();
    }

    private static void printIdealWeightResults(PersonData personData, CorporalMeasures mcm) {
        System.out.println(personData.toString());
        System.out.println();
        System.out.println("========RESULTADO============");
        System.out.println("Massa Gorda(%): " + new DecimalFormat("#,###.00").format(mcm.getFatPercentage()));
        System.out.println("Massa Magra(%): " + new DecimalFormat("#,###.00").format(mcm.getMusclePercentage()));
        System.out.println();
        System.out.println("Massa Gorda(Kg): " + new DecimalFormat("#,###.00").format(mcm.getMassaGordaKgs()));
        System.out.println("Massa Magra(Kg): " + new DecimalFormat("#,###.00").format(mcm.getMassaMagraKgs()));
        System.out.println();
        System.out.println("Peso Ideal(Kg): " + new DecimalFormat("#,###.00").format(mcm.getPesoIdeal()));
        System.out.println("Preciso Perder(Kg): " + new DecimalFormat("#,###.00").format(personData.getWeight()-mcm.getPesoIdeal()));
        System.out.println();
    }

    private static void printFemaleFatPercExpected() {
        System.out.println("% gordura corporal	\tMulheres");
        System.out.println("Nivel de Competicao\t\t9%-12%");
        System.out.println("Bastante em forma	\t<= 15%");
        System.out.println("Em forma			\t16%-20%");
        System.out.println("Media 				\t21%-25%");
        System.out.println("Abaixo da media		\t26%-30%");
        System.out.println("Precisa de atencao	\t31%-40%+");
        System.out.println();
        System.out.println("% de gordura corporal desejada:");
    }

    private static void printMaleFatPercExpected() {
        System.out.println("% gordura corporal\t\tHomens");
        System.out.println("Nivel de Competicao \t3%-6%");
        System.out.println("Bastante em forma	\t<= 9%");
        System.out.println("Em forma			\t10%-14%");
        System.out.println("Media 				\t15%-19%");
        System.out.println("Abaixo da media		\t20%-25%");
        System.out.println("Precisa de atencao 	\t26%-30%+");
        System.out.println();
        System.out.println("% de gordura corporal desejada:");
    }
}