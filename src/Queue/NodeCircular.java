package Queue;

public class NodeCircular {
    Object data;
    NodeCircular next;
    NodeCircular( Object object ){ this ( object, null); }
    NodeCircular( Object object, NodeCircular sesudah ){
        data = object;
        next = sesudah;
    }
    Object getObject(){ return data; }
    NodeCircular getNext() { return next; }
}