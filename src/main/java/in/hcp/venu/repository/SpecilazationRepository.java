package in.hcp.venu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.hcp.venu.entity.Specilazation;
@Repository
public interface SpecilazationRepository extends JpaRepository<Specilazation, Integer>{

}
