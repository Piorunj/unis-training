package trainingapp.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trainingapp.training.entite.Transaction;
import trainingapp.training.mapper.TransactionMapper;
import trainingapp.training.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionMapper transactionMapper;

	@Override
	public List<Transaction> getAllTransactionByAcheteurId(Integer acheteurId) {
		return transactionMapper.getAllTransactionByAcheteurId(acheteurId);
	}
	
	
}
