package in.hcp.venu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hcp.venu.entity.Doctor;
import in.hcp.venu.exception.DoctorNotFoundException;
import in.hcp.venu.repository.DoctorRepository;
import in.hcp.venu.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService{
     @Autowired
	private DoctorRepository repo;

	@Override
	public Long saveDoctor(Doctor doc) {
	return	repo.save(doc).getId();
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return repo.findAll();
	}

	@Override
	public void removeDoctor(Long id) {
      repo.delete(getOneDoctor(id));		
	}
	private Doctor getOneDoctor(Long id) {
		return repo.findById(id).orElseThrow(
				()->new DoctorNotFoundException(id+" ,is not exist")
			      );
	}
}
