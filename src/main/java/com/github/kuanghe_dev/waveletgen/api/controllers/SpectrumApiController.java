package com.github.kuanghe_dev.waveletgen.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.kuanghe_dev.waveletgen.spectra.Spectrum;
import com.github.kuanghe_dev.waveletgen.wavelets.OrmsbyWavelet;
import com.github.kuanghe_dev.waveletgen.wavelets.RickerWavelet;
import com.github.kuanghe_dev.waveletgen.wavelets.Wavelet;

@RestController
@RequestMapping("/api/spectrum")
public class SpectrumApiController {

	@GetMapping("/ricker/{length}/{dt}/{freq}")
	public Spectrum genRickerWaveletSpectrum(
		@PathVariable("length") Integer length,
		@PathVariable("dt") Integer dt,
		@PathVariable("freq") Double freq
	) {
		Wavelet wavelet = new RickerWavelet(length, dt, freq);

		return new Spectrum(wavelet, 4);
	}

	@GetMapping("/ormsby/{length}/{dt}/{f1}/{f2}/{f3}/{f4}")
	public Spectrum genOrmsbyWaveletSpectrum(
		@PathVariable("length") Integer length,
		@PathVariable("dt") Integer dt,
		@PathVariable("f1") Double f1,
		@PathVariable("f2") Double f2,
		@PathVariable("f3") Double f3,
		@PathVariable("f4") Double f4
	) {
		Wavelet wavelet = new OrmsbyWavelet(length, dt, f1, f2, f3, f4);

		return new Spectrum(wavelet, 4);
	}
}
