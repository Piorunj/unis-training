package trainingapp.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import trainingapp.training.entite.Transaction;

@Service
public interface TransactionService {
	List<Transaction> getAllTransactionByAcheteurId(Integer acheteurId);

	public List<Transaction> getAllTransaction();

	public Integer addTransaction(Integer idOffre, Integer idAcheteur);

	List<Transaction> getAllTransactionByVendeurId(Integer vendeurId);
}
