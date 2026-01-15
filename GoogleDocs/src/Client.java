import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface DocumentElement{
    public abstract String render();
}
class TextElement implements DocumentElement{
    private String text;
    public TextElement(String text){
        this.text = text;
    }
    @Override
    public String render(){
        return text;
    }
}
class ImageElement implements DocumentElement{
    private String imageURL;
    public ImageElement(String imageURL){
        this.imageURL = imageURL;
    }
    @Override
    public String render(){
        return imageURL;
    }
}
class Document {
    List<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    public String render() {
        StringBuilder result = new StringBuilder();
        for (DocumentElement element : documentElements) {
            result.append(element.render());
        }
        return result.toString();
    }
}
interface Persistence{
    void save(String data);
}
class FileStorage implements Persistence{
    @Override
    public void save(String data) {
        try{
            FileWriter fileWriter = new FileWriter("doc.txt");
            fileWriter.write(data);
            fileWriter.close();
            System.out.println("Document saved to doc.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}
class DBStorage implements Persistence{
    @Override
    public void save(String data) {
        // Save to DB
    }
}
class DocumentEditor{
    private Document doc;
    private Persistence storage;
    public DocumentEditor(Document doc, Persistence storage){
        this.doc = doc;
        this.storage = storage;
    }
    public void addText(String text){
        doc.addElement(new TextElement(text));
    }
    public void addImageURL(String imageURL){
        doc.addElement(new ImageElement(imageURL));
    }
    String renderedDocument = "";
    public String renderDocument(){
        if(renderedDocument.isEmpty()){
            renderedDocument = doc.render();
        }
        return renderedDocument;
    }
    public void saveDoc(){
        storage.save(renderedDocument);
    }
}

public class Client {
    public static void main(String[] args) {
        Document document = new Document();
        Persistence persistence = new FileStorage();
        DocumentEditor editor = new DocumentEditor(document, persistence);
        editor.addText("Hello, world!"+"\n");
        editor.addText("This is a real-world document editor example."+"\n");
        editor.addImageURL("picture.jpg");

        // Render and display the final document.
        System.out.println(editor.renderDocument());

        editor.saveDoc();
    }
}