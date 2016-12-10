package xin.graph;

import lombok.Data;

/**
 * Created by Xin on 8/17/2016.
 */
@Data
public class Vertex {
    String value;
    int numOfPaths;

    public Vertex(String value) {
        this.value = value;
        this.numOfPaths = 0;
    }
}
