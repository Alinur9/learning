import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LruCacheTest {

    @Test
    void get() {
        LruCache cache = new LruCache(5);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.put(5,5);
        cache.put(6,6);
        int tester = 1;
        for (int i = 2; i < 7; i++) {
            int value = cache.get(i);
            tester++;
            assertTrue(value == tester);
            if (i == 6){
                value = cache.get(1);
                tester = -1;
                assertTrue(value == tester);
            }
        }
        cache.put(7,7);
        assertTrue(cache.get(7) == 7);
        assertTrue(cache.get(2)== -1);
        assertTrue(cache.get(4)== 4);
        cache.put(3,9);
        cache.put(8,8);
        assertTrue(cache.get(8) == 8);
        assertTrue(cache.get(3) == 9);
        assertTrue(cache.get(5) == -1);
    }

}