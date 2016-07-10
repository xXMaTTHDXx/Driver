package io.matthd.driverbase.player;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Matt on 2016-07-10.
 */
public interface OfflinePlayer {

    String getName();

    UUID getUniqueId();

    Date getFirstJoin();

    Date getLastJoin();

    Group getGroup();
}
