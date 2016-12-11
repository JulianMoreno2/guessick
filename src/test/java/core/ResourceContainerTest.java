package core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import resources.LoadAllSymptomsResource;
import resources.LoadDiseaseResource;

public class ResourceContainerTest {
	
	ResourceContainer initializer;
	
	@Before
	public void doBefore(){
		initializer = new ResourceContainer();
	}

	@Test
	public void testLoadAllSymptomCorrectly(){		
		Assert.assertEquals(LoadAllSymptomsResource.class, initializer.getLoadAllSymptomsResource().getClass());
	}
	
	@Test
	public void testLoadDiseaseResourceCorrectly(){
		Assert.assertEquals(LoadDiseaseResource.class, initializer.getLoadDiseaseResource().getClass());
	}
	
	@Test
	public void testLoadPossibleDiseasesResourceCorrectly(){
		Assert.assertEquals(LoadDiseaseResource.class, initializer.getLoadDiseaseResource().getClass());
	}
}
