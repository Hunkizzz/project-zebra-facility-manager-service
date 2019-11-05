package team.projectzebra.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "issue_group")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class IssueGroup {
    @ApiModelProperty(notes = "The java generated UUID of building")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
    private Boolean allowArbitraryDescription;
    private Boolean showContactField;
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "beacon_uuid")
    private Beacon beacon;

    @OneToMany(mappedBy = "issueGroup", fetch = FetchType.EAGER)
    private List<IssueType> issueTypes;

}