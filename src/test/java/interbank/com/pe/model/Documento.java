package interbank.com.pe.model;

import interbank.com.pe.model.documents.DocumentoBuilder;

public class Documento {

    private final String document;

    public Documento(DocumentoBuilder builder) {
        this.document = builder.getDocument();
    }

    public String getDocument() {
        return document;
    }

}
