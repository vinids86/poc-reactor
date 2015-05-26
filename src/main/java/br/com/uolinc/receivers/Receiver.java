package br.com.uolinc.receivers;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import reactor.event.Event;
import reactor.function.Consumer;
import br.com.uolinc.model.FacebookJson;
import br.com.uolinc.model.MixedJson;
import br.com.uolinc.model.WeatherJson;

@Service
public class Receiver implements Consumer<Event<String>> {

    RestTemplate restTemplate = new RestTemplate();

    public void accept(Event<String> ev) {
    	FacebookJson facebookJson = restTemplate.getForObject("http://graph.facebook.com/vinids86", FacebookJson.class);
		WeatherJson weatherJson = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=London,uk", WeatherJson.class);
		
		MixedJson mixedJson = new MixedJson();
    	mixedJson.setMethod(ev.getData());
		mixedJson.setFacebookJson(facebookJson);
		mixedJson.setWeatherJson(weatherJson);
        System.out.println("Method: " + mixedJson.getMethod());
        System.out.println("FacebookJson\n" + mixedJson.getFacebookJson());
        System.out.println("WeatherJson\n" + mixedJson.getWeatherJson());
    }
}
