public class QuickFind implements DisjointSets{

    protected int[] id;

    public QuickFind(int x) {
        id = new int[x];

        for (int i = 0; i < id.length; i += 1) {
            id[i] = i;
        }
    }

    /** Connects p to q (items in p's set will take on q's id). */
    @Override
    public void connect(int q, int p) {
        int qId = id[q];
        int pId = id[p];

        for (int i = 0; i < id.length; i += 1) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    @Override
    public boolean isConnected(int q, int p) {
        return id[q] == id[p];
    }
}
