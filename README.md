# Wavelet Generatation

We implemented several APIs to allow users to generate time-domain and frequency-domain wavelets. At the moment, two wavelet types are supported: Ricker and Ormsby.

This project is implemented in Java, using the Spring framework.

# APIs Provided

## Time-domain wavelets

  - ``/api/wavelet/ricker/<length>/<samplingInterval>/<frequency>``

  - ``/api/wavelet/ormsby/<length>/<samplingInterval>/<f1>/<f2>/<f3>/<f4>`` 

**Parameters:**

- ``length``: wavelet length in milliseconds
- ``samplingInterval``: sampling interval in milliseconds
- ``frequency``: central frequency in Hertz for Ricker wavelet
- ``f1 through f4``: four frequencies in Hertz for Ormsby wavelet

## Frequency-domain wavelets

  - ``/api/spectrum/ricker/<length>/<samplingInterval>/<frequency>`` 

  - ``/api/spectrum/ormsby/<length>/<samplingInterval>/<f1>/<f2>/<f3>/<f4>`` 

# Examples

- ``/api/wavelet/ricker/200/2/20`` : Generate time-domain Ricker wavelet with 200ms length, 2ms sampling interval and 20 Hz central frequency.

- ``/api/wavelet/ormsby/200/2/5/15/30/50`` : Generate time-domain Ormsby wavelet with 200ms length, 2ms sampling interval and frequencies of 5, 15, 30, and 50 Hz.

- ``/api/spectrum/ricker/200/2/20``  : Generate frequency-domain Ricker wavelet with 200ms length, 2ms sampling interval and 20 Hz central frequency.

- ``/api/spectrum/ormsby/200/2/5/15/30/50`` : Generate frequency-domain Ormsby wavelet with 200ms length, 2ms sampling interval and frequencies of 5, 15, 30, and 50 Hz.

