import java.util.*;
import javax.swing.tree.*;

class Main {

    public static int n;//cities
    public static int m;//months
    public static ArrayList<String>cityNames;//city names
    public static int[][] monthCost,cityTravel,out;
    public static ArrayList<String> way;
    public static void main(String[] args) {
        way = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.next());
        m = Integer.parseInt(scanner.next());
        cityNames = new ArrayList<String>();
        out = new int[n][m];
        monthCost = new int[n][m];
        cityTravel = new int[n][n];
        //month stay in city costs input
        System.out.println("month stay in city costs input");
        for (int i=0;i<n;i++){
            cityNames.add(scanner.next());
            for (int j=0;j<m;j++){
                monthCost[i][j] = Integer.parseInt(scanner.next());
            }
        }
        //city travel
        System.out.println("city travel");
        for (int i=0;i<n;i++){
            scanner.next();
            for (int j=0;j<n;j++){
                cityTravel[i][j] = Integer.parseInt(scanner.next());
            }
        }



        //calculating
        for (int i=0;i<n;i++){
            out[i][0] = monthCost[i][0];
        }
        for (int i=1;i<m;i++){
            for (int j=0;j<n;j++){
                out[j][i] = bestWay(i,j)+monthCost[j][i];
            }
        }
        for (int i=0;i<n;i++){
            System.out.print(cityNames.get(i)+" ");
            for (int j=0;j<m;j++){
                System.out.print(""+out[i][j]+" ");
            }
            System.out.println();
        }

        int min = -1;
        int index=0;
        for (int i=0;i<n;i++){
            if(min == -1 || out[i][m-1]<min){
                min = out[i][m-1];
                index = i;
            }
        }
        way.add(cityNames.get(index));
        for (int i=m-2;i>=0;i--){
            for (int j=0;j<n;j++){
                if(out[j][i] < out[index][i+1]){
                    if(out[j][i]+cityTravel[j][index]+monthCost[index][i+1] == out[index][i+1]){
                        way.add(cityNames.get(j));
                        index = j;
                        break;
                    }
                }
            }
        }
        System.out.println(min);
        for (int i=m-1;i>=0;i--){
            System.out.print(way.get(i)+" ");
        }


    }

    public static int bestWay(int column,int row) {
        int min =-1;
        for (int i=0;i<n;i++){
            int temp = out[i][column-1]+cityTravel[i][row];
            if(temp < min || min == -1){
                min = temp;
            }
        }
        return min;
    }
};

//