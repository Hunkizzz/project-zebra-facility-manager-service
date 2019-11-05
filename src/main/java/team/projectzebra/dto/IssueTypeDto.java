package team.projectzebra.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class IssueTypeDto {
    private String code;
    private String name;
    private Boolean isActive;
    private String issueGroupUuid;
}
