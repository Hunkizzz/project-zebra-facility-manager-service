package team.projectzebra.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.projectzebra.persistence.entity.Beacon;
import team.projectzebra.persistence.entity.IssueGroup;

import java.util.UUID;
@Repository
public interface IssueGroupRepository extends CrudRepository<IssueGroup, UUID> {
}
