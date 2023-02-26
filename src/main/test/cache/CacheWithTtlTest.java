package cache;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CacheWithTtlTest {
    private CacheWithTtl cache;

    @Before
    public void setUp() {
        cache = new CacheWithTtl();
    }

    @Test
    public void shouldReturnEmptyIfCacheIsEmpty() {
        assertTrue(cache.get("some-key").isEmpty());
    }

    @Test
    public void shouldReturnValueIfNotExpired() {
        cache.set("key", "value");
        assertEquals("value", cache.get("key").get());
    }

    @Test
    public void shouldReturnEmptyIfValueIsExpired() throws InterruptedException {
        cache.set("key", "value");
        Thread.sleep(3000);

        assertTrue(cache.get("key").isEmpty());
    }

    @Test
    public void shouldReturnValueWhenKeyIsReset() throws InterruptedException {
        cache.set("key", "value");
        assertEquals("value", cache.get("key").get());

        Thread.sleep(3000);

        cache.set("key", "new-value");
        assertEquals("new-value", cache.get("key").get());
    }
}
