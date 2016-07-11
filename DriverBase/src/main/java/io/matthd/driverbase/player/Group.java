package io.matthd.driverbase.player;

import java.util.List;

/**
 * Created by Matt on 2016-07-10.
 */
public interface Group {

    /**
     * Returns the parents or lower end groups of this one.
     */
    List<Group> getParents();

    List<String> getLocalPermissions();

    List<String> getAllPermissions();

    void addParent(Group group);

    void removeParent(Group group);

    Integer getPriority();

    void setPriority(Integer priority);

    void reloadPermissions();
}
