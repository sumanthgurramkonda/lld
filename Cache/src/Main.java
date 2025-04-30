import com.cache.Cache;
import com.lrucache.LRUCache;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Cache<Integer,String> cache = new LRUCache<>(3);

        cache.put(1,"Alex");
        cache.put(2,"Bob");
        cache.put(3,"Tony");
        cache.put(3,"Sumanth");
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        
    }
}