import java.util.Scanner;

/**
 * 牛客网比较傻逼，还要自己写参数输入的过程，如果不知道Scanner这样的工具，用System.in进行接收要写很多代码。
 * 参考：https://www.runoob.com/java/java-scanner-class.html
 */
public class ScannerTest {
  public static void main(String[] args) {
    readString();
  }


  /**
   * 区分next和nextLine
   */
  private static void readString() {
    Scanner scanner = new Scanner(System.in);

    StringBuilder builder = new StringBuilder();

    // next()每次读取一个参数，nextLine()读取整行参数。
    while (scanner.hasNext()) {
      String item = scanner.next();
      System.out.println("read next: " + item);

      // 需要一个字符表示退出，不然next不会自己停下。
      if (item.equals("exit")) {
        break;
      }

      builder.append(item).append(" ");
    }

    scanner.close();
    System.out.println(builder.toString());
  }


  /**
   * 输入一串整数
   * 每次输入一个整数（按回车表示一个完成），如果碰到非整数就退出while循环。
   */
  private static void readInts() {
    Scanner scanner = new Scanner(System.in);

    StringBuilder builder = new StringBuilder();

    // next()每次读取一个参数，nextLine()读取整行参数。
    while (scanner.hasNextInt()) {
      int item = scanner.nextInt();
      System.out.println("read int: " + item);
      builder.append(item).append(" ");
    }

    scanner.close();
    System.out.println(builder.toString());
  }


}