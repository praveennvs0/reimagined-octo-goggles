package newPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TravellingIsFun {

	
	public static List<Integer> connectedCities(int n, int g, List<Integer> originCities, List<Integer> destinationCities) {
	    int[] root = new int[n + 1];
	    int[] cityIds = new int[n + 1];

	    for (int i = 0; i <= n; i++) {
	        root[i] = i;
	        cityIds[i] = 1;
	    }

	    for (int i = g + 1; i <= n; i++)
	        for (int j = 2 * i; j <= n; j += i)
	            unionFind(j, i, root, cityIds);

	    List<Integer> result = new ArrayList<>(originCities.size());
	    Iterator<Integer> srcIterator = originCities.iterator();
	    Iterator<Integer> destinationIterator = destinationCities.iterator();

	    while (srcIterator.hasNext() && destinationIterator.hasNext())
	        result.add(findLeader(srcIterator.next(), root) == findLeader(destinationIterator.next(), root) ? 1 : 0);

	    return result;
	}

	private static void unionFind(int a, int b, int[] root, int[] cityIds) {
	    int aRoot = findLeader(a, root);
	    int bRoot = findLeader(b, root);

	    if (aRoot == bRoot)
	        return;

	    if (cityIds[aRoot] < cityIds[bRoot]) {
	        root[aRoot] = root[bRoot];
	        cityIds[bRoot] += cityIds[aRoot];
	    } else {
	        root[bRoot] = root[aRoot];
	        cityIds[aRoot] += cityIds[bRoot];
	    }
	}

	private static int findLeader(int a, int[] root) {
	    while (a != root[a])
	        a = root[a];
	    return a;
	}

}
