package com.viepovsky.rebarcount.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SlabRequest {
    @NotNull
    private int slabWidth;

    @NotNull
    private int slabLength;

    @NotNull
    private int upperRebarsDiameter;

    @NotNull
    private int lowerRebarsDiameter;

    @NotNull
    private int upperSpacing;

    @NotNull
    private int lowerSpacing;
}
