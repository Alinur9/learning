package advance.com.company;

public class TestLru {
    public static void main(String[] args) {
        LruCache cache = new LruCache();

        cache.LruCache(3);
        cache.set(1,10);
        cache.set(2,12);
        cache.set(3,14);//it should remove
        cache.set(2,13);//updated node.value /  valid  key
        cache.set(4,50);
        cache.set(5,60);

        System.out.println(cache.get(4));

    }
}
