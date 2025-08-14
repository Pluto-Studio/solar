@file:OptIn(ExperimentalSerializationApi::class)

package plutoproject.solar.server

import com.typesafe.config.ConfigFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.hocon.Hocon
import kotlinx.serialization.hocon.decodeFromConfig
import java.io.File

private val hocon = Hocon { useConfigNamingConvention = true }
internal val config = loadConfig()

internal fun loadConfig(): ServerConfig {
    val file = File("config.conf")
    if (!file.exists()) {
        return ServerConfig()
    }
    val config = ConfigFactory.parseFile(file).resolve()
    return runCatching {
        hocon.decodeFromConfig<ServerConfig>(config)
    }.onFailure {
        logger.error("Error occurred while loading configuration, fallback to default values", it)
    }.getOrNull() ?: ServerConfig()
}
