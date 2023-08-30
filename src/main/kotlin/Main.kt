import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import io.swagger.oas.inflector.examples.ExampleBuilder
import io.swagger.oas.inflector.processors.JsonNodeExampleSerializer
import io.swagger.util.Json
import io.swagger.v3.parser.OpenAPIV3Parser


fun main(args: Array<String>) {
    println("Hello World!\n")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")

    val openapi = OpenAPIV3Parser().read("openapi.yaml")
    val schemas = openapi.components.schemas

//    println("top-level schemas: ")
//    schemas.keys.forEach { println(it) }

    schemas.keys.forEach {
//        val schemaname = "Order"
        val model = schemas[it]
        val exampleModel = ExampleBuilder.fromSchema(model, schemas)
        val simpleModule = SimpleModule().addSerializer(JsonNodeExampleSerializer())
        Json.mapper().registerModule(simpleModule)
        val jsonExample: String = Json.pretty(exampleModel)
        println("example $it: $jsonExample")
    }


}