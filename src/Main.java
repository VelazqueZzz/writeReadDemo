import java.io.*;
class KtoD {
    public static void main(String args[])
    {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter text ('stop' to quit).");

        // Создание потока вывода типа FileWriter.

        try (FileWriter fw = new FileWriter("test.txt"))
        {
            do {
                System.out.print(": ");
                str = br.readLine();
                if(str.compareTo("stop") == 0) break;
                str = str + "\r\n"; // add newline
                // Запись текстовых строк в файл,
                fw.write(str);
            } while(str.compareTo("stop")   != 0) ;
        } catch(IOException exc) {
            System.out.println("I/O Error: " + exc);
        }


        String s;

        // Создание в классе BufferedReader оболочки с целью заключить
        // в нее класс FileReader и организовать чтение данных из файла.

        try (BufferedReader br2 = new BufferedReader(new FileReader("test.txt")))
        {
            while((s = br2.readLine())   !=  null) {
                System.out.println(s) ;
            }
        } catch(IOException exc) {
            System.out.println("I/O Error: " + exc) ;
        }
    }
}