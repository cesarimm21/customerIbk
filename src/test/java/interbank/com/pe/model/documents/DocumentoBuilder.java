package interbank.com.pe.model.documents;

import interbank.com.pe.exceptions.DocumentoException;
import interbank.com.pe.model.Documento;
import interbank.com.pe.utils.builders.Builder;

public class DocumentoBuilder implements Builder<Documento> {

    private final String document;

    public DocumentoBuilder(String document) {
        this.document = document;
    }

    public static DocumentoBuilder document(String document) {
        return new DocumentoBuilder(document);
    }

    public String getDocument() {
        return document;
    }

    @Override
    public Documento build() throws DocumentoException {
        return new Documento(this);
    }
}
