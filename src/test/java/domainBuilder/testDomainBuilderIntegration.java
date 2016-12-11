package domainBuilder;

import domain.Disease;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import repository.neo4J.DomainBuilder;

/**
 * Created by synysterlove on 11/12/16.
 */
public class testDomainBuilderIntegration {

    private static Session session;
    private static DomainBuilder builder;

    @BeforeClass
    public static void initialize() {

        Driver driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "1234"));
        session = driver.session();
        builder = new DomainBuilder();

    }

    @Before
    public void resetAndSetBaseData() {

        session.run("MATCH (n) DETACH DELETE n"); //Delete all

        /*Definition of some nodes
            s_ notes a sympthom
            d_ notes a disease
        */
        session.run("CREATE (d_ebola: Ebola { name:'Ebola' , type:'disease' } )");
        session.run("CREATE (d_vih: VIH { name:'VIH' , type:'disease' } )");
        session.run("CREATE (s_fever: Fever { name:'Fever' , type:'symptom' } )");
        session.run("CREATE (s_headache: Headache { name:'Headache' , type:'symptom' } )");

        session.run("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (d_ebola)-[Has:has]->(s_fever)");
        session.run("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (s_fever)-[Is_In:is_in]->(d_ebola)");
        session.run("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (d_ebola)-[Has:has]->(s_headache)");
        session.run("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (s_headache)-[Is_In:is_in]->(d_ebola)");

    }

    @Test
    public void testBuildEbolaContainingHeadacheAndFever() {

        Disease ebola = builder.buildDiseaseWithAllItsSymptoms("Ebola");

        Assert.assertEquals("Ebola", ebola.getName());

        for (String symptomName : ebola.getSymptoms().keySet()) {

            Assert.assertTrue(symptomName.equals("Headache") || symptomName.equals("Fever"));

        }

    }

    
}
