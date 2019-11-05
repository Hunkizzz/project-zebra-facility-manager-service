package team.projectzebra.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.projectzebra.persistence.entity.Facility;
import team.projectzebra.persistence.entity.IssueType;

import java.util.UUID;
@Repository
public interface IssueTypeRepository extends CrudRepository<IssueType, UUID> {
}
