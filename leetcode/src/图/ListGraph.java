package 图;

import java.util.*;

/**
 * @ClassName ListGraph
 * @Author zxf
 * @Date 2023/3/3 9:33
 *
 *  图的邻接表实现
 **/
public class ListGraph<V,E> implements Graph<V,E> {

    //内部类 ： 顶点类
    private static class Vertex<V,E>{
        V value;
        Set<Edge<V, E>> inEdges = new HashSet<>(); // 进来的边
        Set<Edge<V, E>> outEdges = new HashSet<>(); // 出去的边

        public Vertex(V value){
            this.value = value;
        }
        @Override
        public boolean equals(Object obj) {
            return Objects.equals(value, ((Vertex<V, E>)obj).value);
        }
        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }
        @Override
        public String toString() {
            return value == null ? "null" : value.toString();
        }
    }
    /**
     * 边
     */
    private static class Edge<V, E> {
        Vertex<V, E> from; // 出发点
        Vertex<V, E> to; // 到达点
        E weight;	// 权值

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }
        @Override
        public boolean equals(Object obj) {
            Edge<V, E> edge = (Edge<V, E>) obj;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }
        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }
        @Override
        public String toString() {
            return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
        }

    }




    // 传入的V与顶点类Vertex的映射
    private Map<V, Vertex<V, E>> vertices = new HashMap<>();
    // 边的Set集合
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
        // 根据传入的参数from找到起点,如果不存在则创建
        Vertex<V, E> fromVertex = vertices.get(from);
        if(fromVertex == null){
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }
        // 根据传入的参数to找到终点,如果不存在则创建
        Vertex<V, E> toVertex = vertices.get(to);
        if(toVertex == null){
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        // 根据出发点与终点,创建边
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight; // 有权值则加上权值,无权值则为null

        // 不管原来是否存在,都先删除此边,再添加进去
        if(fromVertex.outEdges.remove(edge)){
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    /*
     * 删除点
     */
    @Override
    public void removeVertex(V v) {
        // 根据传入的值找到点并删除,不存在则不做操作
        Vertex<V, E> vertex = vertices.remove(v);
        if(vertex == null) return;

        // 迭代器遍历集合vertex.outEdges, 删除所有从该点出去的边
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


    /*
     * 删除边
     */
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
