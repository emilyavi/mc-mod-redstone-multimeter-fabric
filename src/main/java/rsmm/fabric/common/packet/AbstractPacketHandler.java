package rsmm.fabric.common.packet;

import java.util.HashMap;
import java.util.Map;

import io.netty.buffer.Unpooled;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import rsmm.fabric.common.packet.types.ToggleMeterPacket;

public abstract class AbstractPacketHandler {
	
	public static final Identifier PACKET_IDENTIFIER = new Identifier("rsmm-fabric");
	
	protected Packet<?> encodePacket(AbstractRSMMPacket packet) {
		PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());
		
		PacketType packetType = PacketType.fromPacket(packet);
		if (packetType == PacketType.INVALID) {
			throw new IllegalStateException("Unable to encode packet: " + packet.getClass());
		}
		buffer.writeByte(packetType.getIndex());
		
		packet.encode(buffer);
		
		return toCustomPayloadPacket(buffer);
	}
	
	protected abstract Packet<?> toCustomPayloadPacket(PacketByteBuf buffer);
	
	protected AbstractRSMMPacket decodePacket(PacketByteBuf buffer) throws InstantiationException, IllegalAccessException {
		byte index = buffer.readByte();
		
		PacketType type = PacketType.fromIndex(index);
		if (type == PacketType.INVALID) {
			throw new IllegalStateException("Unable to decode packet type: " + index);
		}
		AbstractRSMMPacket packet = type.getClazz().newInstance();
		
		packet.decode(buffer);
		
		return packet;
	}
	
	public abstract void sendPacket(AbstractRSMMPacket packet);
	
	private enum PacketType {
		
		INVALID(0, null),
		TOGGLE_METER(1, ToggleMeterPacket.class);
		
		private static final PacketType[] PACKET_TYPES;
		private static final Map<Class<? extends AbstractRSMMPacket>, PacketType> PACKET_TO_TYPE;
		
		static {
			PACKET_TYPES = new PacketType[values().length];
			PACKET_TO_TYPE = new HashMap<>();
			
			for (PacketType packetType : values()) {
				PACKET_TYPES[packetType.index] = packetType;
				PACKET_TO_TYPE.put(packetType.clazz, packetType);
			}
		}
		
		private final int index;
		private final Class<? extends AbstractRSMMPacket> clazz;
		
		PacketType(int index, Class<? extends AbstractRSMMPacket> clazz) {
			this.index = index;
			this.clazz = clazz;
		}
		
		public static PacketType fromIndex(int index) {
			if (index > 0 && index < PACKET_TYPES.length) {
				return PACKET_TYPES[index];
			}
			
			return INVALID;
		}
		
		public static PacketType fromPacket(AbstractRSMMPacket packet) {
			return PACKET_TO_TYPE.getOrDefault(packet.getClass(), INVALID);
		}
		
		public int getIndex() {
			return index;
		}
		
		public Class<? extends AbstractRSMMPacket> getClazz() {
			return clazz;
		}
	}
}
