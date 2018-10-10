package com.osoto.connections.model;

import java.util.Map;
import java.util.Set;

/**
 * Connections class contains map of city connections. 
 * 
 * @author osoto
 *
 */
public class Connections {
	private Map<String, Set<String>> cities;

	public Map<String, Set<String>> getCities() {
		return cities;
	}

	public void setCities(Map<String, Set<String>> cities) {
		this.cities = cities;
	}
	
}
