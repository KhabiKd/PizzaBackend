package hammersystemspizza.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/pizzas") {
            call.respond(pizzas)
        }
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
