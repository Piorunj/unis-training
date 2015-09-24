package TrainingApp.Training.entite;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Transaction {

	private Integer id;
	private Integer acheteurId;
	private Integer offreId;
	private LocalDate date;
	
}
