package plutoproject.solar.server

import kotlinx.coroutines.*
import org.slf4j.LoggerFactory

class SolarServer {
    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val logger = LoggerFactory.getLogger("SolarServer")

    suspend fun startAndWait() {
        logger.info("Server started")
        coroutineScope.coroutineContext[Job]?.join()
    }

    suspend fun shutdown() {
        logger.info("Shutting down...")
        coroutineScope.coroutineContext[Job]?.cancelAndJoin()
    }
}
