package com.sangupta.clitools.natural;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.sangupta.jerry.http.WebInvoker;
import com.sangupta.jerry.http.WebResponse;
import com.sangupta.jerry.print.ConsoleTable;
import com.sangupta.jerry.util.AssertUtils;
import com.sangupta.jerry.util.GsonUtils;

public class EarthQuakes {
	
	private static final String BASEURI = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_day.geojson";
	
	public static void main(String[] args) {
		WebResponse response = WebInvoker.getResponse(BASEURI);
		if(response == null) {
			System.out.println("Unable to fetch earthquake details from the internet");
			return;
		}
		
		if(!response.isSuccess()) {
			System.out.println("Error while fetching earthquake details from the internet");
			return;
		}
		
		Quakes quakes = GsonUtils.getGson().fromJson(response.getContent(), Quakes.class);
		if(quakes == null || AssertUtils.isEmpty(quakes.features)) {
			System.out.println("No earthquake reports could be found.");
			return;
		}
		
		Collections.sort(quakes.features);
		
		ConsoleTable table = new ConsoleTable();
		table.addHeaderRow("Intensity", "Place", "Time");
		for(Feature feature : quakes.features) {
			table.addRow(feature.properties.mag, feature.properties.place, new Date(feature.properties.time));
		}
		table.write(System.out);
		
		System.out.println("\nTotal earthquakes reported for the day: " + quakes.features.size());
	}
	
	private static class Quakes {
		
		String type;
		
		Metadata metadata;
		
		List<Feature> features;
		
	}
	
	private static class Metadata {
		
		long generated;
		
		String url;
		
		String title;
		
		int status;
		
		String api;
		
		int count;
	}
	
	private static class Feature implements Comparable<Feature> {
		
		Props properties;
		
		Geometry geometry;
		
		String id;

		@Override
		public int compareTo(Feature other) {
			if(other == null) {
				return -1;
			}
			
			if(other.properties == null) {
				return -1;
			}
			
			if(this.properties == null) {
				return 1;
			}
			
			if(this.properties.time < other.properties.time) {
				return 1;
			}
			
			if(this.properties.time > other.properties.time) {
				return -1;
			}
			
			return 0;
		}
	}
	
	private static class Props {
		
		float mag;
		
		String place;
		
		long time;
		
		long updated;
		
		int tz;
		
		String url;
		
		String detail;
		
		int felt;
		
		float cdi;
		
		int tsunami;
		
		int sig;
		
		String code;
		
		String ids;
		
		int nst;
		
		float dmin;
		
		float rms;
		
		float gap;
		
		String title;
	}
	
	private static class Geometry {
		
		float[] coordinates;
		
		String id;
		
	}

}
