package newcastle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap<String, Handler> handlers = new HashMap<String, Handler>();

    public Game() {
        handlers.put("go", new HandlerGo(this));
        handlers.put("bye", new HandlerBye(this));
        handlers.put("help", new HandlerHelp(this));
        createRooms();

    }

    private void createRooms() {
        Room outside, lobby, pub, study, bedroom;

        //	���췿��
        outside = new Room("�Ǳ���");
        lobby = new Room("����");
        pub = new Room("С�ư�");
        study = new Room("�鷿");
        bedroom = new Room("����");

        //	��ʼ������ĳ���
        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);
        lobby.setExit("west", outside);
        pub.setExit("east", outside);
        study.setExit("north", outside);
        study.setExit("east", bedroom);
        bedroom.setExit("west", study);
        lobby.setExit("up", pub);
        pub.setExit("down", lobby);

        currentRoom = outside;  //	�ӳǱ����⿪ʼ
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("��ӭ�����Ǳ���");
        System.out.println("����һ���������ĵ���Ϸ��");
        System.out.println("�����Ҫ������������ 'help' ��");
        System.out.println();
        showPrompt();
    }

    // ����Ϊ�û�����

    private void printHelp() {
        System.out.println("��·������������������У�go bye help");
        System.out.println("�磺\tgo east");
    }

    public void goRoom(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("����û���ţ�");
        } else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }

    public void showPrompt() {
        System.out.println("����" + currentRoom);
        System.out.print("������: ");
        System.out.println(currentRoom.getExitDesc());
        System.out.println();
    }

    public void play(){
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
            String value = "";
            if(words.length > 1)
                value = words[1];
            if(handler != null)
            {
                handler.doCmd(value);
                if(handler.isBye())
                    break;
                if(handler.isHelp())
                    this.printHelp();

            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printWelcome();
        game.play();
        System.out.println("��л���Ĺ��١��ټ���");
    }

}
