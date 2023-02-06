package practice.hospital;

import java.util.Arrays;

public class Hospital {


    public static float[] generatePatientsTemperatures(int patientsCount) {
        double minTemp = 32;
        double maxTemp = 40;
        int[] patients = new int[patientsCount];
        float[] patientsTemp = new float[patientsCount];

        for (int i = 0; i < patients.length; i++) {
            double randomPatientsTemp = (Math.random() * Math.round(maxTemp - minTemp) + minTemp);
            patientsTemp[i] = (float) randomPatientsTemp;
        }
        return patientsTemp;
    }

    public static String getReport(float[] temperatureData) {

        float[] patientsTemp = Hospital.generatePatientsTemperatures(30);
        double average = 0;

        if (patientsTemp.length > 0) {
            double sum = 0;

            for (int i = 0; i < patientsTemp.length - 1; i++) {
                sum += patientsTemp[i];
            }
            average = sum / patientsTemp.length;
        }
        String averageTemp  = String.format("%.2f",average);


        int patientsHealth = 0;
        for (int i = 0; i < patientsTemp.length - 1; i++) {
            float temp = patientsTemp[i];
            if (36.2f <= temp || temp <= 36.9f) {
                patientsHealth++;
            }
        }

        String report =
            "Температуры пациентов: " + Arrays.toString(patientsTemp) +
            "\nСредняя температура: " + averageTemp +
            "\nКоличество здоровых: " + patientsHealth;

        return report;
    }
}
