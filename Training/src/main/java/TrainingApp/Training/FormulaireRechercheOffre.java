package trainingapp.training;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FormulaireRechercheOffre {

	private String produit;
	
	private Integer qtMin;
	
	private Integer qtMax;
	
	private Integer prixMin;
	
	private Integer prixMax;
	
	public boolean isEmpty(){
		return produit==null && qtMin==null && qtMax==null && prixMin==null && prixMax==null;
	}

}
