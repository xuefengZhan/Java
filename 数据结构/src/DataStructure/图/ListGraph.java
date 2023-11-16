package DataStructure.图;

import java.util.*;

/**
 * 图的邻接矩阵实现方式
 * @param <V>  顶点值
 * @param <E>  边的权重
 */
public class ListGraph<V, E> implements Graph<V, E>{

    private static class Vertex<V, E> {
        V value;
        Set<Edge<V,E>> inEdges = new HashSet<>();
        Set<Edge<V,E>> outEdges = new HashSet<>();

        public Vertex(V value){
            this.value = value;
        }

    }

    private static class Edge<V,E>{
        E weight;
        Vertex<V,E> from;
        Vertex<V,E> to;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }
    }
    //顶点集合 如果v相同怎么办？
    private Map<V,Vertex<V,E>> vertices = new HashMap<>();
    //边的Set集合
    private Set<Edge<V, E>> edges = new HashSet<>();


    @Override
    public int edgesSize() {
        return edges.size();
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public void addVertex(V v) {
        if(vertices.containsKey(v)) return;
        vertices.put(v, new Vertex<>(v));
    }

    @Override
    public void addEdge(V from, V to) {
        addEdge(from, to, null);
    }

    @Override
    public void addEdge(V from, V to, E weight) {
        //添加边依赖于顶点才能添加
        Vertex<V,E> fromVertex = vertices.get(from);
        if(fromVertex == null){
            fromVertex = new Vertex<>(from);
            vertices.put(from,fromVertex);
        }

        Vertex<V, E> toVertex = vertices.get(to);
        if(toVertex == null){
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        Edge<V,E> edge = new Edge<>(fromVertex,toVertex);
        edge.weight = weight;

        //如果以前出发点已经有了这条边  先删除再添加
        if(fromVertex.outEdges.remove(edge)){
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }

        fromVertex.outEdges.add(edge);
        toVertex.outEdges.add(edge);
        edges.add(edge);
    }

    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex= vertices.remove(v);
        if(vertex != null){
            Set<Edge<V, E>> outEdges = vertex.outEdges;
            Set<Edge<V, E>> inEdges = vertex.inEdges;

            // 用迭代器是因为被删除的顶点自身也要将这些边删除，删除只能用迭代器删除
            for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext();) {
                Edge<V, E> edge = iterator.next(); // 遍历到的该点出去的边
                edge.to.inEdges.remove(edge);// 获取终点进入的边,并从中删除遍历到的边
                iterator.remove(); // 将当前遍历到的元素edge从集合vertex.outEdges中删掉
                edges.remove(edge);
            }

            // 迭代器遍历集合vertex.inEdges, 删除所有进入该点的边
            for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext();) {
                Edge<V, E> edge = iterator.next(); // 遍历到的进入该点的边
                edge.from.outEdges.remove(edge); // 获取起点出去的边,并从中删除遍历到的边
                iterator.remove(); // 将当前遍历到的元素edge从集合vertex.inEdges中删掉
                edges.remove(edge);
            }

        }
    }

    @Override
    public void removeEdge(V from, V to) {
        // 根据传入的from获得起点,不存在则不需要删除
        Vertex<V, E> fromVertex = vertices.get(from);
        if(fromVertex == null) return;

        // 根据传入的to找到终点,不存在则不需要删除
        Vertex<V, E> toVertex = vertices.get(to);
        if(toVertex == null) return;

        // 根据起点和终点获得边,然后删除
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        if(fromVertex.outEdges.remove(edge)){
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
    }
}
