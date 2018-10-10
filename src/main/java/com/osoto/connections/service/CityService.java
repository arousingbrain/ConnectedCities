package com.osoto.connections.service;

/**
 * CityService is used to determine if cities are connected.
 * 
 * @author osoto
 *
 */
public interface CityService {
	
	String CITY_IS_CONNECTED = "yes";
	String CITY_IS_NOT_CONNECTED = "no";
	
	/**
	 * Returns 'yes' if cities are connected 
	 * or 'no' if cities are not connected
	 * 
	 * @return boolean
	 */
	String connectedCities(String origin, String destination);

}
