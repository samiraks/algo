public class Main{
    public int removeElementInplace(int[] arr,int val)
    {
        int write = 0;
        for (int read = 0; read < arr.length; read++)
        {
            if (arr[read] != val)
            {
                arr[write]=arr[read];
                write++;
            }
        }
        return write;
    }

    public void main (String[] args){
        int[] arr = {1,2,3,4,6,6,7,6};
        int val = 6;
        int size = removeElementInplace(arr,val);
        System.out.println("Новый размер массива: " + size);
        System.out.print("Новый массив: [");
        for (int i = 0; i < size; i++)
        {
            System.out.print(arr[i]);
            if(i < size-1)
            {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
