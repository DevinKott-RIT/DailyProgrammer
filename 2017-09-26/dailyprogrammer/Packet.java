package dailyprogrammer;

public class Packet implements Comparable<Packet> {
	
	private int message_id;
	private int packet_id;
	private int total_packets;
	
	private String message;
	
	public Packet(String input) throws PacketException {
		String[] parts = input.split("\\s+", 4);
		if (parts.length != 4) {
			throw new PacketException("Invalid packet read: '" + input + "'");
		}
		
		try {
			this.message_id = Integer.parseInt(parts[0]);
		} catch (NumberFormatException e) {
			throw new PacketException("Invalid message_id: " + parts[0]);
		}
		
		try {
			this.packet_id = Integer.parseInt(parts[1]);
		} catch (NumberFormatException e) {
			throw new PacketException("Invalid packet_id: " + parts[1]);
		}
		
		try {
			this.total_packets = Integer.parseInt(parts[2]);
		} catch (NumberFormatException e) {
			throw new PacketException("Invalid total_packets: " + parts[2]);
		}
		this.message = parts[3];
	}
	
	public int getMessageId() {
		return message_id;
	}
	
	public int getPacketId() {
		return packet_id;
	}
	
	public int getTotalPackets() {
		return total_packets;
	}
	
	@Override
	public String toString() {
		return message_id + "\t" + packet_id + "\t" + total_packets + "\t" + message;
	}

	@Override
	public int compareTo(Packet arg0) {
		return this.message_id == arg0.message_id ? this.packet_id - arg0.packet_id : this.message_id - arg0.message_id;
	}
	
}
