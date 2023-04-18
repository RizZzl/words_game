import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Date;

import static java.lang.System.out;

public class RedisStorage {

    private RedissonClient redisson;

    private RKeys rKeys;

    private RScoredSortedSet<String> onlineUsers;

    private RScoredSortedSet<String> newUsers;

    private final static String KEY = "ONLINE_USERS";

    private double getTs() {
        return new Date().getTime() / 1000;
    }

    public void listKeys() {
        Iterable<String> keys = rKeys.getKeys();
        for(String key: keys) {
            out.println("KEY: " + key + ", type:" + rKeys.getType(key));
        }
    }

    void deleteFirst() {
        newUsers.pollFirst();
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        onlineUsers = redisson.getScoredSortedSet(KEY);
        newUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void shutdown() {
        redisson.shutdown();
    }

    void logPageVisit(int user_id) {
        onlineUsers.add(getTs(), String.valueOf(user_id));
    }

    Object getElement(int a){
        return newUsers.valueRange(a,a);
    }
    void add(String v){
        newUsers.addAndGetRevRank(getTs(),v);
    }

    RScoredSortedSet<String> getUser(){
        return newUsers;
    }

    void delete(Object o){
        newUsers.remove(o);
    }

    void deleteOldEntries(int secondsAgo) {
        onlineUsers.removeRangeByScore(0, true, getTs() - secondsAgo, true);
    }

    int calculateUsersNumber() {
        return onlineUsers.count(Double.NEGATIVE_INFINITY, true, Double.POSITIVE_INFINITY, true);
    }
}