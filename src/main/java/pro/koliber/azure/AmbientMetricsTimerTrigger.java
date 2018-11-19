package pro.koliber.azure;

import java.time.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import pro.koliber.azure.ambient.AmbientMetric;
import pro.koliber.azure.ambient.AmbientMetricGenerator;

public class AmbientMetricsTimerTrigger {

    @FunctionName("AmbientMetricsTimerTrigger")
    @QueueOutput(name = "message", queueName = "cs-arch-db-hmk-queue-001", connection = "csarchdbhmkstorage_STORAGE")
    public AmbientMetric run(
        @TimerTrigger(name = "timerInfo", schedule = "0 */1 * * * *") String timerInfo,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Timer trigger function executed at: " + LocalDateTime.now());

        AmbientMetric ambientMetric = AmbientMetricGenerator.generateMetric();

        context.getLogger().info("Generated ambient metric " + ambientMetric);

        return ambientMetric;
    }
}