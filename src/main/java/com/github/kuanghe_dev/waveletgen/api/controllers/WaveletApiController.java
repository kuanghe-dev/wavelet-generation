package com.github.kuanghe_dev.waveletgen.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.kuanghe_dev.waveletgen.wavelets.OrmsbyWavelet;
import com.github.kuanghe_dev.waveletgen.wavelets.RickerWavelet;
import com.github.kuanghe_dev.waveletgen.wavelets.Wavelet;

@RestController
@RequestMapping("/api/wavelets")
public class WaveletApiController {
//	@GetMapping
//	public Wavelet generateWavelet() {
//
////		Wavelet result = new RickerWavelet(200, 2, 30);
//		Wavelet result = new OrmsbyWavelet(200, 2, 5, 10, 30, 50);
//		
//		return result;
//	}
//	
	@GetMapping("/ricker/{length}/{dt}/{freq}")
	public Wavelet generateRickerWavelet(
		@PathVariable("length") Integer length,
		@PathVariable("dt") Integer dt,
		@PathVariable("freq") Double freq
	) {
		Wavelet result = new RickerWavelet(length, dt, freq);
		return result;
	}

	@GetMapping("/ormsby/{length}/{dt}/{f1}/{f2}/{f3}/{f4}")
	public Wavelet generateOrmsbyWavelet(
		@PathVariable("length") Integer length,
		@PathVariable("dt") Integer dt,
		@PathVariable("f1") Double f1,
		@PathVariable("f2") Double f2,
		@PathVariable("f3") Double f3,
		@PathVariable("f4") Double f4
	) {
		Wavelet result = new OrmsbyWavelet(length, dt, f1, f2, f3, f4);
		return result;
	}
	
}