package motoresdebusqueda.dogpile.pageobjets;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class PaginaResultados extends PageObject {

    public static final String TITULO_RESULTADO=".web-bing__title";//Todos
    public static final String TITULO_RESULTADO_CON_TEXTO = "//a[contains(@class,'web-bing__title') and contains(.,'{0}')]";
    public static final String DESCRIPCION_DE_TEXTO = "..//span[@class='web-bing__description']";

    @FindBy(css = ".web-bing__title")
    List<WebElementFacade> lista;

    public List<String> obtenerResultados() {
        return findAll(TITULO_RESULTADO)
                .stream()
                .map(element->element.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public void seleccionarResultados(String valor) throws Exception {
        //Object o=findAll(TITULO_RESULTADO).stream().map(e -> { if (e.getText().equalsIgnoreCase(valor)) e.click();return null;});
        if(findAll(TITULO_RESULTADO).stream().map(e -> { if (e.getText().equalsIgnoreCase(valor)) e.click();return null;}).equals(null)) throw new Exception("Producto :"+valor+" no existe");

    }

    public String obtenerDescripcionDeBodyTitulo(String titulo) {
        //return findBy("//a[contains(@class,'web-bing__title')][contains(text(),'{0}')]",titulo)
        //return findBy("//a[contains(@class,'web-bing__title') and contains(.,'{0}')]/../span[@class='web-bing__description']",titulo);
        return findBy(TITULO_RESULTADO_CON_TEXTO,titulo)
                .then().findBy(DESCRIPCION_DE_TEXTO)
                .then().getText();
    }
}
