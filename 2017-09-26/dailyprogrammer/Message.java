package dailyprogrammer;

public class Message {

	private Packet[] packets;
	private int num_packets;
	private int packet_counter;
	
	public Message(Packet p) {
		num_packets = p.getTotalPackets();
		packets = new Packet[num_packets];
		packets[p.getPacketId()] = p;
		packet_counter = 1;
	}
	
	public void addPacket(Packet p) {
		packets[p.getPacketId()] = p;
		packet_counter++;
	}
	
	public void printMessage() {
		int i = 0;
		do {
			System.out.printf("%s\n", packets[i].toString());
			i++;
		} while (i < num_packets);
	}
	
	public boolean isMessageCompleted() {
		return packet_counter == num_packets;
	}
	
}
