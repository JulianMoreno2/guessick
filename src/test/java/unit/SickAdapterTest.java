package unit;

import org.junit.Assert;
import org.junit.Test;

import adapter.SickAdapter;
import repository.SickRepository;
import service.SickService;

public class SickAdapterTest {
	
	@Test
	public void saveSickAdapter(){
		//TODO: mock
		SickRepository sickRepository = new SickRepository();		
		SickService sickService = new SickService(sickRepository);
		SickAdapter sickAdapter = new SickAdapter(sickService);
		
		Assert.assertTrue(true);
	}
}
