package team.projectzebra.persistence.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "maintenance_request_issue")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceRequestIssue {
    @ApiModelProperty(notes = "The java generated UUID of building")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "maintenance_request_uuid")
    private MaintenanceRequest maintenanceRequest;
}
