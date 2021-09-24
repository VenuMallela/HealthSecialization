package in.hcp.venu.service;

import java.util.List;



import in.hcp.venu.entity.Doctor;


public interface IDoctorService {

	public Long saveDoctor(Doctor doc);
	public List<Doctor> getAllDoctors();
	public void removeDoctor(Long id);
}
