package plutoproject.solar.server

import kotlinx.coroutines.CoroutineScope
import org.slf4j.LoggerFactory


class SolarServer(private val coroutineScope: CoroutineScope) {
    private val logger = LoggerFactory.getLogger("SolarServer")

    fun start() {
        logger.info("Server started")
    }

    fun shutdown() {
        logger.info("Shutting down...")
    }
}
