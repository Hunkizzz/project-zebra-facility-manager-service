package persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "maintenance_request_issue")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceRequestIssue {
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "maintenance_request_uuid")
    private MaintenanceRequest maintenanceRequest;
}
