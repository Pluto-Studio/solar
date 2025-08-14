package plutoproject.solar.server

import kotlinx.coroutines.*

class SolarServer {
    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    suspend fun startAndWait() {
        logger.info("Server started, listening on ${config.bind}:${config.port}")
        coroutineScope.coroutineContext[Job]?.join()
    }

    suspend fun shutdown() {
        logger.info("Shutting down...")
        coroutineScope.coroutineContext[Job]?.cancelAndJoin()
    }
}
