package io.matthd.driverbase.player;

import java.util.List;
import java.util.UUID;

/**
 * Created by Matt on 2016-07-10.
 */
public interface OfflinePlayerContainer {

    List<OfflinePlayer> getOnlinePlayers();

    List<OfflinePlayer> getPlayersByGroup(Group group);

    OfflinePlayer getPlayerByName(String name);

    OfflinePlayer getPlayerByUniqueId(UUID uuid);
}
