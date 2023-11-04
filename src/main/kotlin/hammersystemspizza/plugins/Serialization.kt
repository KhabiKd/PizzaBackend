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
    Pizza("Аррива", "Колбаски, перец чили, оригано, острый соус", 400, "https://firebasestorage.googleapis.com/v0/b/pizza-99486.appspot.com/o/pepper_and_sausage.png?alt=media&token=567106f3-7a70-47e1-9360-c8dbe8b92b13"),
    Pizza("Микс", "Салями, желтый перец, помидоры, увеличнное количество сыра", 350, "https://firebasestorage.googleapis.com/v0/b/pizza-99486.appspot.com/o/mix.png?alt=media&token=836b75e6-e8e4-45f1-b4fa-45fd56e88c79"),
    Pizza("Грибы и помидоры", "Шампиньоны, моцарелла, помидоры в увеличенном количестве", 600, "https://firebasestorage.googleapis.com/v0/b/pizza-99486.appspot.com/o/mashroom_and_tomato.png?alt=media&token=fa354961-0dc9-4e90-a8bb-d24e9090396f"),
    Pizza("Аррива", "Колбаски, перец чили, оригано, острый соус", 400, "https://firebasestorage.googleapis.com/v0/b/pizza-99486.appspot.com/o/pepper_and_sausage.png?alt=media&token=567106f3-7a70-47e1-9360-c8dbe8b92b13"),
    Pizza("Микс", "Салями, желтый перец, помидоры, увеличнное количество сыра", 350, "https://firebasestorage.googleapis.com/v0/b/pizza-99486.appspot.com/o/mix.png?alt=media&token=836b75e6-e8e4-45f1-b4fa-45fd56e88c79"),
    Pizza("Грибы и помидоры", "Шампиньоны, моцарелла, помидоры в увеличенном количестве", 600, "https://firebasestorage.googleapis.com/v0/b/pizza-99486.appspot.com/o/mashroom_and_tomato.png?alt=media&token=fa354961-0dc9-4e90-a8bb-d24e9090396f"),
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
