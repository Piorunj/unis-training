package TrainingApp.Training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonFormulaire {

	private String email;
	
	private String password;

	@Override
	public String toString() {
		return "MonFormulaire [email=" + email + ", password=" + password + "]";
	}
	
	
}
