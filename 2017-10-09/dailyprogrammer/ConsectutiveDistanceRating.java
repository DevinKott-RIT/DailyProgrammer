package dailyprogrammer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ConsectutiveDistanceRating {

	public static void main(String[] args) {
		final String FILE_NAME = "./2017-10-09/bonus_input.txt";
		final int DISTANCE = 1;
		int sequence_number = 1;
		try (BufferedReader br = new BufferedReader(new FileReader(new File(FILE_NAME)))) {
			String s = "";
			br.readLine();
			long curTimeNano = System.nanoTime();
			while ((s = br.readLine()) != null) {
				
				// Get all of the integers and add them to a list
				String[] parts = s.split("\\s+");
				Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
				for (int i = 0; i < parts.length; i++) {
					map.put(Integer.parseInt(parts[i]), i);
				}

				// Print out the sequence
				System.out.printf("Sequence: %d\n", sequence_number++);
				System.out.printf("%s\n", Arrays.asList(parts).toString());

				// Find the distance between all of the consectutive numbers.
				int finalDistance = 0;
				Iterator<Entry<Integer, Integer>> entrySet = map.entrySet().iterator();
				Entry<Integer, Integer> first = null;
				Entry<Integer, Integer> next = null;
				while (entrySet.hasNext()) {
					if (next != null) {
						first = next;
					} else {	
						first = entrySet.next();
					}
					Entry<Integer, Integer> second = null;
					if (entrySet.hasNext()) {
						second = entrySet.next();
					} else {
						continue;
					}

					if (second.getKey() - first.getKey() == DISTANCE) {
						finalDistance += Math.abs(first.getValue() - second.getValue());
					}
					next = second;
				}
				System.out.printf("Consectutive Distance: %d\n\n", finalDistance);
			}
			
			long diffNano = System.nanoTime() - curTimeNano;
			double diffMilli = diffNano * 0.000001;
			System.out.printf("Elapsed Time: %.5f\n", diffMilli);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
