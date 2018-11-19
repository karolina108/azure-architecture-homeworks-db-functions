package pro.koliber.azure.ambient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class AmbientMetricGenerator {

    public static AmbientMetric generateMetric(){

        AmbientMetric ambientMetric = new AmbientMetric();

        ambientMetric
                .setDeviceId(generateDeviceId());

        ambientMetric
                .setMetricDatetime(generateMetricDateTime());

        ambientMetric
                .setTemperature(generateTemperature());

        ambientMetric
                .setPressure(generatePressure());

        ambientMetric
                .setHumidity(generateHumidity());

        return ambientMetric;
    }

    private static String generateDeviceId() {
        return "Device_No_" + ThreadLocalRandom.current()
                .nextInt(0, 20);
    }

    private static String  generateMetricDateTime() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    private static String generateTemperature(){
        return String.valueOf(ThreadLocalRandom.current().nextDouble(0d, 70d));
    }

    private static String generatePressure(){
        return String.valueOf(ThreadLocalRandom.current().nextDouble(980d, 1025d));
    }

    private static String generateHumidity(){
        return String.valueOf(ThreadLocalRandom.current().nextDouble(0d, 99d));
    }

}
