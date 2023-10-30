/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.*;
import entidades.Microciclo;
import entidades.VolumenMedioFisico;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MicrocicloDAO {

    private final MongoCollection<Document> collection;

    public MicrocicloDAO(MongoDatabase database) {
        this.collection = database.getCollection("microciclos");
    }

    public void insertMicrociclo(Microciclo microciclo) {
        Document document = new Document("_id", microciclo.getId())
            .append("inicio", microciclo.getInicio())
            .append("fin", microciclo.getFin())
            .append("acento", microciclo.getAcento())
            .append("volumenesMediosFisicos", microciclo.getVolumenesMediosFisicos())
            .append("competenciaPreparativa", microciclo.isCompetenciaPreparativa());

        collection.insertOne(document);
    }

    public Microciclo findMicrocicloById(ObjectId id) {
        Document document = collection.find(new Document("_id", id)).first();
        if (document != null) {
            return documentToMicrociclo(document);
        }
        return null;
    }

    public void updateMicrociclo(Microciclo microciclo) {
        Document document = new Document("_id", microciclo.getId())
            .append("inicio", microciclo.getInicio())
            .append("fin", microciclo.getFin())
            .append("acento", microciclo.getAcento())
            .append("volumenesMediosFisicos", microciclo.getVolumenesMediosFisicos())
            .append("competenciaPreparativa", microciclo.isCompetenciaPreparativa());

        collection.replaceOne(new Document("_id", microciclo.getId()), document);
    }

    public void deleteMicrociclo(ObjectId id) {
        collection.deleteOne(new Document("_id", id));
    }

    private Microciclo documentToMicrociclo(Document document) {
        ObjectId id = document.getObjectId("_id");
        Date inicio = document.getDate("inicio");
        Date fin = document.getDate("fin");
        int acento = document.getInteger("acento");
        List<VolumenMedioFisico> volumenesMediosFisicos = (List<VolumenMedioFisico>) document.get("volumenesMediosFisicos");
        boolean competenciaPreparativa = document.getBoolean("competenciaPreparativa");

        return new Microciclo(id, inicio, fin, acento, volumenesMediosFisicos, competenciaPreparativa);
    }
}
