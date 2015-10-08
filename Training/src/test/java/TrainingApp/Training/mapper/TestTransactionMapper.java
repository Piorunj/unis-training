package trainingapp.training.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import trainingapp.training.AbstractTrainingTest;
import trainingapp.training.entite.Transaction;

public class TestTransactionMapper extends AbstractTrainingTest{
	
	@Autowired
	private TransactionMapper transactionMapper;
	
	@Test
	public void testGetAllTransactionByAcheteurIdSuccess() throws Exception {
		Transaction transaction1 = createTransaction();
		
		Transaction transaction2 = new Transaction();
		
		
		transactionMapper.getAllTransactionByAcheteurId(transaction1.getAcheteurId());
	}

}
