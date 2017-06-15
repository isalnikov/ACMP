package ru.isalnikov.tobox;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Перечислите все проблемы, которые вы видите в данном коде:
 *
 * @author Igor Salnikov
 */
public class Test3 {

    abstract class Digest {

        private Map<byte[], byte[]> cache = new HashMap<byte[], byte[]>();

        public byte[] digest(byte[] input) {
            byte[] result = cache.get(input);
            if (result == null) {
                synchronized (cache) {
                    result = cache.get(input);
                    if (result == null) {
                        result = doDigest(input);
                        cache.put(input, result);
                    }
                }
            }
            return result;
        }

        protected abstract byte[] doDigest(byte[] input);
    }
}
