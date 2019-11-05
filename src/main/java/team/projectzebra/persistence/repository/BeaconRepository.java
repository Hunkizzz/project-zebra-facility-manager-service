package team.projectzebra.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.projectzebra.persistence.entity.Beacon;

import java.util.UUID;
@Repository
public interface BeaconRepository extends CrudRepository<Beacon, UUID> {
}
