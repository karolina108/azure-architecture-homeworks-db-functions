package pro.koliber.azure;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import pro.koliber.azure.ambient.AmbientMetric;

public class AmbientMetricsQueueTrigger {

    @FunctionName("AmbientMetricsQueueTrigger")
    @CosmosDBOutput(name = "items",
            databaseName = "cs-arch-db-hmk-cosmos-db",
            collectionName = "ambient-metrics",
            connectionStringSetting = "cs-arch-db-hmk-cosmos-acc_DOCUMENTDB")
    public AmbientMetric run(
        @QueueTrigger(name = "message", queueName = "cs-arch-db-hmk-queue-001",
                connection = "csarchdbhmkstorage_STORAGE") AmbientMetric message,
        final ExecutionContext context
    ) {
        context.getLogger().info("Ambient Metrics First Queue trigger function processed a message: " + message.toString());

        return message;
    }
}
