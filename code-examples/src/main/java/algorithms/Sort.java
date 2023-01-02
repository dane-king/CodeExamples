package algorithms;

public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.quickSortArray();
    }

    public void quickSortArray(){
        int[] arr={5, 9, 4, 6, 5, 3};
        quickSort(arr,0,arr.length-1);
        System.out.println("sorted array is " + arr);

    }

    private void quickSort(int[] arr, int begin, int end){
        if(begin < end) {
            int partitionIdx = partition(arr, begin, end);

            quickSort(arr, begin, partitionIdx - 1);
            quickSort(arr, partitionIdx + 1, end);
        }
    }
    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
