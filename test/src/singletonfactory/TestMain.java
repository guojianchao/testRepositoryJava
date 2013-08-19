package singletonfactory;

public class TestMain {
	public static void main(String[] args) {

		TestStream ts2 = TestStream.getTest();
		ts2.setName("jim");
		System.out.println(ts2.getName());
		TestStream ts = TestStream.getTest();
		ts.setName("tom");
		System.out.println(ts.getName());

		ts.getInfo();
		ts2.getInfo();

		System.out.println(100000>>25000);
		if (ts == ts2) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

//		TestMain t = new TestMain();
//		long lo = t.RSHash("guojianchao");
//		long lo1 = t.JSHash("guojianchao");
//		long lo2 = t.PJWHash("guojianchao");
//		long lo3=t.APHash("guojianchao");
//		long lo4 =t.BKDRHash("guojianchao");
//		long lo5 =t.BPHash("guojianchao");
//		long lo6 =t.DEKHash("guojianchao");
//		long lo7=t.DJBHash("guojianchao");
//		long lo8=t.ELFHash("guojianchao");
//		long lo9=t.FNVHash("guojianchao");
//		long lo10=t.SDBMHash("guojianchao");
//		
//		System.out.println(lo);
//		System.out.println(lo1);
//		System.out.println(lo2);
//		System.out.println(lo3);
//		System.out.println(lo4);
//		System.out.println(lo5);
//		System.out.println(lo6);
//		System.out.println(lo7);
//		System.out.println(lo8);
//		System.out.println(lo9);
//		System.out.println(lo10);
		
		
		
		
		
		
		
	}

	public static long RSHash(String str) {
		int b = 378551;
		int a = 63689;
		long hash = 0;
		for (int i = 0; i < str.length(); i++) {
			hash = hash * a + str.charAt(i);
			a = a * b;
		}
		return hash;
	}

	public long JSHash(String str) {
		long hash = 1315423911;
		for (int i = 0; i < str.length(); i++) {
			hash ^= ((hash << 5) + str.charAt(i) + (hash >> 2));
		}
		return hash;
	}

	public long PJWHash(String str) {
		long BitsInUnsignedInt = (long) (4 * 8);
		long ThreeQuarters = (long) ((BitsInUnsignedInt * 3) / 4);
		long OneEighth = (long) (BitsInUnsignedInt / 8);
		long HighBits = (long) (0xFFFFFFFF) << (BitsInUnsignedInt - OneEighth);
		long hash = 0;
		long test = 0;
		for (int i = 0; i < str.length(); i++) {
			hash = (hash << OneEighth) + str.charAt(i);
			if ((test = hash & HighBits) != 0) {
				hash = ((hash ^ (test >> ThreeQuarters)) & (~HighBits));
			}
		}
		return hash;
	}

	public long ELFHash(String str) {
		long hash = 0;
		long x = 0;
		for (int i = 0; i < str.length(); i++) {
			hash = (hash << 4) + str.charAt(i);
			if ((x = hash & 0xF0000000L) != 0) {
				hash ^= (x >> 24);
			}
			hash &= ~x;
		}
		return hash;
	}

	public long BKDRHash(String str) {
		long seed = 131; // 31 131 1313 13131 131313 etc..
		long hash = 0;
		for (int i = 0; i < str.length(); i++) {
			hash = (hash * seed) + str.charAt(i);
		}
		return hash;
	}

	public long SDBMHash(String str) {
		long hash = 0;
		for (int i = 0; i < str.length(); i++) {
			hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash;
		}
		return hash;
	}

	public long DJBHash(String str) {
		long hash = 5381;
		for (int i = 0; i < str.length(); i++) {
			hash = ((hash << 5) + hash) + str.charAt(i);
		}
		return hash;
	}

	public long DEKHash(String str) {
		long hash = str.length();
		for (int i = 0; i < str.length(); i++) {
			hash = ((hash << 5) ^ (hash >> 27)) ^ str.charAt(i);
		}
		return hash;
	}

	public long BPHash(String str) {
		long hash = 0;
		for (int i = 0; i < str.length(); i++) {
			hash = hash << 7 ^ str.charAt(i);
		}
		return hash;
	}

	public long FNVHash(String str) {
		long fnv_prime = 0x811C9DC5;
		long hash = 0;
		for (int i = 0; i < str.length(); i++) {
			hash *= fnv_prime;
			hash ^= str.charAt(i);
		}
		return hash;
	}

	public long APHash(String str) {
		long hash = 0xAAAAAAAA;
		for (int i = 0; i < str.length(); i++) {
			if ((i & 1) == 0) {
				hash ^= ((hash << 7) ^ str.charAt(i) ^ (hash >> 3));
			} else {
				hash ^= (~((hash << 11) ^ str.charAt(i) ^ (hash >> 5)));
			}
		}
		return hash;
	}

}
