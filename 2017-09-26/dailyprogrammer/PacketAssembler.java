package dailyprogrammer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		final String FILE_NAME = "./2017-09-26/challenge_input.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(new File(FILE_NAME)))) {
			String s = "";
			List<Packet> packets = new ArrayList<Packet>();
			while ((s = br.readLine()) != null) {
				Packet p = new Packet(s);
				if (packets.size() == 0) {
					packets.add(p);
					continue;
				}
				boolean added = false;
				for (int i = 0; i < packets.size(); i++) {
					Packet packet = packets.get(i);
					if (packet.compareTo(p) > 0) {
						packets.add(i, p);
						added = true;
						break;
					}
				}
				if (!added)
					packets.add(p);
			}
			
			for (Packet p : packets) {
				System.out.println(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PacketException e) {
			e.printStackTrace();
		}
	}
	
}
