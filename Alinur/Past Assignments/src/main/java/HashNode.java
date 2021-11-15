public class HashNode <K,V>{

        public String Data;
         V value;
         K key;
        HashNode <K,V>next;
        public HashNode(){

        }
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        public HashNode(String data){
            this.Data = data;
        }

        public void setData(String data) {
            this.Data = data;
        }

        public void setNext(HashNode next) {
            this.next = next;
        }

        public String getData() {
            return Data;
        }

        public HashNode getNext() {
            return next;
        }
    }

