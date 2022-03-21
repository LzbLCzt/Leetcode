package Graph.Union_Find;

/**
���鼯
 */
public class A {
    public static void main(String[] args) {

    }
}

class UnionFind{
    private int[] parent;   //��¼parent[i] = j -�� ��ʾ�ڵ�i�ĸ��ڵ� = j�ڵ�
    private int count;  //��¼���鼯����ͨ��������ʼ����ֵ = �ڵ����

    public int getCount(){
        return count;
    }

    //��ʼ��
    public UnionFind(int n){
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    //���ҽڵ�x�ĸ��ڵ�
    public int find(int x){
        while (x != parent[x]){
            parent[x] = parent[parent[x]];  //ѹ��·���Ż�:�õ�ǰ�ڵ�ĸ��ڵ� = ��ǰ�ڵ㸸�ڵ�ĸ��ڵ㣻
            x = parent[x];
        }
        return x;
    }

    //�ϲ������ڵ�����Ӧ�ļ��ϣ���������ڵ���ͬһ�����ϣ��Ͳ����κβ���
    /*
    �ϲ�˼·��
        1. �ȷֱ��ҵ������ڵ�ĸ��ڵ�
        2. ������һ�����ڵ������һ�����ڵ�����
     */
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootX) return;

        parent[rootX] = rootY;  //��rootX�ĸ��ڵ��� rootY
        count--;    //�ϲ��ɹ�����ͨ����-1��
    }
}
