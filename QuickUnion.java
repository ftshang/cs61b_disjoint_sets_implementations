public class QuickUnion implements DisjointSets {

    private int[] parents;

    public QuickUnion(int[] arr) {
        parents = arr;
    }

    public QuickUnion(int size) {
        parents = new int[size];
        for (int i = 0; i < parents.length; i += 1) {
            parents[i] = -1;
        }
    }

    public int find(int p) {
        while (parents[p] >= 0) {
            p = parents[p];
        }
        return p;
    }

    protected int[] getParents() {
        return parents;
    }

    @Override
    public void connect(int q, int p) {
        if (isConnected(q, p)) {
            return;
        }
        int root_q = find(q);
        int root_p = find(p);
        parents[root_q] = root_p;
    }

    @Override
    public boolean isConnected(int q, int p) {
        return find(q) == find(p);
    }
}
