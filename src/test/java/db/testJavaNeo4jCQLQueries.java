package db;

import org.junit.BeforeClass;
import org.junit.Test;
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
        File dbFile = new File("/home/synysterlove/InformaticaMedica/guessick/GuessickDB");

        //Database scheme creation
        GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
        db = dbFactory.newEmbeddedDatabase(dbFile);

        /*Definition of some nodes
            s_ notes a sympthom
            d_ notes a disease
         */
        db.execute("CREATE (d_ebola: Ebola)");
        db.execute("CREATE (s_fever: Fever)");
        db.execute("CREATE (s_headache: Headache)");
        db.execute("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (d_ebola)-[Has:has]->(s_fever)");
        db.execute("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (s_fever)-[Is_In:is_in]->(d_ebola)");
        db.execute("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (d_ebola)-[Has:has]->(s_headache)");
        db.execute("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (s_headache)-[Is_In:is_in]->(d_ebola)");


    }

    @Test
    public void testGetEbolasSympthoms() {

        Result ebolaResult = db.execute("MATCH (d_ebola: Ebola) RETURN d_ebola"); //Obtener todos los nodos relacionados con Ebola

    }
    
}
