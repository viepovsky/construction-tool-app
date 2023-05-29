package com.viepovsky.rebarcount;

import com.viepovsky.rebarcount.dto.BeamRequest;
import com.viepovsky.rebarcount.dto.RebarLengthResponse;
import com.viepovsky.rebarcount.dto.SlabRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
class CountingService {
    private RebarLengthResponse rebarLengthResponse;
    private int rebarsLength;

    RebarLengthResponse calculateRebarsLengthInBeam(BeamRequest rebars) {
        initClassFields(rebars);
        calculateAndStoreRebarsLength(rebars.getUpperRebarsCount(), rebars.getUpperRebarsDiameter());
        calculateAndStoreRebarsLength(rebars.getLowerRebarsCount(), rebars.getLowerRebarsDiameter());
        calculateAndStoreStirrupLength(rebars);
        return rebarLengthResponse;
    }

    RebarLengthResponse calculateRebarsLengthInSlab(SlabRequest rebars) {
        rebarLengthResponse = new RebarLengthResponse();
        calculateAndStoreRebarsLength(rebars.getSlabLength(), rebars.getSlabWidth(), rebars.getUpperSpacing(), rebars.getUpperRebarsDiameter());
        calculateAndStoreRebarsLength(rebars.getSlabWidth(), rebars.getSlabLength(), rebars.getLowerSpacing(), rebars.getLowerRebarsDiameter());
        return rebarLengthResponse;
    }

    private void initClassFields(BeamRequest rebars) {
        rebarLengthResponse = new RebarLengthResponse();
        rebarsLength = rebars.getBeamClearSpan() + rebars.getWidthOfSupport() * 2;
    }

    private void calculateAndStoreRebarsLength(int firstSlabDimension, int secondSlabDimension, int slabSpacing, int diameter) {
        int length = ((firstSlabDimension / slabSpacing) + 1) * secondSlabDimension;
        storeRebars(length, diameter);
        int lengthSecondDimension = ((secondSlabDimension / slabSpacing) + 1) * firstSlabDimension;
        storeRebars(lengthSecondDimension, diameter);
    }

    private void calculateAndStoreRebarsLength(int rebarsCount, int diameter) {
        int length = rebarsLength * rebarsCount;
        storeRebars(length, diameter);
    }

    private void calculateAndStoreStirrupLength(BeamRequest rebars) {
        int stirrup = (rebars.getBeamWidth() - 3) * 2 + (rebars.getBeamHigh() - 3) * 2 + 10;
        int stirrupLength = 0;
        if (rebars.getStirrupSpacingDensity() > 0 && rebars.getStirrupSpacingDensityLength() > 0) {
            stirrupLength = ((rebars.getBeamClearSpan() - rebars.getStirrupSpacingDensityLength()) / rebars.getStirrupSpacing() + 1) * stirrup;
            stirrupLength += (rebars.getStirrupSpacingDensityLength() / rebars.getStirrupSpacingDensity() + 1) * stirrup;
        } else {
            stirrupLength = (rebars.getBeamClearSpan() / rebars.getStirrupSpacing() + 1) * stirrup;
        }
        storeRebars(stirrupLength, rebars.getStirrupDiameter());
    }

    private void storeRebars(int length, int diameter) {
        Map<Integer, Double> storedRebars = rebarLengthResponse.getRebars();
        if (storedRebars.containsKey(diameter)) {
            double sum = storedRebars.get(diameter) + length / 100.0;
            storedRebars.replace(diameter, sum);
        } else {
            storedRebars.put(diameter, length / 100.0);
        }
    }
}
