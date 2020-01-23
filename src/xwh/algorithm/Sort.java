//package xwh.algorithm;

public class Sort {

  private int[] testCase = { 9, 2, 5, 3, 7, 6, 1, 8, 4, 3, 1 };

  public static void print(int[] array) {
    StringBuffer str = new StringBuffer("[");
    if (array != null) {
      boolean isFirst = true;
      for (int item : array) {
        if (isFirst) {
          isFirst = false;
        } else {
          str.append(", ");
        }
        str.append(item);
      }
    }
    str.append("]");

    System.out.println(str);
  }

  public static void main(String[] args) {
    System.out.println("Test");
    Sort test = new Sort();

    print(test.testCase);

    test.insertSort();

  }

  /**
   * 直接插入排序 思路：将剩余元素插入到已经排好的元素中
   */
  public void insertSort() {
    if (testCase == null || testCase.length < 2) {
      print(testCase);
      return;
    }

    //int currentIndex = 1;
    for(int i=1; i<testCase.length; i++) {
      
      // 循环交换位置，直到到达插入的位置。
      int j = i;
      int temp = 0;
      while(j > 0 && testCase[j] < testCase[j-1]) {
        temp = testCase[j];
        testCase[j] = testCase[j-1];
        testCase[j-1] = temp;
        j--;
      } 
    }

    print(testCase);
  }
}