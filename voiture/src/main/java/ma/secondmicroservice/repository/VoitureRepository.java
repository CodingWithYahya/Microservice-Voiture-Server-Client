package ma.secondmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.secondmicroservice.model.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Integer>{

}
