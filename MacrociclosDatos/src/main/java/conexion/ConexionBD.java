/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author luisg
 */
public class ConexionBD {
    
    private static final String HOST = "127.0.0.1";
    private static final int PUERTO = 27017;
    private static final String BASE_DATOS = "macrociclosItson";
    private static MongoDatabase baseDatos;
    
    public static MongoDatabase crearConexion() {
        if (baseDatos != null) {
            return baseDatos;
        }
        
        try {
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
            ConnectionString cadenaConexion = new ConnectionString("mongodb://" + HOST + "/" + PUERTO);
            
            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(cadenaConexion)
                    .codecRegistry(codecRegistry)
                    .build();
            
            MongoClient clienteMongo = MongoClients.create(clientSettings);
            baseDatos = clienteMongo.getDatabase(BASE_DATOS);
            
            return baseDatos;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            
            return null;
        }
    }
}
