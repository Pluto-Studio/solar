package plutoproject.solar.server

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

private lateinit var server: SolarServer

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
