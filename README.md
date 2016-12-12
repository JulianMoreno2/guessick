# Guessick
Repository dedicated to Course "Medical Informatics" of UnTref


To test the app, do the following:

First run the command: sudo neo4j restart

To configure Neo4j, if it isn't done yet, go to http://localhost:7474/
 And set the user data:
   * Admin: neo4j (by default)
   * Pass:  neo4j (by default)
   * Reconfigure pass to: 1234

Then, run all these queries to set some test data:

    session.run("MATCH (n) DETACH DELETE n"); //This deletes everything in the database
   
    //The following queries create the nodes
    session.run("CREATE (d_ebola: Ebola { name:'Ebola' , type:'disease' } )");
    session.run("CREATE (d_vih: VIH { name:'VIH' , type:'disease' } )");
    session.run("CREATE (d_flew: Flew { name:'Flew' , type:'disease' } )");
    session.run("CREATE (s_fever: Fever { name:'Fever' , type:'symptom' } )");
    session.run("CREATE (s_headache: Headache { name:'Headache' , type:'symptom' }
    session.run("CREATE (s_coughing: Coughing { name:'Coughing' , type:'symptom' }

    //The following queries create the relationships between diseases and symptoms
   session.run("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (d_ebola)-[Has:has]->(s_fever)");
   session.run("MATCH (d_ebola: Ebola),(s_fever: Fever) CREATE (s_fever)-[Is_In:is_in]->(d_ebola)");
   session.run("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (d_ebola)-[Has:has]->(s_headache)");
   session.run("MATCH (d_ebola: Ebola),(s_headache: Headache) CREATE (s_headache)-[Is_In:is_in]->(d_ebola)");
   session.run("MATCH (d_flew: Flew),(s_fever: Fever) CREATE (d_flew)-[Has:has]->(s_fever)");
   session.run("MATCH (d_flew: Flew),(s_fever: Fever) CREATE (s_fever)-[Is_In:is_in]->(d_flew)");
   session.run("MATCH (d_flew: Flew),(s_headache: Headache) CREATE (d_flew)-[Has:has]->(s_headache)");
   session.run("MATCH (d_flew: Flew),(s_headache: Headache) CREATE (s_headache)-[Is_In:is_in]->(d_flew)");
   session.run("MATCH (d_flew: Flew),(s_coughing: Coughing) CREATE (d_flew)-[Has:has]->(s_coughing)");
   session.run("MATCH (d_flew: Flew),(s_coughing: Coughing) CREATE (s_coughing)-[Is_In:is_in]->(d_flew)");

  //So far, we've got the following:
	Ebola -> Fever and Headache
	Flew -> Fever, Headache and Coughing
	VIH -> No symptoms at all