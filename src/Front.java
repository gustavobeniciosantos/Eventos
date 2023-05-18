import java.util.Scanner;
public class Front {

    Scanner read = new Scanner(System.in);

    public int menu(){
        write("");
        write("1. Adicionar eventos");
        write("2. Remover evento");
        write("3. Listar eventos futuros");
        write("4. Listar eventos passados");
        write("5. Listar todos os eventos");
        write("0. Sair");

        write("");
        write("Digite a opção: ");

        return read.nextInt();
    }


    public static void write(String text){
        System.out.println(text);
    }

}