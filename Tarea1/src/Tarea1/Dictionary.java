    package Tarea1;

    import java.util.HashMap;
    public class Dictionary<K, V> {
        private HashMap<K, V> map = new HashMap<>();

        public void put(K key, V value) {
            map.put(key, value);
        }

        public V get(K key) {
            if (!map.containsKey(key)) {
                throw new IllegalArgumentException("Key not found: " + key);
            }
            return map.get(key);
        }
        public boolean containsKey(K key) {
            return map.containsKey(key);
        }
    }