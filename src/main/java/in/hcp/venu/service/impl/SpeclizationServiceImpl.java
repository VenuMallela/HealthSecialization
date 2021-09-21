package in.hcp.venu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hcp.venu.entity.Specilazation;
import in.hcp.venu.repository.SpecilazationRepository;
import in.hcp.venu.service.SpeclizationService;
@Service
public class SpeclizationServiceImpl implements SpeclizationService {

	@Autowired
	private SpecilazationRepository repo;

	@Override
	public Integer saveSpecialization(Specilazation specilazation) {

		specilazation = repo.save(specilazation);

		return specilazation.getId();
	}

	@Override
	public List<Specilazation> getAllData() {

		List<Specilazation> list = repo.findAll();

		return list;
	}

	@Override
	public void deleteData(Integer id) {

		repo.deleteById(id);

	}

	@Override
	public Specilazation editData(Integer id) {

		Optional<Specilazation> list = repo.findById(id);
		if (list.isPresent()) {
			Specilazation spl = list.get();

			return spl;
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateData(Specilazation specilazation) {

		repo.save(specilazation);

	}

}
