package com.github.kuanghe_dev.waveletgen.wavelets;

public class OrmsbyWavelet extends Wavelet {
    private double sinc(double x) {
        x = (x == 0 ? 1.0e-20 : x) * Math.PI;
        return Math.sin(x) / x;
    }

    private double numerator(double f, double t) {
        return Math.pow(sinc(f * t), 2) * Math.pow((Math.PI * f), 2);
    }

    public OrmsbyWavelet(int length, int dt, double f1, double f2, double f3, double f4) {
        super(length, dt);

        double pf43 = Math.PI * (f4 - f3);
        double pf21 = Math.PI * (f2 - f1);
        double max = Double.NEGATIVE_INFINITY;
        double t;

        for (int i = 0; i < time.size(); i++) {
            t = time.get(i) / 1000.0;
            trace.add(numerator(f4, t) / pf43 - numerator(f3, t) / pf43 -
                      numerator(f2, t) / pf21 + numerator(f1, t) / pf21);
            max = Math.max(max, trace.get(i));
        }

        for (int i = 0; i < time.size(); i++)
            trace.set(i, trace.get(i) / max);
    }
}
