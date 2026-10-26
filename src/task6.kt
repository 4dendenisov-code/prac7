package task6

data class ServerConfig(var host: String = "localhost", var port: Int = 8080, var ssl: Boolean = false, var retries: Int = 3)

fun serverConfig(block: ServerConfig.() -> Unit): ServerConfig {
    return ServerConfig().apply(block).also {
        println("Сервер настроен: host=${it.host}, port=${it.port}")
    }
}

fun main() {
    val config = serverConfig {
        host = "api.example.com"
        port = 443
        ssl = true
        retries = 5
    }
    println("Итог: $config")
}