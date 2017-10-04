package dailyprogrammer;

public class Packet {
	
	// Message ID of packet
	private int message_id;
	
	// Packet ID
	private int packet_id;
	
	// Total number of packets in the message this packet
	// is a part of.
	private int total_packets;
	
	// Message of the packet.
	private String message;
	
	/**
	 * Creates a Packet object from a correct input.
	 * @param input
	 * @throws PacketException
	 */
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
	
	/**
	 * Returns the message ID
	 * @return int
	 */
	public int getMessageId() {
		return message_id;
	}
	
	/**
	 * Returns the packet ID
	 * @return int
	 */
	public int getPacketId() {
		return packet_id;
	}
	
	/**
	 * Returns the total number of packets in the
	 * message that this packet is a part of.
	 * @return int
	 */
	public int getTotalPackets() {
		return total_packets;
	}
	
	/**
	 * Visual representation of a Packet
	 */
	@Override
	public String toString() {
		return message_id + "\t" + packet_id + "\t" + total_packets + "\t" + message;
	}
}
