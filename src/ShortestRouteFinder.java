
import java.util.*;

public class ShortestRouteFinder {

    private final Map<String, Set<AdjacentCity>> connections =
            new HashMap<>();

    /**
     * Adds a bidirectional "edge" between city {@code c1} and city
     * {code c2} with distance {@code d}.
     *
     * @param c1 the first city.
     * @param c2 the second city.
     * @param d  the distance between the two cities.
     * @return a shortest route finder reference.
     */

    public ShortestRouteFinder route(String c1, String c2, int d) {
        
        // this is an undirected network, needs to map both directions
        connections.computeIfAbsent(c1,
                k -> new HashSet<>()).add(new AdjacentCity(c2, d));
        connections.computeIfAbsent(c2,
                k -> new HashSet<>()).add(new AdjacentCity(c1, d));
        return this;
    }

        public Map<String, Integer> computeShortestRoutesFrom (
                String startCity){
            Map<String, Integer> distances = new HashMap<>();
            PriorityQueue<AdjacentCity> q = new PriorityQueue<>();
            q.add(new AdjacentCity(startCity, 0));
            while (!q.isEmpty()) {
                AdjacentCity current = q.remove();
                if (!distances.containsKey(current.target)) {
                    int d = current.distance;
                    distances.put(current.target, d);
                    for (AdjacentCity c : connections.get(current.target)) {
                        q.add(new AdjacentCity(c.target, d + c.distance));
                    }
                }
            }
            return distances;
        }

        public static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
            List<T> result = new ArrayList<>();
            int iFirst = 0;
            int iSecond = 0;
        
            while (iFirst < left.size() && iSecond < right.size()) {
                if (left.get(iFirst).compareTo(right.get(iSecond)) < 0) {
                    result.add(left.get(iFirst));
                    iFirst++;
                } else {
                    result.add(right.get(iSecond));
                    iSecond++;
                }
            }
            while (iFirst < left.size()) {
                result.add(left.get(iFirst));
                iFirst++;
            }
            while (iSecond < right.size()) {
                result.add(right.get(iSecond));
                iSecond++;
            }
            return result;
        }
    

        public static <T extends Comparable<T>> List<T> mergeSort(List<T> a) {
            if (a.size() <= 1) {
                return a;
            }
            List<T> one = a.subList(0, a.size() / 2);
            List<T> two = a.subList(a.size() / 2, a.size());
            one = mergeSort(one);
            two = mergeSort(two);
            List<T> result = merge(one, two);
            return result;
        }
        
    }
