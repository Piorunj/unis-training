package trainingapp.training;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FormulaireRechercheOffre {

	@NotNull(message = "Toto null")
	@NotEmpty(message = "Toto vide")
	private String produit;

	private Integer qtMin;

	private Integer qtMax;

	private Integer prixMin;

	private Integer prixMax;

	public boolean isEmpty() {
		return produit == null && qtMin == null && qtMax == null && prixMin == null && prixMax == null;
	}

}
