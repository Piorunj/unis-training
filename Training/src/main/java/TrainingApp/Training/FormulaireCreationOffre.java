package trainingapp.training;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FormulaireCreationOffre {

	private String produit;
	private Integer quantite;
	private String unite;
	private Integer prixUnite;
	
	public boolean isEmpty(){
		return (produit == null && quantite == null && unite == null && prixUnite == null);
	}
	
	public boolean correctlySet(){
		return (produit!=null && quantite!=null && unite!=null && prixUnite!=null);
	}
}
