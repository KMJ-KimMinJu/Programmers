import java.util.*;

class Solution {
    
      static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        // 우선 순위 큐 활용
        @Override
        public int compareTo(Edge e) {
            return weight - e.weight;
        }
    }
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        parent = new int[n+1];
        
        //대표노드 초기화
        for(int i = 1; i<= n; i++){
            parent[i] = i;
        }
        
        
        for(int i = 0; i<costs.length; i++){
            int s = costs[i][0];
            int e = costs[i][1];
            int w = costs[i][2];
            
            queue.offer(new Edge(s,e,w));
        }
        
        int weight = 0;
        
        while(!queue.isEmpty()){
            Edge edge = queue.poll(); //가중치가 제일 작은 간선 가져오기

            //시작노드와 끝 노드의 부모가 같으면 --> 싸이클 연결된 거
            if(find(edge.start) != find(edge.end)){
                union(edge.start, edge.end);
                weight += edge.weight;
            }
        }
        
        return weight;
    }
    
        //대표노드 합치기
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }

    // 부모 노드 찾기
    public static int find(int n) {
        if(parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }
}