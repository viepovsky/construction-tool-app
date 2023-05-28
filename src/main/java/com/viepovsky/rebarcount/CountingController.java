package com.viepovsky.rebarcount;

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

    @GetMapping
    ResponseEntity<RebarCount> getBeamRebarsLength(@RequestBody @Valid BeamRebars rebars) {
        return ResponseEntity.ok(service.calculateRebarsLengthInBeam(rebars));
    }
}
