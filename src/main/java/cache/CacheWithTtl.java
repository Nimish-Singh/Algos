package cache;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CacheWithTtl {
    private final Map<String, CacheValue> cache;
    private final Duration TTL_DURATION = Duration.ofSeconds(2);

    public CacheWithTtl() {
        cache = new HashMap<>();
    }

    public Optional<String> get(String key) {
        CacheValue value = cache.get(key);

        if (value != null && !isExpired(value)) {
            return Optional.of(value.getValue());
        }

        if (value != null) {
            cache.remove(key);
        }

        return Optional.empty();
    }

    public void set(String key, String value) {
        cache.put(key, new CacheValue(value, Instant.now().plus(TTL_DURATION)));
    }

    private boolean isExpired(CacheValue value) {
        return Instant.now().isAfter(value.getTtl());
    }
}

class CacheValue {
    private final String value;
    private final Instant ttl;

    public CacheValue(String value, Instant ttl) {
        this.value = value;
        this.ttl = ttl;
    }

    public String getValue() {
        return value;
    }

    public Instant getTtl() {
        return ttl;
    }
}
