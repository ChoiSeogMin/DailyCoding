package goorm.unionAndFind;

public class UnionAndFind {

    /***
     * HashSet보다 성능이 훨씬 좋다.
     */
    private static int[] parent = new int[10];

    public static void main(String[] args) {

        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }

        union(2,3);
        union(2,4);
        System.out.println(find(3));
        System.out.println(find(2));

    }

    private static int find(int p){
        if(p == parent[p])
            return p;
        else {
            int root = find(parent[p]);
            parent[p] = root;//경로 압축
            return root;
        }
    }

    private static void union(int p,int s){
        p = find(p);
        int sRoot = find(s);
        parent[sRoot] = p;
    }
}
