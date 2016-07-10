package io.matthd.driverbase.player.mongo;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import io.matthd.driverbase.player.Group;
import io.matthd.driverbase.player.GroupContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Matt on 2016-07-10.
 */
public class MongoGroupContainer implements GroupContainer {

    private MongoDatabase database;
    private DBCollection groupsColl;
    private List<Group> groups;

    public MongoGroupContainer(MongoDatabase database) {
        this.database = database;
        this.groupsColl = database.getCollection("groups");
        this.groups = new ArrayList<>();

        reloadGroups();
    }

    @Override
    public List<Group> getAllGroups() {
        return groups;
    }

    @Override
    public MongoGroup getGroupByName(String name) {
        for (Group group : groups) {
            if(group instanceof MongoGroup) {
                MongoGroup mongoGroup = (MongoGroup) group;

                if (mongoGroup.getName().equalsIgnoreCase(name)) {
                    return mongoGroup;
                }
            }
        }
        return null;
    }

    @Override
    public List<String> getGroupPermissions(Group group) {
        List<String> perms  = new ArrayList<>(group.getAllPermissions());
        return perms;
    }

    @Override
    public void createGroup(String name) {

    }

    @Override
    public void deleteGroup(Group group) {

    }

    public void reloadGroups() {
        groups.clear();

        DBCursor cursor = groupsColl.find();

        for (DBObject obj : cursor) {
            MongoGroup group = new MongoGroup((String) obj.get("name"), UUID.fromString(obj.get("priority").toString()), (Integer) obj.get("priority"));
            groups.add(group);
        }
    }

    public MongoGroup getGroupFromObject(DBObject object) {
        for (Group group : groups) {
            if (group instanceof MongoGroup) {
                MongoGroup mongoGroup = (MongoGroup) group;
                if (mongoGroup.getDBObject() == object) {
                    return mongoGroup;
                }
            }
        }
        return null;
    }
}
