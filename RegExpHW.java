package com.mera.training.myHW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;

import com.mera.training.core.Regexps;

public class RegExpHW {

	final static Logger logger = Logger.getLogger(Regexps.class);

	public static void main(String[] args) {

		final String output = "System configuration:\n" + "Blades: \n";
		System.out.print(output);
		System.out.print(getBlades(output));
		
		System.out.print("\n");
		
		final String output2 = "System Configuration: \n Blades: 0-0 | 0-26 | 0-1 | 0-28 | 0-25 | 1-0 | 1-25 \n";
		System.out.print(output2);
		System.out.print(getBlades(output2));

		// TODO Auto-generated method stub
	}

	private static List<String> getBlades(String output) {
		final String regexp = "(\\d{1,}-\\d{1,})";
		List<String> blades = new ArrayList<String>();
		Pattern p = Pattern.compile(regexp);
		Matcher m = p.matcher(output);
		while (m.find()) {
			blades.add(m.group(1));
		}
		return blades;
	}

}
