package team.projectzebra.controller;

import team.projectzebra.dto.BeaconDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.projectzebra.dto.FacilityDto;
import team.projectzebra.dto.IssueGroupDto;
import team.projectzebra.dto.IssueTypeDto;
import team.projectzebra.persistence.entity.Beacon;
import team.projectzebra.persistence.entity.Facility;
import team.projectzebra.persistence.entity.IssueGroup;
import team.projectzebra.persistence.entity.IssueType;
import team.projectzebra.persistence.repository.BeaconRepository;
import team.projectzebra.persistence.repository.FacilityRepository;
import team.projectzebra.persistence.repository.IssueGroupRepository;
import team.projectzebra.persistence.repository.IssueTypeRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Api(value = "Workspaces Booking Management System")
@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/projectzebrateam-housekeeper-service")
public class HousekeeperController {

    BeaconRepository beaconRepository;
    FacilityRepository facilityRepository;
    IssueGroupRepository issueGroupRepository;
    IssueTypeRepository issueTypeRepository;

    private static final Logger logger = LoggerFactory.getLogger(HousekeeperController.class);

    @Autowired
    public HousekeeperController(BeaconRepository beaconRepository,
                                 FacilityRepository facilityRepository,
                                 IssueGroupRepository issueGroupRepository,
                                 IssueTypeRepository issueTypeRepository
    ) {
        this.beaconRepository = beaconRepository;
        this.facilityRepository = facilityRepository;
        this.issueGroupRepository = issueGroupRepository;
        this.issueTypeRepository = issueTypeRepository;
    }

    @ApiOperation(value = "Add beacon")
    @PostMapping(path = "/add-beacon")
        // Map ONLY POST Requests
    ResponseEntity<Beacon> addBeacon(@RequestBody BeaconDto beaconDto,
                                     HttpServletResponse response) throws Exception {
        Beacon beacon = Beacon.builder().qrCodeUrl(beaconDto.getQrCodeUrl()).
                qrScanUuid(beaconDto.getQrScanUuid()).
                isActivated(beaconDto.getIsActivated()).
                activatedOn(beaconDto.getActivatedOn()).build();

        beaconRepository.save(beacon);
        return ResponseEntity.ok(beacon);
    }

    @ApiOperation(value = "Add facility")
    @PostMapping(path = "/add-facility")
        // Map ONLY POST Requests
    ResponseEntity<Facility> addFacility(@RequestBody FacilityDto facilityDto,
                                         HttpServletResponse response) throws Exception {
        Beacon beacon = beaconRepository.findById((UUID.fromString(facilityDto.getBeaconUuid()))).get();
        Facility facility = Facility.builder().beacon(beacon).
                name(facilityDto.getName())
                .build();

        facilityRepository.save(facility);
        return ResponseEntity.ok(facility);
    }

    @ApiOperation(value = "Add issue group")
    @PostMapping(path = "/add-issue-group")
        // Map ONLY POST Requests
    ResponseEntity<IssueGroup> addIssueGroup(@RequestBody IssueGroupDto issueGroupDto,
                                             HttpServletResponse response) throws Exception {
        Beacon beacon = beaconRepository.findById((UUID.fromString(issueGroupDto.getBeaconUuid()))).get();
        IssueGroup issueGroup = IssueGroup.builder().beacon(beacon).
                allowArbitraryDescription(issueGroupDto.getAllowArbitraryDescription()).
                name(issueGroupDto.getName()).
                showContactField(issueGroupDto.getShowContactField()).
                build();
        issueGroupRepository.save(issueGroup);
        return ResponseEntity.ok(issueGroup);
    }

    @ApiOperation(value = "Add issue type")
    @PostMapping(path = "/add-issue-type")
        // Map ONLY POST Requests
    ResponseEntity<IssueType> addIssueType(@RequestBody IssueTypeDto issueTypeDto,
                                           HttpServletResponse response) throws Exception {
        IssueGroup issueGroup = issueGroupRepository.findById((UUID.fromString(issueTypeDto.getIssueGroupUuid()))).get();
        IssueType issueType = IssueType.builder().issueGroup(issueGroup).
                name(issueTypeDto.getName()).
                code(issueTypeDto.getCode()).
                isActive(issueTypeDto.getIsActive()).
                build();
        issueTypeRepository.save(issueType);
        return ResponseEntity.ok(issueType);
    }


    @ApiOperation(value = "Get beacon`s problems")
    @GetMapping(path = "/beacons")
        // Map ONLY POST Requests
    ResponseEntity<Iterable<Beacon>> getBeaconInfo(HttpServletResponse response) throws Exception {
        return ResponseEntity.ok(beaconRepository.findAll());
    }

}
