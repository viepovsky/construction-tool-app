package com.viepovsky.rebarcount;

import com.viepovsky.rebarcount.dto.BeamRequest;
import com.viepovsky.rebarcount.dto.RebarLengthResponse;
import com.viepovsky.rebarcount.dto.SlabRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/counting")
@RequiredArgsConstructor
@Validated
class CountingController {
    private final CountingService service;

    @GetMapping(path = "beam")
    ResponseEntity<RebarLengthResponse> getBeamRebarsLength(@RequestBody @Valid BeamRequest rebars) {
        return ResponseEntity.ok(service.calculateRebarsLengthInBeam(rebars));
    }

    @GetMapping(path = "slab")
    ResponseEntity<RebarLengthResponse> getSlabRebarsLength(@RequestBody @Valid SlabRequest rebars) {
        return ResponseEntity.ok(service.calculateRebarsLengthInSlab(rebars));
    }
}
