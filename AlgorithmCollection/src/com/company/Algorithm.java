package com.company;

import java.util.Arrays;


public class Algorithm {


    /**
     * 선택정렬
     * 배열 요소의 가장 작은 값을 선택해서 가장 앞으로 보내는 정렬방법
     * 시간복잡도
     * 예를들어 10의 원소를 갖고 있는 배열을 선택정렬 했을때
     * 10 * (10+1) / 2 = 55 총 55번 반복
     * 줄여서 N * (N+1)/2 >>> 덧셈나눗셈 생략해서 대략 BigO 표기로
     * O(N*N) 특정 알고리즘의 총 연산횟수 따라서 O(N^2)
     */
    public static int[] selectionSort(int[] array){

        int index=0,min;

        for(int i = 0; i < array.length; i++){

            min = Integer.MAX_VALUE; //원소보다 큰값을 넣어줌

            //한바퀴 돌면서 가장작은 값을 선택
            for(int j = i; j < array.length; j++){  //j는 i값이라 처음엔 10번 다음엔 9번 8번 7번 점점 줄어 들면서 반복
                if(min > array[j]){ // 원소를 하나씩 비교
                    min = array[j];
                    index = j;
                }
            }

            //선택된 값을 가장 앞으로 보냄 스와프
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }

        return array;
    }

    /**
     * 버블정렬
     * 옆에있는 값과 비교해서 더작은 값을 반복적으로 앞으로 보내는 정렬방법
     * 한번의 루프가 끝날때 가장큰값이 맨 뒤로 이동
     * 시간복잡도
     * O(N^2) 선택정렬과 동일하지만 실제 수행시간은 선택정렬 보단 느리다
     * 실제로 수행되는 연산횟수가 더많기때문에
     */
    public static int[] bubbleSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < (array.length-1)-i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 삽입정렬
     * 각 숫자를 적절한 위치에 삽입하는 방법으로 정렬
     * 다른 정렬 방식들은 무조건 위치를 바꾸는 방법이었지만 삽이정렬을 필요할때만 위치를 바꿈
     * 왼쪽에 있는 값들은 이미 정렬되어져 있는상태
     * 시간복잡도
     * O(N^2) 선택,버블 보다 가장빠름 데이터가 어느정도 정렬되어 있을때 가장 효율적임
     * 연산횟수가 가장 적음
     */
    public static int[] insertionSort(int[] array){

        /**
         * [j+1]의 값이 length보다 커지므로 -1을 해준다
         * j가 0일때 j--를 하지 않는다 -1이되므로
         */
        for (int i = 0; i < array.length-1; i++){
            int j = i;
            while (array[j] > array[j+1]){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                if(j!=0){
                    j--;
                }
            }
        }
        return array;
    }


    /**
     * 위의 세가지 정렬방법은 모두 시간복잡도 O(N^2)을 갖는 알고리즘이며
     * 만약 데이터가 10만개 이상일 경우 일반적인 상황에서 사용하기 어려운 알고리즘이다
     *
     ***************************************************************
     * 아래의 정렬방법은 더욱 빠른 정렬 알고리즘 퀵정렬
     * 퀵정렬은 대표적인 '분할정복' 알고리즘이며 평균속도가 O(N*logN)
     * logN은 굉장히 작은 상수
     * 2^10 = 1,000
     * 2^20 = 1,000,000
     * logN이란 100개의 데이터라면 O(N^2)은 100*100 NlogN은 100*10
     * 백만개까지 문제없이 작동
     */


    /**
     * 퀵정렬
     * 특정한 값을 기준으로 큰숫자와 작은 숫자를 서로 교환한 뒤에 배열을 반으로 나눈다
     * 기준값이 있고 이를 피벗(pivot)축이라
     * 기준보다 작은 값을 오른쪽에서부터 찾고 외쪽에서 큰값을 찾아 교환한다
     * 엇갈렸을때 기준값과 작은 값을 바꿈
     * 경우에 따라 O(N^2)의 시간복잡도 이미정렬되어 있는 값을 한번씩 전부 체크해야하므로
     *
     * 이미정렬되어있는 상태라면 삽입정렬일 더 효율 적임
     */


    /**
     파티션 호출할때마다 피벗 기준 왼쪽 작은값, 오른쪽 큰값으로 정렬
     교차지점까지 이동할때까지 왼쪽파트 재귀호출, 오른쪽 파트 재귀 호출 반복
     */
    public static int[] quickSort(int[] arr){
        return quickSort(arr,0,arr.length-1); //재귀호출
    }

    private static int[] quickSort(int[] arr, int start, int end){
                                            //     ⇓⇓
        //오른쪽 파티션 시작 포인트 >>>>>[3]   [0][1][2]/[3][4][5]
        int rightPartStart = partition(arr,start,end);

        //왼쪽 파티션 끝 포인트 >>>>>[2]
        int leftPartEnd = rightPartStart -1;

        if(start < leftPartEnd){//왼쪽 파티션 재귀 호출
            quickSort(arr,start,leftPartEnd);//왼쪽 파트 시작,끝지정
        }
        if(rightPartStart < end){//오른쪽 파티션 재귀 호출
            quickSort(arr,rightPartStart,end);//오른쪽 파트 시작,끝지정
        }
        return arr;
    }

    private static int partition(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2];//가운데 데이터를 기준 데이터로 지정
        while (start<=end){//교차할때까지 반복
            while (arr[start] < pivot)start++;//포인트 오른쪽으로 이동
            while (arr[end] > pivot)end--;//포인트 왼쪽으로 이동
            if(start<=end){//교차하기전 위치 왼쪽 오른쪽 값 반복
                swap(arr,start++,end--);
            }
        }
        return start;//오른쪽파트 첫 포인트 리턴
    }
    private static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


    public static void mergeSort(int[] arr){
        int[] tem = new int[arr.length];
        mergeSort(arr,tem,0,arr.length-1);
    }
    private static void mergeSort(int[] arr, int[] tem, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(arr,tem,start,mid);
            mergeSort(arr,tem,mid+1,end);
            merge(arr,tem,start,mid,end);
        }
    }
    private static void merge(int[] arr, int[] tem, int start,
                              int mid, int end){
//        for(int i = start; i <= end; i++){
//            tem[i] = arr[i];
//        }

        tem = Arrays.copyOf(arr,arr.length);//비교할 배열을 복사
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid && part2 <= end){
            if(tem[part1] <= tem[part2]){//첫파트와 두번째 파트 비교
                arr[index] = tem[part1];//첫파트의 첫번째 요소가 작을때
                part1++;
            }else{//
                arr[index] = tem[part2];//두번째 파트의 첫번째 요소가 작을때
                part2++;
            }
            index++; // 전체인덱스를 추적하기위한 인덱스
        }

        //앞쪽 파트의 데이터가 남아있으면 남아있는만큼 복사()
        for (int i = 0; i <= mid - part1; i++){
            arr[index+i] = tem[part1+i];
        }
    }
}
