package practice.hospital;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        double minTemp = 32;
        double maxTemp = 40;
        int[] patients = new int[patientsCount];
        float patientsTemp = 0;

        for (int i = 0; i < patients.length; i++) {
            double randomPatientsTemp = ((Math.random() * Math.round((maxTemp - minTemp) + 1)) + minTemp);
            patients[i] = (int) randomPatientsTemp;
            patientsTemp = patientsTemp + patients[i];
        }
        return new float[(int) patientsTemp];
    }

    public static String getReport(float[] temperatureData) {

        String report =
            "Температуры пациентов: " + 1 +
            "\nСредняя температура: " + 0 +
            "\nКоличество здоровых: " + 0;

        return report;
    }
}
