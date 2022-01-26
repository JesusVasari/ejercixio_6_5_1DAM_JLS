import java.util.logging.Level
import java.util.logging.LogManager

internal val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }
internal fun i(tag: String, msg: String) {
    l.info("[$tag] - $msg")
}


fun main() {
    var portatil = "/home/edu/IdeaProjects/IESRA-DAM-Prog/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"
    //var casa = "/home/usuario/Documentos/workspace/IdeaProjects/IESRA-DAM/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"

    val gestorDeLibros = GestionLibros(portatil)
    gestorDeLibros.preguntarPorUnLibro()
    gestorDeLibros.mostrarInfoDeUnLibro()

}

class GestionLibrosIU1() : GestionLibros() {

    override var xml = CatalogoLibrosXML
    fun preguntarPorUnLibro() {
        println("Introduzca un ID: ")
        var idLibro = readln()


    }

}

class GestionLibrosUI2() : GestionLibros() {
    println("Introduzca un ID: ")
    var idLibro = readln()
    var infoLibro = infoLibro(idLibro)


}
open class GestionLibros() {


    open var xml= CatalogoLibrosXML
    var json = CatalogoLibrosJSON


    init{
        xml = CatalogoLibrosXML
        json = CatalogoLibrosJSON
    }



}