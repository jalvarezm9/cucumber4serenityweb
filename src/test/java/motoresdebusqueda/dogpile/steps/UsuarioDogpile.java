package motoresdebusqueda.dogpile.steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import motoresdebusqueda.dogpile.pageobjets.PaginaPrincipal;
import motoresdebusqueda.dogpile.pageobjets.PaginaResultados;

import net.thucydides.core.annotations.Steps;

import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class UsuarioDogpile {

    @Steps
    PaginaPrincipal paginaPrincipal;

    @Steps
    PaginaResultados paginaResultados;

    @Dado("que el usuario entra en la pagina Dog")
    public void irgresar_a_dogpile() {
        paginaPrincipal.setDefaultBaseUrl("https://www.dogpile.com/");
        paginaPrincipal.open();
    }

    @Cuando("el usuario inicia una busqueda de: (.*)")
    public void busca_por_palabra_clave(String palabra_clave) {
        paginaPrincipal.buscarPalabraClave(palabra_clave);
        paginaPrincipal.seleccionarBuscar();
    }

    @Entonces("el usuario deberia ver resultados que contentan la palabra: (.*)")
    public void deberia_ver_resultados_con_palabra(String palabra_esperada) {
        List<String> resultados = paginaResultados.obtenerResultados();
        resultados.replaceAll(String::toLowerCase);
        for (String elemento : resultados) {
            System.out.println(elemento);
        }

        assertThat(resultados, Matchers.everyItem(containsString(palabra_esperada)));
    }


    @Entonces("el usuario deberia ver el texto esperado: (.*) en el resultado del titulo (.*)")
    public void deberia_encontrar_resultado_de_titulo_con_texto_correcto(String resultadoEsperada, String titulo) {
        String resultadoOptenido=paginaResultados.obtenerDescripcionDeBodyTitulo(titulo);
        System.out.println(resultadoOptenido);
        System.out.println(resultadoEsperada);

        assertThat(resultadoOptenido,containsString(resultadoEsperada));
    }
}