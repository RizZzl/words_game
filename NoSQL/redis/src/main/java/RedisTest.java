import java.util.Random;

public class RedisTest {

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();

        for (int i = 0; i < 20; i++) {
            redis.logPageVisit(i);
            Thread.sleep(10);
        }

        int a = 0;
        int size = redis.getUser().size();
        for (int j = 0; ; j++) {
            if (a == size) {
                a = 0;
            }
            Object user = redis.getUser().first();
            System.out.println("- На главной странице показываем пользователя " + user);
            redis.add((String) user);

            if (j % 10 == 0 && j != 0) {
                int userId = new Random().ints(0, 20).findFirst().getAsInt();
                redis.add(String.valueOf(userId));
                System.out.println("> Пользователь " + userId + " оплатил платную услугу");
                Thread.sleep(100);
            }
            a++;
            Thread.sleep(100);
        }
    }
}
