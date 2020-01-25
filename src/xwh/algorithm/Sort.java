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

    // int[] result = test.insertSort();
    // int[] result = test.bubbleSort(test.testCase);
    int[] result = test.selectSort(test.testCase);

    print(result);

  }

  /**
   * 选择排序 每次遍历一趟，选出最小（最大）值和前面的交换。
   */
  public int[] selectSort(int[] target) {
    for (int i = 0; i < target.length; i++) {
      int exchangIndex = i;
      for (int j = i + 1; j < target.length; j++) {
        if (target[j] < target[exchangIndex]) {
          exchangIndex = j;
        }
      }
      if (exchangIndex != i) {
        int temp = target[i];
        target[i] = target[exchangIndex];
        target[exchangIndex] = temp;
      }
    }
    return target;
  }

  /**
   * 直接插入排序 思路：将剩余元素插入到已经排好的元素中
   */
  public int[] insertSort() {
    // 从第二个元素开始，向前遍历达到目的位置（找到比当前元素小的为止）
    for (int i = 1; i < testCase.length; i++) {
      int j = i;
      int temp = 0;
      while (j > 0 && testCase[j] < testCase[j - 1]) { // 循环交换位置，直到到达插入的位置。
        temp = testCase[j];
        testCase[j] = testCase[j - 1];
        testCase[j - 1] = temp;
        j--;
      }
    }
    return testCase;
  }

  /**
   * 冒泡排序 依次比较和交换相邻元素，每趟将最小(最大)值浮到顶部。
   */
  public int[] bubbleSort(int[] target) {
    boolean changed = false;
    int temp = 0;
    for (int i = 0; i < target.length - 1; i++) {
      changed = false;
      for (int j = 0; j < target.length - i - 1; j++) {
        if (target[j] > target[j + 1]) {
          temp = target[j];
          target[j] = target[j + 1];
          target[j + 1] = temp;
          changed = true;
        }
      }
      if (!changed) {
        break;
      }
    }
    return target;
  }

  /**
   * 快速排序 每次取一个基准点，将元素按大于\小于交换到基准点两边。
   */
  public void quickSort(int[] target, int start, int end) {
    if (start == end) {
      return;
    }
    // 这里以中间位置为基准点
    int baseIndex = (start + end) / 2;

  }

  private void quickSortPartition(int[] target, int start, int end) {

  }
  
}