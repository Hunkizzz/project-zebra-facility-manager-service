package team.projectzebra.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class BeaconDto {
    String qrCodeUrl;
    String qrScanUuid;
    String name;
    Boolean isActivated;
    Date activatedOn;
}
