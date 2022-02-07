package com.github.kuanghe_dev.waveletgen.wavelets;

import java.util.ArrayList;
import java.util.List;

public abstract class Wavelet {
    int t0;
    int dt;
    int nt;
    List<Double> time;
    List<Double> trace;

    public Wavelet() {

    }

    public Wavelet(int length, int dt) {
        nt = length / dt + 1;
        t0 = -nt / 2 * dt;
        this.dt = dt;

        time = new ArrayList<Double>();
        for (int i = 0; i < nt; i++)
            time.add((i - nt / 2) * dt * 1.0);

        trace = new ArrayList<Double>(nt);
    }

    public Wavelet(int t0, int dt, int nt, List<Double> time, List<Double> trace) {
        this.t0 = t0;
        this.dt = dt;
        this.nt = nt;
        this.time = time;
        this.trace = trace;
    }

    public int getT0() {
        return t0;
    }

    public void setT0(int t0) {
        this.t0 = t0;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getNt() {
        return nt;
    }

    public void setNt(int nt) {
        this.nt = nt;
    }

    public List<Double> getTime() {
        return time;
    }

    public void setTime(List<Double> time) {
        this.time = time;
    }

    public List<Double> getTrace() {
        return trace;
    }

    public void setTrace(List<Double> trace) {
        this.trace = trace;
    }

    public void generateTime(int length, int dt) {
        List<Double> time = new ArrayList<>();
        int nt = length / dt + 1;

        for (int i = 0; i < nt; i++) {
            Double t = (i - nt / 2) * dt * 1.0;
            time.add(t);
        }
    }

    @Override
    public String toString() {
        return "Wavelet{" +
                "t0=" + t0 +
                ", dt=" + dt +
                ", nt=" + nt +
                ", time=" + time +
                ", trace=" + trace +
                '}';
    }
};
