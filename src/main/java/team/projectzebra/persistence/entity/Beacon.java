package team.projectzebra.persistence.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
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
    private String qrScanUuid;
    private Boolean isActivated;
    private Date activatedOn;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToOne(mappedBy = "beacon", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Facility facility;
    @OneToOne(mappedBy = "beacon", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private IssueGroup issueGroup;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }
}
