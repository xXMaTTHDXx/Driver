package io.matthd.driverbase.player;

/**
 * Created by Matt on 2016-07-10.
 */
public enum MongoKeys {
    DB("driver"), USERS("users"), GROUPS("groups")
    ;

    String path;
    MongoKeys(String path) {
        this.path = path;
    }

    public String get() {
        return path;
    }
}
