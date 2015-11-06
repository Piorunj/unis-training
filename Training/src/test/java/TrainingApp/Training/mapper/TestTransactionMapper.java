package trainingapp.training.mapper;

import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import trainingapp.training.AbstractTrainingTest;
import trainingapp.training.entite.Transaction;

public class TestTransactionMapper extends AbstractTrainingTest {

	// TODO : tester que la date n'est pas nulle lors de l'ajout d'une
	// transaction

	@Autowired
	private TransactionMapper transactionMapper;

	@Test
	public void testGetAllTransactionByAcheteurIdSuccess() throws Exception {
		Transaction transaction1 = createTransaction();

		List<Transaction> listRef = new ArrayList<Transaction>();
		listRef.add(transaction1);

		List<Transaction> list = transactionMapper.getAllTransactionByAcheteurId(transaction1.getAcheteurId());

		Assertions.assertThat(list).isNotNull().isNotEmpty().hasSize(listRef.size());
		Assertions.assertThat(list.get(0).getAcheteurId()).isEqualTo(listRef.get(0).getAcheteurId());
	}

	@Test
	public void testGetAllTransactionByAcheteurIdFail() throws Exception {
		Assertions.assertThat(transactionMapper.getAllTransactionByAcheteurId(null)).isNotNull().isEmpty();
		Assertions.assertThat(transactionMapper.getAllTransactionByAcheteurId(0)).isNotNull().isEmpty();
	}

	@Test
	public void testGetAllTransactionSuccess() throws Exception {
		Assertions.assertThat(transactionMapper.getAllTransaction()).hasSize(NB_TRANSACTION);
	}

	@Test
	public void testAddTransactionSucess() throws Exception {
		Transaction transactionToAdd = createTransaction();
		Assertions.assertThat(transactionMapper.getAllTransaction()).hasSize(NB_TRANSACTION);
		transactionMapper.addTransaction(transactionToAdd.getOffre().getId(), transactionToAdd.getAcheteurId());
		Assertions.assertThat(transactionMapper.getAllTransaction()).hasSize(NB_TRANSACTION + 1);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testAddTransactionFailOffreNulle() throws Exception {
		Transaction transactionToAdd = createTransaction();
		Assertions.assertThat(transactionMapper.addTransaction(null, transactionToAdd.getAcheteurId()));
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testAddTransactionFailOffreInexistante() throws Exception {
		Transaction transactionToAdd = createTransaction();
		Assertions.assertThat(transactionMapper.addTransaction(Integer.MAX_VALUE, transactionToAdd.getAcheteurId()));
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testAddTransactionFailAcheteurNulle() throws Exception {
		Transaction transactionToAdd = createTransaction();
		Assertions.assertThat(transactionMapper.addTransaction(transactionToAdd.getOffre().getId(), null));
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testAddTransactionFailAcheteurInexistante() throws Exception {
		Transaction transactionToAdd = createTransaction();
		Assertions.assertThat(transactionMapper.addTransaction(transactionToAdd.getOffre().getId(), Integer.MAX_VALUE));
	}

}
