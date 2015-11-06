package trainingapp.training.entite;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Transaction {

	private Integer id;
	private Integer acheteurId;
	private Offre offre;
	private LocalDate date;

}
