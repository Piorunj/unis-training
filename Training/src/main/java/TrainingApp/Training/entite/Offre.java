package trainingapp.training.entite;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Offre {
	private Integer id;
	private Integer produitId;
	private Integer vendeurId;
	private Integer quantite;
	private String unite;
	private Integer prixUnite;
	private LocalDate datecreation;
}
