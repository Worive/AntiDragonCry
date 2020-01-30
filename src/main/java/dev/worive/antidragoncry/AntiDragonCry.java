package dev.worive.antidragoncry;

import com.comphenix.protocol.Packets;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ConnectionSide;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiDragonCry extends JavaPlugin {
    @SuppressWarnings( "deprecation" )
    @Override
    public void onEnable() {
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this, ConnectionSide.SERVER_SIDE, Packets.Server.WORLD_EVENT) {
            @Override
            public void onPacketSending(PacketEvent event) {
                int effectId = event.getPacket().getIntegers().read(0);

                if (effectId == 1018) {
                    event.setCancelled(true);
                }
            }
        });
    }
}