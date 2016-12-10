package xin.minimumspanningtree;

import lombok.Data;

/**
 * Created by Xin on 8/18/2016.
 */
@Data
public class VertexContainer {
    String vertex;
    int weight;

    public VertexContainer(String vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
