package db;

import org.junit.BeforeClass;
import org.neo4j.cypher.internal.javacompat.ExecutionEngine;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

/**
 * Created by synysterlove on 29/11/16.
 */
public class testJavaNeo4jCQLQueries {

    private static GraphDatabaseService db;
    private static ExecutionEngine querier;

    @BeforeClass
    public static void initializeDatabase() {

        //Database file
        File dbFile = new File("/GuessickDB");

        //Database scheme creation
        GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
        db = dbFactory.newEmbeddedDatabase(dbFile);

        /*Definition of some nodes
            s_ notes a sympthom
            d_ notes a disease
         */
        db.execute("CREATE (d_ebola):(Ebola)");
        db.execute("CREATE (s_fever):(Fever)");
        db.execute("CREATE (s_headache):(Headache)");
        db.execute("CREATE (Ebola)-[Has:has]->(Fever)");
        db.execute("CREATE (Fever)-[Is_In:is_in]->(Ebola)");
        db.execute("CREATE (Ebola)-[Has:has]->(Headache)");
        db.execute("CREATE (Headache)-[Is_In:is_in]->(Ebola)");


    }

    public void testGetEbolasSympthoms() {

        Result ebolaResult = db.execute(""); //Obtener todos los nodos relacionados con Ebola

    }
    
}
