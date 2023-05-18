import java.util.*;
import java.text.*;
public class MakeEvent {

    Front front = new Front();
    Scanner read = new Scanner(System.in);
    ArrayList <String> newArray = new ArrayList<String>();
    ArrayList <Date> dateArray = new ArrayList<Date>();
    Event newEvent = new Event();

    boolean rep = true;
    Date now = new Date();
    String data;
    Date date;


    int i = 1 ;

    public MakeEvent() throws Exception{

        while (rep){
            int menu = front.menu();
            select(menu);
        }//while

    }//makeevent




    public void select(int menu) throws Exception{

        switch(menu){
            case 1: //add
                addEvent();
                break;

            case 2: //remove
                remove();
                break;

            case 3: //list ahead
                listAhead();
                break;

            case 4://list old
                listOld();
                break;

            case 5:
                listAll();
                break;

            case 0: //Exit

                write("Tmj professor");

                rep = false;
        }//switch

    }//select



    public void listAll() {
        write("========EVENTOS LISTADOS========");
        for(int i = 0; i < newArray.size();i++) {
            write((i+1)+"."+newArray.get(i));
        }//for
        write("");
    }

    public void listAhead() {
        write("========EVENTOS FUTUROS========");

        for(int i = 0; i < dateArray.size(); i++){
            boolean isTrue = now.after(dateArray.get(i));
            if(isTrue){
                write(newArray.get(i)+ " ocorrerá na data " + dateArray.get(i));
            }//if
        }//for

    }



    public void listOld() {
        write("========EVENTOS PASSADOS========");
        for(int i = 0; i < dateArray.size(); i++){
            boolean isTrue = now.before(dateArray.get(i));
            if(isTrue){
                write(newArray.get(i)+ " ocorreu na data " + dateArray.get(i));
            }//if
        }//for

    }//listold





    public void remove(){

        write("Qual deseja remover?");

        for(int i = 0; i < newArray.size();i++) {
            write((i+1)+"."+newArray.get(i));
        }//for
        write("0. sair");

        int option = read.nextInt();

        if(option == 0){
            return;
        } else{
            while (option != 0) {

                int index = option - 1;
                if (index >= 0 && index < newArray.size()) {
                    newArray.remove(index);

                }//if

                if (index >= 0 && index < dateArray.size()) {
                    dateArray.remove(index);

                    write("Removido com sucesso");
                }//if
                break;
        }///while

        }//if

    }//remove


    public void addEvent() throws Exception{
        write("Qual o seu evento?");

        String name = read.nextLine();
        newArray.add(name);

        write("");
        write("Qual a data do evento? dd/MM/yyyy");
        data = read.nextLine();
        date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        dateArray.add(date); // add data

        newEvent.setName(name);
        newEvent.setDate(date);
    }



    public void write(String text){
        System.out.println(text);
    }

}