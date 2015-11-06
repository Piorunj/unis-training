package trainingapp.training.entite;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Utilisateur {
	private Integer id;

	private String login;

	private String password;

	private String telephone;

}
