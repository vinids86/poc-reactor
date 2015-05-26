package br.com.uolinc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MixedJson {

	private String method;
	private WeatherJson weatherJson;
	private FacebookJson facebookJson;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public WeatherJson getWeatherJson() {
		return weatherJson;
	}

	public void setWeatherJson(WeatherJson weatherJson) {
		this.weatherJson = weatherJson;
	}

	public FacebookJson getFacebookJson() {
		return facebookJson;
	}

	public void setFacebookJson(FacebookJson facebookJson) {
		this.facebookJson = facebookJson;
	}
}
