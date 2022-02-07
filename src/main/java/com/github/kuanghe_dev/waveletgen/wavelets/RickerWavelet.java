package com.github.kuanghe_dev.waveletgen.wavelets;

public class RickerWavelet extends Wavelet {
    public RickerWavelet(int length, int dt, double f0) {
        super(length, dt);

        f0 /= 1000.0;
        double om2 = Math.pow(2. * Math.PI * f0, 2);
        double a2 = 4. / om2;

        for (int i = 0; i < time.size(); i++) {
            double t = time.get(i);
            double arg = t * t / a2;
            trace.add((1.0 - 2.0 * arg) * Math.exp(-arg));
        }
    }
}
