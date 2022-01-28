import org.w3c.dom.Document
import java.io.File
import java.util.logging.Level
import java.util.logging.LogManager
import javax.xml.parsers.DocumentBuilderFactory

internal val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }
internal fun i(tag: String, msg: String) {
    l.info("[$tag] - $msg")
}


fun main() {
    var portatil = "/home/edu/IdeaProjects/IESRA-DAM-Prog/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"
    //var casa = "/home/usuario/Documentos/workspace/IdeaProjects/IESRA-DAM/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"

    val gestorDeLibros = gestionLibros(portatil)
    gestorDeLibros.preguntarPorUnLibro()
    gestorDeLibros.mostrarInfoDeUnLibro()

}

interface AccesoCatalogo {

    fun existeLibro(idLibro: String): Boolean
    fun infoLibro(idLibro: String): Map<String, Any>
}

class gestionLibrosIU(val leer: gestorLeer, val print: gestorPrint) {



}

interface gestorLeer {

    fun preguntarLibro(){
        var leer = readln()
    }

}

interface gestorPrint {

        var leer : gestorLeer

    }
}

open class gestionLibros(open val cat: AccesoCatalogo) {

    fun preguntarPorUnLibro() {
        println("Introduzca un ID: ")
        var idLibro = readln()

        if (cat.existeLibro(idLibro))
            println("El libro $idLibro existe!")
        else
            println("El libro $idLibro NO existe!")
    }

    fun mostrarInfoDeUnLibro() {
        println("Introduzca un ID: ")
        var idLibro = readln()
        var infoLibro = cat.infoLibro(idLibro)
        if (!infoLibro.isEmpty())
            println("La información sobre es la siguiente\n$infoLibro")
        else
            println("No se encontró información sobre el libro")
    }

}