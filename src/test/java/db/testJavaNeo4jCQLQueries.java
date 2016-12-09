package db;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.neo4j.cypher.internal.javacompat.ExecutionEngine;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;


import java.io.File;
import java.util.Map;

public class testJavaNeo4jCQLQueries {

    private static GraphDatabaseService db;
    private static ExecutionEngine querier;

    @BeforeClass
    public static void initializeDatabase() {
    	
//        //Database file
//        File dbFile = new File("../GuessickDB");
//
//        //Database scheme creation
//        GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
//        db = dbFactory.newEmbeddedDatabase(dbFile);

        /*Definition of some nodes
            s_ notes a sympthom
            d_ notes a disease
         */
//        db.execute("CREATE (d_ebola: Ebola)");
//        db.execute("CREATE (s_fever: Fever)");
//        db.execute("CREATE (s_headache: Headache)");
//        db.execute("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (d_ebola)-[Has:has]->(s_fever)");
//        db.execute("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (s_fever)-[Is_In:is_in]->(d_ebola)");
//        db.execute("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (d_ebola)-[Has:has]->(s_headache)");
//        db.execute("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (s_headache)-[Is_In:is_in]->(d_ebola)");


    }

    @Test
    public void testGetEbolasSympthoms() {

        //Result ebolaResult = db.execute("MATCH (d_ebola: Ebola) RETURN d_ebola"); //Obtener todos los nodos relacionados con Ebola
        
    }

    @Test
    public void testAnSpikeOfNeo4J(){
    	
    	Driver driver = GraphDatabase.driver("bolt://localhost",AuthTokens.basic("neo4j", "1234"));
    	Session session = driver.session();
    	
    	//session.run("CREATE (a:Person {name:'Arthur', title:'King'})");
    	
    	StatementResult result = session.run("MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title"); 

    	while(result.hasNext()){
    		Record record = result.next();
    		System.out.println(record.get("title").asString() + " " + record.get("name").asString());
    		
    	}
    }
    
    
}
