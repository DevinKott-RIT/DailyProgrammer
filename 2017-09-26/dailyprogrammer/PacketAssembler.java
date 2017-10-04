package dailyprogrammer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PacketAssembler {
	
	public static void main(String[] args) {
		final String FILE_NAME = "./2017-09-26/challenge_input.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(new File(FILE_NAME)))) {
			String s = "";
			
			// The Message map holds all of the current messages waiting for packets to arrive.
			Map<Integer, Message> map = new HashMap<Integer, Message>();
			while ((s = br.readLine()) != null) {
				Packet p = new Packet(s);
				
				// Add each packet to a new or existing message
				if (map.containsKey(p.getMessageId())) {
					map.get(p.getMessageId()).addPacket(p);
				} else {
					Message newMessage = new Message(p);
					map.put(p.getMessageId(), newMessage);
				}
				
				// Print out message if it's completed
				if (map.get(p.getMessageId()).isMessageCompleted()) {
					map.get(p.getMessageId()).printMessage();
					map.remove(p.getMessageId());
				}
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
