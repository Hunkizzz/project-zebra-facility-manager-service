package persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "issue_group")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class IssueGroup {
    private UUID uuid;
    private String name;
    private Boolean allowArbitraryDescription;
    private Boolean showContactField;
    @OneToOne
    @JoinColumn(name = "beacon_uuid")
    private Beacon beacon;
}
