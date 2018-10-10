package com.osoto.connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.osoto.connections.model.Connections;

/**
 * City Connections configuration class used to load 
 * and make available city connections via Spring bean.
 * 
 * @author osoto
 *
 */
@Configuration
public class CityConnectionsConfiguration {
	
	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	/**
	 * Bean representation of CityGraph. It reads file city.txt in 
	 * src/main/resource classpath and loads all city connections 
	 * into a CityGraph object. The CityGraph object can be 
	 * used by any class wiring this object.
	 * 
	 * @return CityGraph
	 * 
	 */
	public Connections getCityConnections() throws IOException {
		Connections cg = new Connections();
		Map<String, Set<String>> cities = new HashMap<>();
		
		Resource resource = resourceLoader.getResource("classpath:city.txt");
		InputStream inputStream = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        
        String line = "";
        String[] cityLineArry = new String[2];
        // Read file and store city connection into map
		while ((line = reader.readLine()) != null) {
			cityLineArry = line.split(",");
			String city1 = cityLineArry[0].trim();
			String city2 = cityLineArry[1].trim();
			
			// Set the city and its connecting city in CityGraph
			if(cities.containsKey(city1)) {
				cities.get(city1).add(city2);
			} else {
				Set<String> adjCity = new HashSet<>();
				adjCity.add(city2);
				cities.put(city1, adjCity);
			}
			
			if(cities.containsKey(city2)) {
				cities.get(city2).add(city1);
			} else {
				Set<String> adjCity = new HashSet<>();
				adjCity.add(city1);
				cities.put(city2, adjCity);
			}
		}
		
		cg.setCities(cities);
		return cg;
	}

}
