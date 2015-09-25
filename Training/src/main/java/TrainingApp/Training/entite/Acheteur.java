package trainingapp.training.entite;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Acheteur {
	private Integer id;
	private Integer usrId;
	private String prenom;
	private String nom;
	private LocalDate dateNaissance;

}
