import java.util.HashMap;
 
public class HashMapInfiniteLoop {
	
	private static HashMap<Key, Integer> map = new HashMap<Key, Integer>(4,0.75f);
	public static void main(String[] args) {
		map.put(new Key(9), 9);
		map.put(new Key(17), 17);
		map.put(new Key(1), 1);

		new Thread("ThreadA") {
			public void run() {
				map.put(new Key(5), 33);
				System.out.println(map+"ThreadA");
				System.out.println(map.get(new Key(11)));
			};
		}.start();
		new Thread("ThreadB") {
			public void run() {
				map.put(new Key(3), 33);
				System.out.println(map+"ThreadB");
			};
		}.start();
		
	}
 
}
