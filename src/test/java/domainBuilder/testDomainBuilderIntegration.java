package domainBuilder;

import domain.Disease;
import domain.Symptom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import repository.neo4J.DomainBuilder;

import java.util.List;
import java.util.LinkedList;

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
        session.run("CREATE (d_flew: Flew { name:'Flew' , type:'disease' } )");
        session.run("CREATE (s_fever: Fever { name:'Fever' , type:'symptom' } )");
        session.run("CREATE (s_headache: Headache { name:'Headache' , type:'symptom' } )");

        session.run("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (d_ebola)-[Has:has]->(s_fever)");
        session.run("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (s_fever)-[Is_In:is_in]->(d_ebola)");
        session.run("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (d_ebola)-[Has:has]->(s_headache)");
        session.run("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (s_headache)-[Is_In:is_in]->(d_ebola)");
        session.run("MATCH (d_flew: Flew),(s_fever: Fever) CREATE (d_flew)-[Has:has]->(s_fever)");
        session.run("MATCH (d_flew: Flew),(s_fever: Fever) CREATE (s_fever)-[Is_In:is_in]->(d_flew)");
        session.run("MATCH (d_flew: Flew),(s_headache: Headache) CREATE (d_flew)-[Has:has]->(s_headache)");
        session.run("MATCH (d_flew: Flew),(s_headache: Headache) CREATE (s_headache)-[Is_In:is_in]->(d_flew)");

    }

    @Test
    public void testBuildEbolaContainingHeadacheAndFever() {

        Disease ebola = builder.buildDiseaseWithAllItsSymptoms("Ebola");

        Assert.assertEquals("Ebola", ebola.getName());

        for (String symptomName : ebola.getSymptoms().keySet()) {

            Assert.assertTrue(symptomName.equals("Headache") || symptomName.equals("Fever"));

        }

        for (Symptom symptom : ebola.getSymptoms().values()) {

            Assert.assertTrue(symptom.getName().equals("Headache") || symptom.getName().equals("Fever"));

        }

    }

    @Test
    public void testBuildVIHWihtoutSymptoms() {

        Disease vih = builder.buildDiseaseWithAllItsSymptoms("VIH");

        Assert.assertEquals("VIH", vih.getName());

        Assert.assertTrue(vih.getSymptoms().isEmpty());

    }

    @Test
    public void testBuildFlewAndEbolaGivenFeverAndHeadache() {

        List<String> symptoms = new LinkedList<String>();
        symptoms.add("Fever");
        symptoms.add("Headache");
        List<Disease> diseases = builder.buildDiseasesGivenSymptomNames(symptoms);

        for (Disease disease : diseases) {

            Assert.assertTrue(disease.getName().equals("Ebola") || disease.getName().equals("Flew"));

        }

    }

    @Test
    public void testGetAllSymptoms() {

        session.run("CREATE (s_stomachache: Stmoachache { name:'Stomachache' , type:'symptom' } )");
        List<Symptom> symptoms = builder.buildAllSymptoms();
        for (Symptom symptom : symptoms) {

            Assert.assertTrue(symptom.getName().equals("Stomachache") || symptom.getName().equals("Headache") || symptom.getName().equals("Fever"));

        }

    }


}
