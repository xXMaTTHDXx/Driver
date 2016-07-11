package io.matthd.driverbase.player.mongo;

import com.mongodb.*;
import io.matthd.driverbase.player.Database;
import io.matthd.driverbase.player.MongoKeys;

/**
 * Created by Matt on 2016-07-10.
 */
public class MongoDatabase implements Database {

    private ServerAddress address;
    private MongoClientOptions options;

    private MongoClient client;
    private DB db;

    public MongoDatabase(ServerAddress address, MongoClientOptions options) {
        this.address = address;
        this.options = options;
        this.connect();
    }

    @Override
    public void connect() {
        client = new MongoClient(address, options);
        this.db = client.getDB(MongoKeys.DB.get());
    }

    @Override
    public void disconnect() {
        client.close();
    }

    public DB getDb() {
        return db;
    }

    public DBCollection getCollection(String name) {
        DBCollection coll = db.getCollection(name);
        if (coll == null) return null;
        return coll;
    }
}
