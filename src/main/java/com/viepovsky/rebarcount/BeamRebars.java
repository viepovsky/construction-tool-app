package com.viepovsky.rebarcount;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class BeamRebars {
    @NotNull
    private int beamClearSpan;

    @NotNull
    private int widthOfSupport;

    @NotNull
    private int upperRebarsDiameter;

    @NotNull
    private int upperRebarsCount;

    @NotNull
    private int lowerRebarsDiameter;

    @NotNull
    private int lowerRebarsCount;

    private int beamWidth;

    private int beamHigh;

    private int stirrupDiameter;

    private int stirrupSpacing;

    private int stirrupSpacingDensity;

    private int stirrupSpacingDensityLength;
}
