package team.projectzebra.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "facility")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Facility {
    @ApiModelProperty(notes = "The java generated UUID of building")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "beacon_uuid")
    private Beacon beacon;
}
