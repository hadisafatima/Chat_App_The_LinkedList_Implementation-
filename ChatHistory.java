import java.util.Scanner;

public class ChatHistory {
    private Message msg ;
    private ChatHistory next ;
    private ChatHistory head = this ;

    public ChatHistory(Message msg) {
        this.msg = msg;
    }

    public ChatHistory addMsg(Message msg){
        if(head == null){
            head = new ChatHistory(msg) ;
            System.out.println("new msg added successfully-");
            return head ;
        }

        ChatHistory chatHistory = head ; // 1
        while (chatHistory != null){
            if (chatHistory.next == null){
                chatHistory.next = new ChatHistory(msg) ;
                System.out.println("Message added successfully-");
                return head;
            }
            chatHistory = chatHistory.next ; // 2, 3, null
        }

        chatHistory.next = new ChatHistory(msg);

        return head ;
    }

    public ChatHistory dltMsg(String msg){
        if (head == null){
            System.out.println("No Messages to delete!!");
            return this;
        }

        if (head.msg.getMsgContent().equalsIgnoreCase(msg)){
            head = head.next ;
            System.out.println("Message deleted successfully!!");
            return head ;
        }

        ChatHistory chatHistory = head ;
        while (chatHistory.next != null){
            if (chatHistory.next.msg.getMsgContent().equalsIgnoreCase(msg)){
                chatHistory.next = chatHistory.next.next ;
                System.out.println("Message deleted successfully-");
                return head ;
            }
            chatHistory = chatHistory.next ;
        }

        System.out.println("No Message found-");
        return head ;
    }

    public static void main(String[] args) {
        System.out.println("\t\t\t\tW E L C O M E   T O   T H E   C H A T T I N G   A P P L I C A T I O N-");

        System.out.print("\t\t\t\t\t\t");
        for (int i = 0 ; i <=50 ; i++){
            // have to apply here a delay of 0.2s for each iteration-
            try{
                Thread.sleep(50);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.print(".");
        }

        Scanner sc = new Scanner(System.in) ;
        System.out.print("\nEnter User1 name : ");
        String user1 = sc.nextLine() ;
        System.out.print("Enter User2 name : ");
        String user2 = sc.nextLine();
        System.out.println("\t\t\t\tYOU CAN START CHATTING-(in order to exit chatting u can press \"X\")\n");

        System.out.println(user1);
        String user1Msg = sc.nextLine() ;
        ChatHistory user1Chats = new ChatHistory(new Message(user1 , user1Msg)) ;

        System.out.println(user2);
        String user2Msg = sc.nextLine() ;
        ChatHistory user2Chats = new ChatHistory(new Message(user2 , user2Msg)) ;

        ChatHistory h = user1Chats ;
        ChatHistory s = user2Chats ;

        while (h != null || s != null){
            System.out.println(user1);
            user1Msg = sc.nextLine();
            if (user1Msg.equalsIgnoreCase("x")){
                break;
            }
            h.next = new ChatHistory(new Message(user1 , user1Msg));
            System.out.println(user2);
            user2Msg = sc.nextLine();
            if (user2Msg.equalsIgnoreCase("x")){
                break;
            }
            s.next = new ChatHistory(new Message(user2 , user2Msg));

            h = h.next ;
            s = s.next ;
        }

        System.out.println("\n\n\t\t\t\tOVER ALL CHAT TILL NOW IS GIVEN BELOW-");
        ChatHistory user1History = user1Chats ;
        ChatHistory user2History = user2Chats ;
        while(user1History != null || user2History != null){
            if (user1History != null){
                System.out.print(user1 + ": ");
                System.out.println(user1History.msg.getMsgContent());
            }else {
                break;
            }

            if (user2History != null){
                System.out.print(user2 + ": ");
                System.out.println(user2History.msg.getMsgContent());
            }else {
                break;
            }

            user1History = user1History.next ;
            user2History = user2History.next ;
        }


        ChatHistory chatHistory = user1Chats ;
        System.out.println("\n\nCHATS BY " + chatHistory.msg.getSenderName());
        while(chatHistory != null){
            System.out.println(chatHistory.msg.getMsgContent());
            chatHistory = chatHistory.next ;
        }

        ChatHistory chatHistory1 = user2Chats ;
        System.out.println("\n\nCHATS BY " + chatHistory1.msg.getSenderName());
        while (chatHistory1 != null){
            System.out.println(chatHistory1.msg.getMsgContent());
            chatHistory1 = chatHistory1.next ;
        }


        ChatHistory historyUpdated = user1Chats ;
        System.out.println("\n\nUPDATED CHATS OF " + historyUpdated.msg.getSenderName());
        ChatHistory updatedChatsOfUser1 = historyUpdated.dltMsg("salam badshahh");
        while(updatedChatsOfUser1 != null){
            System.out.println(updatedChatsOfUser1.msg.getMsgContent());
            updatedChatsOfUser1 = updatedChatsOfUser1.next ;
        }
    }

}
