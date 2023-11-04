package hammersystemspizza.plugins

import com.fasterxml.jackson.databind.*
import com.google.gson.annotations.SerializedName
import io.ktor.serialization.gson.*
import io.ktor.serialization.jackson.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class Pizza(val name: String, val description: String, val price: Int, val img_src: String)

val pizzas = listOf(
    Pizza("Аррива", "Колбаски, перец чили, оригано, острый соус", 400, "https://drive.google.com/file/d/1n-XhtaIU0EJykausdNLCZ0zSgir9odSt/view?usp=sharing"),
    Pizza("Микс", "Салями, желтый перец, помидоры, увеличнное количество сыра", 350, "https://drive.google.com/file/d/1En2BccGQ-3BSEtB8WE2NFeD9RrgY3zxi/view?usp=sharing"),
    Pizza("Грибы и помидоры", "Шампиньоны, моцарелла, помидоры в увеличенном количестве", 600, "https://drive.google.com/file/d/1ciSI8tkOVozZtvF5rTeXWl0sSITMNA4b/view?usp=sharing"),
    Pizza("Аррива", "Колбаски, перец чили, оригано, острый соус", 400, "https://drive.google.com/file/d/1n-XhtaIU0EJykausdNLCZ0zSgir9odSt/view?usp=sharing"),
    Pizza("Микс", "Салями, желтый перец, помидоры, увеличнное количество сыра", 350, "https://drive.google.com/file/d/1En2BccGQ-3BSEtB8WE2NFeD9RrgY3zxi/view?usp=sharing"),
    Pizza("Грибы и помидоры", "Шампиньоны, моцарелла, помидоры в увеличенном количестве", 600, "https://drive.google.com/file/d/1ciSI8tkOVozZtvF5rTeXWl0sSITMNA4b/view?usp=sharing"),
)

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
        gson {
            }
        jackson {
                enable(SerializationFeature.INDENT_OUTPUT)
            }
    }
    routing {

        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
        get("/json/gson") {
                call.respond(mapOf("hello" to "world"))
            }
        get("/json/jackson") {
                call.respond(mapOf("hello" to "world"))
            }
    }
}
