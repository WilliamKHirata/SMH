package SMHxml1;

import org.apache.xerces.parsers.SAXParser;

/**
 *
 * @author 1130847
 */
public class Main {

    public static void main(String[] args) {
        try {
            SAXProduto SAXHandler = new SAXProduto();
            SAXParser parser = new SAXParser();
            parser.setContentHandler(SAXHandler);
            parser.setErrorHandler(SAXHandler);
            parser.parse("c:\\temp\\produtos.xml");
            System.out.println("Testando");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
