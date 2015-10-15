package vesi; 
import java.util.Scanner ; 
public class Vesi { 
public static int summ (int n, int a[], int b[]) //считает сумму ( передаваемые параметры: количество предметов; массив весов; бинарный массив) 
{ 
int s=0; 
for (int i=0; i<n; i++) 
if (b[i]==1)//суммируем веса массива а, если под соответствующим номером в массиве б стоит 1 
{ 
s+=a[i]; 
} 
return s;//возвращает сумму выбранных весов 
} 

public static void main(String[] args) { 
// задаем переменные, ввод данных 
int summa=0,massiv[],n, b[] ; 
System.out.print("Enter the number of points: "); 
Scanner in = new Scanner(System.in); 
n=in.nextInt();//число предметов 
massiv=new int [n]; 
b=new int [n]; 
System.out.println("Enter your weight:"); 
for (int i = 0; i<n; i++)//ввод весов 
{ b[i]=0; 
massiv[i]=in.nextInt(); 
summa=summa+massiv[i];// подсчет суммы всех весов 
} 
// проверка: алгоритм продолжит выполнение только если сумма весов четная (только тогда их можно уравновесить) 
if((summa%2)!=0) { System.out.println("The balance can not be in equilibrium"); 
} 
else { 
summa=summa/2;//вес для уравношивания 
System.out.println("The weight of each cup = " + summa); 
int k=n-1; 
int m=0; 
int dl=0;//прерменная-флажок, говорящая, что равновесие уже найдено 
int sy = 0;//переменная-флажок, сообщающая, что найдена сумма 100 
// перебираем возможные сочетания с помощью бинарного массива (двоичные числа) 
// запускаем цикл до 2 в степени n (количество двоичных чисел) 
for (int j = 1; j<Math.pow(2,n) ; j++){ 
int h=1;//переменная-фложок для выхода из цикла, меняющего массив б 
if(k==0) 
k=n-1; 
//цикл смены двоичного числа от 00...01 до 11..10 (меняем цикл б) 
while(h!=0) 

if( b[k]==0){ 
b[k]=1; 
if(m==1){ 
for(int u=k+1;u<n;u++) 
b[u]=0; 
m=0; 
k=n-1; 
} 

else{ 
k=n-1; 
} 
h=0; 
} 
else{ 
k--; 
m=1; 
h=1; 

} 

int s = Vesi.summ(n, massiv, b);// считаем сумму 
if(s==100)//проверяем на =100 
sy=1; 
//если сумма равна равновесной, то начинаем вывод 
if ((s==summa)&&(dl!=1)) 
{ //выводим те, что равны 1 и составили нужную сумму 
for (int l=0; l<n;l++){ 
if (b[l]==1){ 
System.out.print(massiv[l]+" "); 
} 
} 
System.out.print( "- "); 
//выводим остальные 
for (int l=0; l<n;l++){ 
if (b[l]==0){ 
System.out.print(massiv[l]+" "); 
} 
dl=1; 
} 

} 

} 
//проверяем флажок на =100 
if(sy==1) 
System.out.println("is equal to the sum of100"); 
else{ 
System.out.println("the sum is not equal to 100"); 
} 
} 
}
}
