public class Message {
    private String senderName ;
    private String msgContent ;

    public Message(String senderName, String msgContent) {
        this.senderName = senderName;
        this.msgContent = msgContent;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getMsgContent() {
        return msgContent;
    }
}
