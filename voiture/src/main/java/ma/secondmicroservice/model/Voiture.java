package ma.secondmicroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Voiture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String marque;
	private String matricule;
	private String model;
	private int id_client;
	@Transient
	@ManyToOne
	private Client client;

	public Voiture() {
		super();
	}

	public Voiture(int id, String marque, String matricule, String model, int id_client, Client client) {
		super();
		this.id = id;
		this.marque = marque;
		this.matricule = matricule;
		this.model = model;
		this.id_client = id_client;
		this.client = client;
	}

	public Voiture(int id, String marque, String matricule, String model, Client client) {
		super();
		this.id = id;
		this.marque = marque;
		this.matricule = matricule;
		this.model = model;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", marque=" + marque + ", matricule=" + matricule + ", model=" + model
				+ ", id_client=" + id_client + ", client=" + client + "]";
	}
	

}
