import java.util.ArrayList;
import java.util.Arrays;

public class UnionFind {
    private int[] parents;

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        parents = new int[N];
        Arrays.fill(parents, -1);
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        int root = find(v);
        return -1 * parents[root];
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        return parents[v];
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        int root_v1 = find(v1);
        int root_v2 = find(v2);
        return root_v1 == root_v2;
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException();
        }

        int root = v;
        while (parents[root] >= 0) {
            root = parents[root];
        }

        while (v != root) {
            int temp = parents[v];
            parents[v] = root;
            v = temp;
        }
        return v;
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        if (v1 == v2 || connected(v1, v2)) {
            return;
        }

        int root_v1 = find(v1);
        int root_v2 = find(v2);

        if (parent(root_v1) < parent(root_v2)) {
            parents[root_v1] += parents[root_v2];
            parents[root_v2] = root_v1;
        } else {
            parents[root_v2] += parents[root_v1];
            parents[root_v1] = root_v2;
        }
    }

}