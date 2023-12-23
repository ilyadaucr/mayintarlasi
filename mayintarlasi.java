import java.util.Random;
import java.util.Scanner;

public class mayintarlasi {

    char matrix[][];
    String NumField[][];
    public void Run() {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen satır giriniz: ");
        int cizgi = input.nextInt();
        System.out.print("Lütfen sütun giriniz: ");
        int sutun = input.nextInt();
        createField(cizgi, sutun);
        AddMines(cizgi, sutun);
        ShowField(cizgi, sutun);
        int loopSize=(cizgi*sutun)-(int)((cizgi*sutun)/4);
        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");
        while (loopSize>0)
        {

            for (int i = 0; i < cizgi; i++) {
                for (int j = 0; j < sutun; j++) {
                    System.out.print(NumField[i][j] + " ");
                }
                System.out.print("\n");
            }
            int toplam = 0;
            System.out.print("Satır giriniz: ");
            int cizgi1 = (input.nextInt()) - 1;
            System.out.print("Sütun giriniz: ");
            int sutun2 = (input.nextInt()) - 1;
            if (cizgi >= cizgi1 && sutun >= sutun2 && cizgi1 >= 0 && sutun2 >= 0) {
                if (matrix[cizgi1][sutun2] == '*') {
                    System.out.println("Game Over!");
                    break;
                }
                else
                {
                    if (cizgi1 - 1 >= 0 && sutun2 - 1 >= 0)
                        if (matrix[cizgi1 - 1][sutun2 - 1] == '*')
                            toplam++;

                    if (cizgi1 - 1 >= 0)
                        if (matrix[cizgi1 - 1][sutun2] == '*')
                            toplam++;

                    if (cizgi1 - 1 >= 0 && sutun2 + 1 < sutun)
                        if (matrix[cizgi1 - 1][sutun2+1] == '*')
                            toplam++;

                    if (sutun2 - 1 >= 0)
                        if (matrix[cizgi1][sutun2-1] == '*')
                            toplam++;

                    if (sutun2 + 1 <sutun)
                        if (matrix[cizgi1][sutun2+1] == '*')
                            toplam++;

                    if (cizgi1 + 1 < cizgi && sutun2 - 1 >= 0)
                        if (matrix[cizgi1 +1][sutun2-1] == '*')
                            toplam++;

                    if (cizgi1 + 1 < cizgi )
                        if (matrix[cizgi1 + 1][sutun2] == '*')
                            toplam++;

                    if (cizgi1 + 1 < cizgi && sutun2+ 1 < sutun)
                        if (matrix[cizgi1 + 1][sutun2+1] == '*')
                            toplam++;


                    NumField[cizgi1][sutun2] = String.valueOf(toplam);
                }
            }
            else
            {
                System.out.println("Yanlış değer girdiniz.");
            }

            System.out.println("=======================");
            loopSize--;

            if (loopSize==0){
                System.out.println("Oyunu Kazandınız !");

                for (int i = 0; i < cizgi; i++) {
                    for (int j = 0; j < sutun; j++) {
                        System.out.print(NumField[i][j] + " ");
                    }
                    System.out.print("\n");
                }
            }
        }
    }
    public void createField(int cizgi,int sutun)
    {
        matrix = new char[cizgi][sutun];
        NumField=new String[cizgi][sutun];
        for (int i=0;i<cizgi;i++){
            for (int j=0;j<sutun;j++){
                matrix[i][j]='-';
                NumField[i][j]="-";
            }
        }
    }
    public void AddMines(int cizgi,int sutun) // Mayın ekleme
    {
        int mayinSayisi=(int)((cizgi*sutun)/4);

        for (int i=0;i<mayinSayisi;i++) // Mayın ekleme
        {
            int randomX=(int)(Math.random()*cizgi);
            int randomY=(int)(Math.random()*sutun);
            if (matrix[randomX][randomY]=='*'){
                mayinSayisi++;
            }
            else {
                matrix[randomX][randomY]='*';
            }
        }
    }

    public void ShowField(int cizgi,int sutun) // Tarlanın mayınlı halini gösterme
    {
        System.out.println("Mayınların Konumu");
        for (int i=0;i<cizgi;i++){
            for (int j=0;j<sutun;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.println("=======================");
    }
}
