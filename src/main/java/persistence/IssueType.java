package persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "issue_type_group")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class IssueType {
    private UUID uuid;
    private String name;
    @Column(name = "is_active")
    private Boolean isActive;
}
