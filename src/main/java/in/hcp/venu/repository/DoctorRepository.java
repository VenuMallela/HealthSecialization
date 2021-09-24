package in.hcp.venu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.hcp.venu.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
