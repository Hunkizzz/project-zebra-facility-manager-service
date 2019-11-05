package team.projectzebra.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "issue_type")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class IssueType {
    @ApiModelProperty(notes = "The java generated UUID of building")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String code;
    private String name;
    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issue_group_uuid")
    @JsonBackReference
    private IssueGroup issueGroup;
}
