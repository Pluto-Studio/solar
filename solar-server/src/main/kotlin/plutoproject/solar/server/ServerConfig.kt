package plutoproject.solar.server

import kotlinx.serialization.Serializable

@Serializable
data class ServerConfig(
    val bind: String = "0.0.0.0",
    val port: Int = 6543,
)
