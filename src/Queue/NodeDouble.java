package Queue;

public class NodeDouble {
    Object data;
    NodeDouble prev, next;
    NodeDouble( Object object ){ this ( object, null, null ); }
    NodeDouble( Object object, NodeDouble sebelum, NodeDouble sesudah ){
        data = object;
        prev = sebelum;
        next = sesudah;
    }
    Object getObject(){ return data; }
    NodeDouble getPrev() { return prev; }
    NodeDouble getNext() { return next; }
}