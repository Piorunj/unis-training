package trainingapp.training;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FormulaireCreationAcheteur {
	private String login;
	private String password;
	private String telephone;
	private String prenom;
	private String nom;
	private String dateNaissance;
	
	public boolean isCorrectlySet(){
		return (login!=null && password!=null && telephone!=null && prenom!=null && nom!=null && dateNaissance!=null);
	}

}
