package team.projectzebra.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class IssueGroupDto {
    private String name;
    private Boolean allowArbitraryDescription;
    private Boolean showContactField;
    private String beaconUuid;
}
