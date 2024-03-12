public class tableMaker {

    private static int[] arr;
    public static char[] tabHeader;

    public tableMaker(int n) {
        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = 0;
            System.out.print(tabHeader[i] + " | ");
        }
        System.out.print("OP");
        System.out.println();
        print(0, 0);
        print(1, 0);
    }

    public static int[] getArr() {
        return arr;
    }

    public void print(int a, int i){
        arr[i] = a;

        if(i == arr.length-1){
            for(int ii=0; ii<=i; ii++){
                System.out.print("--+-");
            }
            System.out.print("--");
            System.out.println();
            for(int n: arr)
                System.out.print(n + " | ");

            SOPeditor.calculator(arr);
            System.out.println();
        }else{
            print(0, i+1);
            print(1, i+1);
        }
    }
}
