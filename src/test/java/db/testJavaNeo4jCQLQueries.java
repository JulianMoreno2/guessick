package db;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.neo4j.driver.v1.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class testJavaNeo4jCQLQueries {

    private static Driver driver;
    private static Session session;

    @BeforeClass
    public static void initializeDatabase() {

        driver = GraphDatabase.driver("bolt://localhost",AuthTokens.basic("neo4j", "1234"));
        session = driver.session();

    }

    @Before
    public void resetAndSetBaseData() {

        session.run("MATCH (n) DETACH DELETE n"); //Delete all

        /*Definition of some nodes
            s_ notes a sympthom
            d_ notes a disease
        */
        session.run("CREATE (d_ebola: Ebola { name:'Ebola' , type:'disease' } )");
        session.run("CREATE (s_fever: Fever { name:'Fever' , type:'symptom' } )");
        session.run("CREATE (s_headache: Headache { name:'Headache' , type:'symptom' } )");

        session.run("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (d_ebola)-[Has:has]->(s_fever)");
        session.run("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (s_fever)-[Is_In:is_in]->(d_ebola)");
        session.run("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (d_ebola)-[Has:has]->(s_headache)");
        session.run("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (s_headache)-[Is_In:is_in]->(d_ebola)");

    }

    @Test
    public void testGetEbolaNode() {

        //Retrieve the 'name' property from the Ebola node
        StatementResult ebolaResult = session.run("MATCH (d_ebola: Ebola) WHERE d_ebola.name = 'Ebola' RETURN d_ebola.name AS name");
        Record record = ebolaResult.next();
        Assert.assertEquals("Ebola", record.get("name").asString());

    }

    @Test
    public void testGetEbolaSympthoms() {

        //Retrieves the id from the Ebola node
        StatementResult ebolaResult = session.run("MATCH (d_ebola: Ebola) WHERE d_ebola.name = 'Ebola' RETURN ID(d_ebola) AS id");
        Record ebolaRecord = ebolaResult.next();
        Integer ebola_id = ebolaRecord.get("id").asInt();
        String ebola_id_string = ebola_id.toString();
        //Goes to the Ebola node (by its id) and retrieves the names of all nodes connected to it
        StatementResult sympthomsResult = session.run("START a=node(" + ebola_id_string + ") MATCH (a)-[:has*]->(b) RETURN distinct b.name AS name");
        List<String> names = new LinkedList<String>();
        while(sympthomsResult.hasNext()){

            Record record = sympthomsResult.next();
            names.add(record.get("name").asString());

        }
        Assert.assertTrue(names.contains("Headache"));
        Assert.assertTrue(names.contains("Fever"));

    }

    @Test
    public void testGetAllDiseaseWithFeverAndHeadache() {

        session.run("CREATE (d_flew: Flew { name:'Flew' , type:'disease' } )");
        session.run("CREATE (d_vih: VIH { name:'VIH' , type:'disease' } )");


        session.run("MATCH (d_flew: Flew),(s_fever: Fever) CREATE (d_flew)-[Has:has]->(s_fever)");
        session.run("MATCH (d_flew: Flew),(s_fever: Fever) CREATE (s_fever)-[Is_In:is_in]->(d_flew)");
        session.run("MATCH (d_flew: Flew),(s_headache: Headache) CREATE (d_flew)-[Has:has]->(s_headache)");
        session.run("MATCH (d_flew: Flew),(s_headache: Headache) CREATE (s_headache)-[Is_In:is_in]->(d_flew)");


        //Retrieves the id from the Fever and Headache nodes
        StatementResult feverIdResult = session.run("MATCH (s_fever: Fever) WHERE s_fever.name = 'Fever' RETURN ID(s_fever) AS id");
        StatementResult headacheIdResult = session.run("MATCH (s_headache: Headache) WHERE s_headache.name = 'Headache' RETURN ID(s_headache) AS id");

        Record feverIdRecord = feverIdResult.next();
        Integer fever_id = feverIdRecord.get("id").asInt();
        String fever_id_string = fever_id.toString();
        Record headacheIdRecord = headacheIdResult.next();
        Integer headache_id = headacheIdRecord.get("id").asInt();
        String headache_id_string = headache_id.toString();

        //Goes to the Fever node (by its id) and retrieves the names of all nodes connected to it
        StatementResult feverResult = session.run("START a=node(" + fever_id_string + ") MATCH (a)-[:is_in*]->(b) RETURN distinct b.name AS name");
        Set<String> feverConnectedNodesNames = new HashSet<String>();
        while(feverResult.hasNext()){

            Record record = feverResult.next();
            feverConnectedNodesNames.add(record.get("name").asString());

        }

        //Goes to the Headache node (by its id) and retrieves the names of all nodes connected to it
        StatementResult headacheResult = session.run("START a=node(" + headache_id_string + ") MATCH (a)-[:is_in*]->(b) RETURN distinct b.name AS name");
        Set<String> headacheConnectedNodesNames = new HashSet<String>();
        while(headacheResult.hasNext()){

            Record record = headacheResult.next();
            headacheConnectedNodesNames.add(record.get("name").asString());

        }

        //Calculate the intersection between the two sets
        Set<String> names = feverConnectedNodesNames;
        names.retainAll(headacheConnectedNodesNames);

        Assert.assertTrue(names.contains("Ebola"));
        Assert.assertTrue(names.contains("Flew"));
        Assert.assertFalse(names.contains("VIH"));


    }

    @Test
    public void testASpikeOfNeo4J(){
    	
    	/**
    	 * Install Neo4j
    	 *      wget -O - https://debian.neo4j.org/neotechnology.gpg.key | sudo apt-key add -
    	 *      echo 'deb http://debian.neo4j.org/repo stable/' | sudo tee /etc/apt/sources.list.d/neo4j.list
    	 *      sudo apt-get update
    	 * Neo4j Community Edition: 
    	 *      sudo apt-get install neo4j
    	 *      
    	 * Run Neo4j
    	 *      sudo neo4j restart
    	 *      
    	 * Configure Neo4j
    	 *      http://localhost:7474/
    	 *      
    	 *      Set Admin: neo4j
    	 *      Set Pass:  neo4j
    	 *      Reconfigure pass to: 1234
    	 *      
    	 *      Run Test
    	 */
    	
//    	session.run("CREATE (a:Person {name:'Arthur', title:'King'})");
//    	
//    	StatementResult result = session.run("MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title"); 
//
//    	while(result.hasNext()){
//    		Record record = result.next();
//    		System.out.println(record.get("title").asString() + " " + record.get("name").asString());
//    		
//    	}
    }
    
    
}
