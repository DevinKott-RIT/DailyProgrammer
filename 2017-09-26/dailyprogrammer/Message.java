package dailyprogrammer;

public class Message {

	// Packets array
	private Packet[] packets;
	
	// The total number of packets in the message
	private int num_packets;
	
	// The current number of packets received in the message
	private int packet_counter;
	
	/**
	 * Builds the start of a Message object.
	 * @param p: First packet in message received.
	 */
	public Message(Packet p) {
		num_packets = p.getTotalPackets();
		packets = new Packet[num_packets];
		packets[p.getPacketId()] = p;
		packet_counter = 1;
	}
	
	/**
	 * Adds a packet to the message.
	 * @param p: Packet received
	 */
	public void addPacket(Packet p) {
		packets[p.getPacketId()] = p;
		packet_counter++;
	}
	
	/**
	 * Prints out the current message.
	 */
	public void printMessage() {
		int i = 0;
		do {
			System.out.printf("%s\n", packets[i++].toString());
		} while (i < num_packets);
	}
	
	/**
	 * Checks if the message has all of its packets.
	 * @return boolean
	 */
	public boolean isMessageCompleted() {
		return packet_counter == num_packets;
	}
	
}
