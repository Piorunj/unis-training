package trainingapp.training.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import trainingapp.training.entite.Transaction;

public interface TransactionMapper {
	public List<Transaction> getAllTransactionByAcheteurId(@Param("acheteurId")Integer acheteurId);
}
