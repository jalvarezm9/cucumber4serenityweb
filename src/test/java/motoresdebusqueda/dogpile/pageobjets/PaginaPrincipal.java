package motoresdebusqueda.dogpile.pageobjets;
import net.serenitybdd.core.pages.PageObject;

public class PaginaPrincipal extends PageObject {

    public static final String CONSTANTE_1 = "#q";
    public static final String CONSTANTE_2 = ".search-form-home__button";

    public void buscarPalabraClave(String palabra_clave) {
        findBy(CONSTANTE_1).type(palabra_clave);
    }

    public void seleccionarBuscar() {
        findBy(CONSTANTE_2).click();
    }
}
