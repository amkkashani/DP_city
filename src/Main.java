import java.util.*;
import javax.swing.tree.*;

class Untitled {

    public static  int n;
    public static  int m;
    public static  int n2;
    public static  int m2;
    public static  int[][] theArr;
    public static  int[][] theArr2;

    public static  int[][] theFinal;
    public static ArrayList<String>names;
    public static void main(String[] args) {
        names = new ArrayList<String>();
        theGetter();
        theGetter2();
        theMather();
        test(n,m);

    }

    public static  void theGetter(){
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        theArr = new int[n][m];
        theFinal = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                theArr[i][j] = s.nextInt();
            }
        }
    }

    public static  void theGetter2(){
        System.out.println("**");
        Scanner s = new Scanner(System.in);
        n2 = s.nextInt();
        m2 = s.nextInt();
        theArr2 = new int[n][m];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                theArr2[i][j] = s.nextInt();
            }
        }
    }

    public static void theMather(){
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(j==1){
                    theFinal[i][j] = theArr[i][j];
                }
                else {
                    theFinal[i][j] = theMinMiner(i, j);
                }
            }
        }
    }

    public static int theMinMiner(int ii,int jj){
        int min,key;
        min = 100000;

        for (int i = 0; i < n; i++) {
            key = theFinal[i][jj-1] + theArr2[i][ii];
            if (i == ii) {
                key = theFinal[i][jj-1] + theArr[i][jj-1];
            }
            if (key<min) {
                min = key;
            }
        }
        return min;
    }

    public static void test(int n,int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("("+ theFinal[i][j]);
            }
            System.out.println("");

        }
    }
};

