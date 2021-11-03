

public class AdjacentCity implements Comparable<AdjacentCity> {

    public final String target;
    public final int distance;

    public AdjacentCity(String city, int dist) {
        this.target = city;
        this.distance = dist;
    }

    public int getDistance() {
        return distance;
    }

    public String getTarget() {
        return target;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof AdjacentCity) {
            if (this.target.equals(((AdjacentCity) o).target) && this.distance == ((AdjacentCity) o).distance) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return target.hashCode() + distance;
    }

    @Override
    public int compareTo(AdjacentCity o) {
        return this.distance - o.distance;
    }

    @Override
    public String toString() {
        return target + ":" + distance;
    }

}

