package io.matthd.driverbase.player.mongo;

import io.matthd.driverbase.player.Group;
import io.matthd.driverbase.player.OfflinePlayer;
import io.matthd.driverbase.player.OfflinePlayerContainer;

import java.util.List;
import java.util.UUID;

/**
 * Created by Matt on 2016-07-10.
 */
public class MongoOfflinePlayerContainer implements OfflinePlayerContainer {

    private MongoDatabase database;
    private MongoGroupContainer groupContainer;

    public MongoOfflinePlayerContainer(MongoDatabase database) {
        this.database = database;
    }

    @Override
    public List<OfflinePlayer> getPlayersByGroup(Group group) {
        return null;
    }

    @Override
    public OfflinePlayer getPlayerByName(String name) {
        return null;
    }

    @Override
    public OfflinePlayer getPlayerByUniqueId(UUID uuid) {
        return null;
    }

    @Override
    public void savePlayerData(OfflinePlayer player) {

    }

    @Override
    public void deletePlayerData(OfflinePlayer player) {

    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setGroupContainer(MongoGroupContainer container) {
        this.groupContainer = container;
    }

    public MongoGroupContainer getGroupContainer() {
        return groupContainer;
    }
}
