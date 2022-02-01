import java.util.logging.Level
import java.util.logging.LogManager

internal val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }
internal fun i(tag: String, msg: String) {
    l.info("[$tag] - $msg")
}


fun main() {
    val portatil = "/home/edu/IdeaProjects/IESRA-DAM-Prog/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"
    //var casa = "/home/usuario/Documentos/workspace/IdeaProjects/IESRA-DAM/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"
    
    val gestionLibros = gestionLibros(portatil)
   gestionLibros.mostrarInfoDeUnLibro()
    gestionLibros.preguntarPorUnLibro()

}

interface AccesoCatalogo {

    fun existeLibro(idLibro: String): Boolean
    fun infoLibro(idLibro: String): Map<String, Any>
}



interface gestor {

    fun preguntarLibro():String{
        val leer = readln()?.toString()
        return leer
    }
    fun sacarPantalla():String {
       return "el libro es: "
    }
}



open class gestionLibros(open val cat: AccesoCatalogo, open val gestor: gestor) {

    fun preguntarPorUnLibro() {
        println("Introduzca un ID: ")
        val idLibro = gestor.preguntarLibro()

        if (cat.existeLibro(idLibro))
            gestor.sacarPantalla()

        else
           gestor.sacarPantalla()
    }

    fun mostrarInfoDeUnLibro() {
        println("Introduzca un ID: ")
        val idLibro = gestor.preguntarLibro()
        var infoLibro = cat.infoLibro(idLibro)
       gestor.sacarPantalla()
    }

}
