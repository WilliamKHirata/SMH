package SMHxml1;


import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;


public class SAXProduto extends DefaultHandler {

    private int nprodutos = 0;
    private boolean produto = false;
    private boolean atualiza = false;
    private int preco = -1;
    private int codigo = 0;

    public SAXProduto() {
        System.out.println("Start document");
    }

    @Override
    public void startElement(String uri, String localName, String rawName,
            Attributes attributes) {
        System.out.println("StartElement");
        if (localName.equals("produto")) {
            this.nprodutos++;
            this.produto = true;
            int aux = Integer.parseInt(attributes.getValue("preco"));
            if (aux < this.preco || this.preco == -1) {
                this.atualiza = true;
                this.preco = aux;
            }
        }
    }

    @Override
    public void characters(char characters[], int start, int length) {
        System.out.println("Characters");
        if (this.atualiza && this.produto) {
            this.codigo = Integer.parseInt(new String(characters, start, length));
            this.atualiza = this.produto = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String rawName) {
        System.out.println("EndElement");
        if (localName.equals("produtos")) {
            printResult();
        }

    }

    public void printResult() {
        System.out.println("Existem " + this.nprodutos + " produtos em produtos.xml");
        System.out.println("O produto de menor valor vale " + this.preco + " e tem codigo " + this.codigo);
    }

}
