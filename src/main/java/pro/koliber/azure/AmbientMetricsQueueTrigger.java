package pro.koliber.azure;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Azure Storage Queue trigger.
 */
public class AmbientMetricsQueueTrigger {
    /**
     * This function will be invoked when a new message is received at the specified path. The message contents are provided as input to this function.
     */
    @FunctionName("AmbientMetricsQueueTrigger")
    public void run(
        @QueueTrigger(name = "message", queueName = "cs-arch-db-hmk-queue-001", connection = "csarchdbhmkstorage_STORAGE") String message,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Queue trigger function processed a message: " + message);
    }
}
