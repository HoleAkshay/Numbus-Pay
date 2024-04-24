package inc.nimbuspay.proaccountgrpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inc.nimbuspay.proaccountgrpc.entity.FIRequestEntity;
import inc.nimbuspay.proaccountgrpc.repository.FIRequestEntityRepository;

@Service
public class FIRequestEntityServiceImpl implements FIRequestEntityService {

    @Autowired
    private FIRequestEntityRepository fiRequestEntityRepository;

    @Override
    public FIRequestEntity saveFIRequest(FIRequestEntity fiRequestEntity) {
        FIRequestEntity savedFiRequestEntity = fiRequestEntityRepository.save(fiRequestEntity);
        return savedFiRequestEntity;
    }

}
