package trainingapp.training;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FormulaireCreationVendeur {
	private String login;
	private String password;
	private String telephone;
	private String entreprise;

	public boolean isCorrectlySet() {
		return (login != null && password != null && telephone != null && entreprise != null);
	}
}
