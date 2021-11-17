public class MyArrayList {
     int len=2;
     int[] arr = new int[len];
     int index = -1;
     int get(int indexNo){
         if(index>index){
             throw new IndexOutOfBoundsException("Index out of Bound." +indexNo);
         }
         else {
             return arr[indexNo];
         }
     }
    public  void add(int num){
        if(!isThereSpace(index)){
            int[] temp = new int[len];
            for(int i=0;i<len;i++){
                temp[i]=arr[i];
            }
            len = len*2;
            arr = new int[len];
            for(int i=0;i<index+1;i++){
                arr[i]=temp[i];
            }
        }

        index++;
        arr[index] = num;

    }
    public  boolean isThereSpace(int index){
        if(index+1<len){
            return true;
        }
        return false;
    }
    public  int remove(int indexNo){
        if(indexNo < 0 || indexNo>arr.length){
            throw new IndexOutOfBoundsException("Index out of Bound");
        }
        int removed = arr[indexNo];

        int[] temp = new int[arr.length-1];
        for(int i=0;i<indexNo;i++){
            temp[i]=arr[i];
        }
        for(int i=indexNo;i<temp.length;i++){
            temp[i]=arr[i+1];
        }
        arr = new int[temp.length];
        for(int i=0;i<temp.length;i++){
            arr[i]=temp[i];
        }
        index--;
        return removed;
    }
    public void print(){
        for(int i=0;i<index+1;i++){
            System.out.println(arr[i]);
        }
    }
}


