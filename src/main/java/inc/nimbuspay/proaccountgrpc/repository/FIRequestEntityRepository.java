package inc.nimbuspay.proaccountgrpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import inc.nimbuspay.proaccountgrpc.entity.FIRequestEntity;

public interface FIRequestEntityRepository extends JpaRepository<FIRequestEntity, Long> {

}
