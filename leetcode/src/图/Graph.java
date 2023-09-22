package 图;

public interface Graph<V,E>{
    int edgesSize(); 		// 边的数量
    int verticesSize();		// 顶点数量

    void addVertex(V v); 		// 添加顶点
    void addEdge(V from, V to); // 添加边
    void addEdge(V from, V to, E weight);// 添加边

    void removeVertex(V v); 		// 删除顶点
    void removeEdge(V from, V to);	 // 删除边

    interface vertexVisitor<V>{
        boolean visit(V v);
    }
}
