package team.projectzebra.persistence.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "maintenance_request")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceRequest {
    @ApiModelProperty(notes = "The java generated UUID of building")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "facility_uuid")
    private Facility facility;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }
}
