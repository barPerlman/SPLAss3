package bgu.spl.net.Messages;

import bgu.spl.net.DataBase;

public class RegisterMessage extends Message {

    private String userName;
    private String password;

    public RegisterMessage(){
        super((short) 1);
    }

    public RegisterMessage(String userName,String password){
        super((short) 1);
        this.userName=userName;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String getMsgString() {
        return null;
    }

    @Override
    public String getMsgStringAsAck() {
        return null;
    }

    @Override
    public byte[] getBytes() {
        byte[] opcode = this.shortToBytes(getOpcode());
        byte[] ans = mergeArrayes(opcode,userName.getBytes());
        ans = includeOneByteToArray(ans,getDelimeter());
        ans = mergeArrayes(ans,password.getBytes());
        ans =includeOneByteToArray(ans,getDelimeter());
        return ans;
    }

    @Override
    public short action(DataBase dataBase) {
        return 0;
    }

    @Override
    public Message newMessage(byte b) {
        return null;
    }
}
