/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindistansion;
import java.util.Scanner;


public class MinDistansion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
              int n ,x[],y[];
           double min;     
           System.out.print("Enter the number of points: "); //ввод количества точек
           Scanner in = new Scanner(System.in);
           n=in.nextInt();
           System.out.println("Enter the coordinates of the points");
           y=new int [n];   
           x=new int [n];        
           for (int i = 0; i<n; i++)            //ввод  точек
           {
               System.out.print("Type X"+i+" ");
               x[i]=in.nextInt();
               System.out.print("Type Y"+i+" ");
               y[i]=in.nextInt();
           }
           min=Math.sqrt((x[1]-x[0])*(x[1]-x[0])+(y[1]-y[0])*(y[1]-y[0]));//1ое min расстояние 
              for (int i = 0; i<n; i++)
           {
                 for (int j =0 ; j<n; j++)
                {
                     if ((Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]))<min)&&(i!=j)) //сравнение расстояния между точек
                             min=Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
                             
                }
           
           }
               System.out.print("Min = " + min);    
    }
    
}
