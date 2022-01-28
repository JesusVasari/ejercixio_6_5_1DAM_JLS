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

    val gestorDeLibros = gestionLibrosIU(portatil)
    gestorDeLibros.preguntarPorUnLibro()
    gestorDeLibros.mostrarInfoDeUnLibro()

}

interface Comun {
    fun readXml(pathName: String): Document {
        val xmlFile = File(pathName)
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile)

    }

    fun existeLibro()
    fun infoLibro()
    fun existeLibro(idLibro: String): Boolean
    fun infoLibro(idLibro: String): Map<String, Any>
}
class gestionLibrosIU(cargador: String, override val cat: Comun) : gestionLibros(cargador) {
    override fun existeLibro() {
        TODO("Not yet implemented")
    }

    override fun existeLibro(idLibro: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun infoLibro() {
        TODO("Not yet implemented")
    }

    override fun infoLibro(idLibro: String): Map<String, Any> {
        TODO("Not yet implemented")
    }

}

abstract class gestionLibros(cargador:String) : Comun
{

    abstract val cat : Comun


    fun preguntarPorUnLibro() {
        println("Introduzca un ID: ")
        var idLibro = readln()
        if (cat.existeLibro(idLibro))
            println("El libro $idLibro existe!")
        else
            println("El libro $idLibro NO existe!")
    }

    fun mostrarInfoDeUnLibro()
    {
        println("Introduzca un ID: ")
        var idLibro = readln()
        var infoLibro = cat.infoLibro(idLibro)
        if (!infoLibro.isEmpty())
            println("La información sobre es la siguiente\n$infoLibro")
        else
            println("No se encontró información sobre el libro")
    }

}