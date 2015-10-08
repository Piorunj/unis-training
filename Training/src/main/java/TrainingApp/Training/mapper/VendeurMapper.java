package trainingapp.training.mapper;

import org.apache.ibatis.annotations.Param;

import trainingapp.training.entite.Vendeur;

public interface VendeurMapper {
	
	public Vendeur getVendeurById(@Param("id") Integer id);

}
