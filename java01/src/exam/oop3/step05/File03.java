package exam.oop3.step05;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/* 문제: c:/javaide의 모든 폴더를 출력하시오.
 * - 그 하위 폴더도 포함한다.
 * 
 * 문제: 폴더를 출력할 때 다음 형식으로 출력하시오.
 * - 출력되는 폴더 이름에 전체 경로를 출력하시오.
 * - c:/javaide
 *   c:/javaide/servers
 *   c:/javaide/servers/tomcat....
 */
public class File03 {

  public static void main(String[] args) {
    File f = new File("c:/javaide/server");
    displayDirectory(f);
  }
  
  // 디렉토리에 들어있는 모든 하위 디렉토리를 출력한다.
  static void displayDirectory(File dir) {
    for (File f : dir.listFiles()) {
      if (f.isDirectory()) {
        System.out.println(f.getAbsolutePath());
        displayDirectory(f); // 재귀호출
      }
    }
  }

}












