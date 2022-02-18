package com.github.kuanghe_dev.waveletgen.spectra;

import java.util.ArrayList;
import java.util.List;

import com.github.kuanghe_dev.waveletgen.wavelets.Wavelet;

public class Spectrum {
    protected int nf;  // number of discrete frequencies
    protected List<Double> freq;
    protected List<Double> trace;

    public Spectrum(Wavelet wavelet, int padfactor) {
        int nfft = wavelet.getNt() * padfactor;
        nf = nfft / 2 + 1;
        freq = new ArrayList<Double>(nf);
        trace = new ArrayList<Double>(nf);

        double[] real = new double[nfft];
        double[] imag = new double[nfft];
        for (int i = 0; i < nfft; i++) {
            real[i] = 0.0;
            imag[i] = 0.0;
        }

        for (int i = 0; i < wavelet.getNt(); i++)
            real[i] = wavelet.getTrace().get(i);

        Fft.transform(real, imag);

        double denominator = wavelet.getDt() * 0.001 * nfft;
        double specMax = -1;
        for (int i = 0; i < nf; i++) {
            freq.add(i / denominator);
            double spec_db = 20 * Math.log10(Math.sqrt(real[i] * real[i] + imag[i] * imag[i]));
            trace.add(spec_db);
            specMax = Math.max(specMax, spec_db);
        }

        for (int i = 0; i < nf; i++)
            trace.set(i, trace.get(i) - specMax);
    }

    public int getNf() {
        return nf;
    }

    public void setNf(int nf) {
        this.nf = nf;
    }

    public List<Double> getFreq() {
        return freq;
    }

    public void setFreq(List<Double> freq) {
        this.freq = freq;
    }

    public List<Double> getTrace() {
        return trace;
    }

    public void setTrace(List<Double> trace) {
        this.trace = trace;
    }

    @Override
    public String toString() {
        return "Spectrum{" +
                "nf=" + nf +
                ", freq=" + freq +
                ", trace=" + trace +
                '}';
    }
}

