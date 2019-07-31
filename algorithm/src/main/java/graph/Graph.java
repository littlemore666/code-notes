package graph;

import java.util.LinkedList;

/**
 * @author mochenghui
 * @date 2019/7/4 9:39
 * 邻接表存储图(无向图)
 */
public class Graph {

    private int v;//顶点个数
    private LinkedList<Integer>[] adj;//邻接表

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    //无向图存储两次
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    //广度优先算法，搜索s->t的路劲
    public static void bfs(int s, int t) {

    }

    //深度优先算法，搜索s->t的路劲
    public static void dfs(int s, int t) {

    }


}
