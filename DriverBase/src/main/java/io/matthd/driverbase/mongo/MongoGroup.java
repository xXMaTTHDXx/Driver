package io.matthd.driverbase.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import io.matthd.driverbase.player.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Matt on 2016-07-10.
 */
public class MongoGroup implements Group {

    private String name;
    private List<Group> parents;
    private List<String> localPermissions;
    private Integer priority;

    //TODO Assign
    private UUID uuid;

    public MongoGroup(String name, UUID uuid, Integer priority) {
        this.name = name;
        this.priority = priority;
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParents(List<Group> parents) {
        this.parents = parents;
    }

    public void setLocalPermissions(List<String> localPermissions) {
        this.localPermissions = localPermissions;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    @Override
    public List<Group> getParents() {
        return parents;
    }

    @Override
    public List<String> getLocalPermissions() {
        return null;
    }

    @Override
    public List<String> getAllPermissions() {
        List<String> allPermissions = new ArrayList<>(localPermissions);

        for (Group group : parents) {
            allPermissions.addAll(group.getLocalPermissions());
        }
        return allPermissions;
    }

    @Override
    public void addParent(Group group) {

    }

    @Override
    public void removeParent(Group group) {

    }

    @Override
    public Integer getPriority() {
        return null;
    }

    @Override
    public void setPriority(Integer priority) {

    }

    public DBObject getDBObject() {
        DBObject obj = new BasicDBObject("uuid", uuid);
        obj.put("name", name);
        obj.put("parents", parents);
        obj.put("perms", localPermissions);

        return obj;
    }
}
