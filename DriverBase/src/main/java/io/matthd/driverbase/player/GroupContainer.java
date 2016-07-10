package io.matthd.driverbase.player;

import java.util.List;

/**
 * Created by Matt on 2016-07-10.
 */
public interface GroupContainer {

    List<Group> getAllGroups();

    Group getGroupByName(String name);

    List<String> getGroupPermissions(Group group);

    void createGroup(String name);

    void deleteGroup(Group group);
}
