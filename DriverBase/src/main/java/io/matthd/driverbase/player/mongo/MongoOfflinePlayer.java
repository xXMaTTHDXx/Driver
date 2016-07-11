package io.matthd.driverbase.player.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import io.matthd.driverbase.player.Group;
import io.matthd.driverbase.player.MongoKeys;
import io.matthd.driverbase.player.OfflinePlayer;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Matt on 2016-07-10.
 */
public class MongoOfflinePlayer implements OfflinePlayer {

    private MongoOfflinePlayerContainer container;

    private UUID uuid;
    private Date firstJoin, lastJoin;
    private Group group;
    private String name;

    public MongoOfflinePlayer(UUID uuid, DBObject playerObj, MongoOfflinePlayerContainer container) {
        this.container = container;

        if (playerObj == null) {
            this.uuid = uuid;
            this.group = container.getGroupContainer().getDefaultGroup();
            return;
        }
        updateFromDB();
    }

    public DBObject getPlayerObject() {
        DBObject obj = new BasicDBObject("uuid", uuid);
        obj.put("firstJoin", this.firstJoin);
        obj.put("lastJoin", this.lastJoin);
        obj.put("group", this.group);
        obj.put("name", this.name);
        return obj;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getUniqueId() {
        return uuid;
    }

    @Override
    public Date getFirstJoin() {
        return firstJoin;
    }

    @Override
    public Date getLastJoin() {
        return lastJoin;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public void setFirstJoin(Date firstJoin) {
        this.firstJoin = firstJoin;
    }

    @Override
    public void setLastJoin(Date lastJoin) {
        this.lastJoin = lastJoin;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void updateFromDB() {
        updateFromDBObject(getPlayerObject());
    }

    public void updateFromDBObject(DBObject object) {
        UUID uuid = UUID.fromString(object.get("uuid").toString());

        DBObject db = container.getDatabase().getCollection(MongoKeys.USERS.get()).findOne(uuid);
        this.name = (String) db.get("name");
        this.group = container.getGroupContainer().getGroupByName((String) db.get("group"));
        this.firstJoin = (Date) db.get("firstJoin");
        this.lastJoin = (Date) db.get("lastJoin");
    }
}
