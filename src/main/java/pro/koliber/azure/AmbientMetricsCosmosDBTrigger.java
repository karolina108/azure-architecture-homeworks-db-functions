package pro.koliber.azure;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import pro.koliber.azure.ambient.AmbientMetric;

import java.util.Arrays;

public class AmbientMetricsCosmosDBTrigger {

    @FunctionName("AmbientMetricsCosmosDBTrigger")
    public void run(
        @CosmosDBTrigger(
            name = "items",
            databaseName = "cs-arch-db-hmk-cosmos-db",
            collectionName = "ambient-metrics",
            leaseCollectionName="leases",
            connectionStringSetting = "cs-arch-db-hmk-cosmos-acc_DOCUMENTDB",
            createLeaseCollectionIfNotExists = false
        )
        Object[] items,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Cosmos DB trigger function executed.");

        Arrays.stream(items).forEach(item -> {
            context.getLogger().info("New metric added to Cosmos DB " + item);
        });

    }
}
