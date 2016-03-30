package it.unipd.math.pcd.actors;

import java.util.LinkedList;

/**
 * Created by Simone on 28/01/2016.
 */
public final class MailBox<T extends Message> {
    private LinkedList<MailBoxMessage<T>> mailbox=new LinkedList<>();

    public void add(MailBoxMessage<T> m){
        mailbox.addFirst(m);
    }

    public void removeLast(){
        mailbox.removeLast();
    }

    public T getMessage(){
        return mailbox.getLast().getMessage();
    }

    public ActorRef<T> getSender(){
        return mailbox.getLast().getActorRef();
    }

    public int size(){
        return mailbox.size();
    }
}
