package plutoproject.solar.server

import kotlinx.coroutines.*

private lateinit var server: SolarServer
private lateinit var coroutineScope: CoroutineScope

fun main(): Unit = runBlocking {
    coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    server = SolarServer(coroutineScope)

    Runtime.getRuntime().addShutdownHook(Thread {
        runBlocking {
            server.shutdown()
            coroutineScope.coroutineContext[Job]?.cancelAndJoin()
        }
    })

    server.start()
    coroutineScope.coroutineContext[Job]?.join()
}
