package plutoproject.solar.server

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory

private lateinit var server: SolarServer
internal val logger = LoggerFactory.getLogger("SolarServer")

@OptIn(DelicateCoroutinesApi::class)
fun main(): Unit = runBlocking {
    server = SolarServer()

    Runtime.getRuntime().addShutdownHook(Thread {
        runBlocking {
            server.shutdown()
        }
    })

    server.startAndWait()
    Dispatchers.shutdown()
}
