package datastructures;

public class UFDS {

    private final int [] parents;
    private final int [] rank;

    public UFDS(int n) {
        this.parents = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = 0;
        }
    }

    public int findSet(int i) {
        return (this.parents[i] == i) ? i : findSet(this.parents[i]);
    }

    public boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j) {
        if (this.isSameSet(i, j)) {
            return;
        }
        int pi = findSet(i), pj = findSet(j);
        if (this.rank[pi] > this.rank[pj]) {
            this.parents[pj] = pi;
        } else {
            this.parents[pi] = pj;
            if (rank[pi] == rank[pj]) {
                rank[pj]++;
            }
        }
    }

}
