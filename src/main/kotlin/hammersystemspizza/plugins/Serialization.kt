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
    Pizza("Аррива", "Колбаски, перец чили, оригано, острый соус", 400, "https://github.com/KhabiKd/imagesRepo/blob/main/pepper_and_sausage.png"),
    Pizza("Микс", "Салями, желтый перец, помидоры, увеличнное количество сыра", 350, "https://github.com/KhabiKd/imagesRepo/blob/main/mix.png"),
    Pizza("Грибы и помидоры", "Шампиньоны, моцарелла, помидоры в увеличенном количестве", 600, "https://github.com/KhabiKd/imagesRepo/blob/main/mashroom_and_tomato.png"),
    Pizza("Аррива", "Колбаски, перец чили, оригано, острый соус", 400, "https://github.com/KhabiKd/imagesRepo/blob/main/pepper_and_sausage.png"),
    Pizza("Микс", "Салями, желтый перец, помидоры, увеличнное количество сыра", 350, "https://github.com/KhabiKd/imagesRepo/blob/main/mix.png"),
    Pizza("Грибы и помидоры", "Шампиньоны, моцарелла, помидоры в увеличенном количестве", 600, "https://github.com/KhabiKd/imagesRepo/blob/main/mashroom_and_tomato.png"),
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
