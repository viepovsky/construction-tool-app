package com.viepovsky.rebarcount;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
class CountingService {
    private RebarCount rebarCount;
    private int rebarsLength;

    RebarCount calculateRebarsLengthInBeam(BeamRebars rebars) {
        initClassFields(rebars);
        calculateAndStoreRebarsLength(rebars.getUpperRebarsCount(), rebars.getUpperRebarsDiameter());
        calculateAndStoreRebarsLength(rebars.getLowerRebarsCount(), rebars.getLowerRebarsDiameter());
        calculateAndStoreStirrupLength(rebars);
        return rebarCount;
    }

    RebarCount calculateRebarsLengthInSlab(SlabRebars rebars) {
        rebarCount = new RebarCount();
        calculateAndStoreRebarsLength(rebars.getSlabLength(), rebars.getSlabWidth(), rebars.getUpperSpacing(), rebars.getUpperRebarsDiameter());
        calculateAndStoreRebarsLength(rebars.getSlabWidth(), rebars.getSlabLength(), rebars.getLowerSpacing(), rebars.getLowerRebarsDiameter());
        return rebarCount;
    }

    private void initClassFields(BeamRebars rebars) {
        rebarCount = new RebarCount();
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

    private void calculateAndStoreStirrupLength(BeamRebars rebars) {
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
        Map<Integer, Double> storedRebars = rebarCount.getRebars();
        if (storedRebars.containsKey(diameter)) {
            double sum = storedRebars.get(diameter) + length / 100.0;
            storedRebars.replace(diameter, sum);
        } else {
            storedRebars.put(diameter, length / 100.0);
        }
    }
}
