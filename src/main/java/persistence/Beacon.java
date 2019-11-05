package persistence;

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
@Table(name = "beacon")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Beacon {
    @ApiModelProperty(notes = "The java generated UUID of building")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String qrCodeUrl;
    private UUID qrScanUuid;
    private Boolean isActivated;
    private Boolean activateOn;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @OneToOne
    @JoinColumn(name = "facility_uuid")
    private Facility facility;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }
}
