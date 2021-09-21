package in.hcp.venu.service;

import java.util.List;

import in.hcp.venu.entity.Specilazation;

public interface SpeclizationService {
	
	Integer saveSpecialization(Specilazation specilazation);
    
    List<Specilazation> getAllData();
         void deleteData(Integer id );
         
         Specilazation editData( Integer id);
        void  updateData(Specilazation specilazation);

	
	

}
