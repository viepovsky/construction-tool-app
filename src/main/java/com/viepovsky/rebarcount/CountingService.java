package com.viepovsky.rebarcount;

class CountingService {
    private RebarCount rebarCount;

    RebarCount calculateRebarsLengthInBeam(BeamRebars rebars) {
        initRebarCount();
        calculateUpperRebars(rebars);
        calculateLowerRebars(rebars);
        calculateStirrup(rebars);
        return rebarCount;
    }

    private void initRebarCount() {
        rebarCount = new RebarCount();
    }

    private void calculateUpperRebars(BeamRebars rebars) {
    }

    private void calculateLowerRebars(BeamRebars rebars) {
    }

    private void calculateStirrup(BeamRebars rebars) {
    }
}
