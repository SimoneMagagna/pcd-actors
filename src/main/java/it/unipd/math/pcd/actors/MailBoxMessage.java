package it.unipd.math.pcd.actors;

/**
 * Created by Simone on 28/01/2016.
 */

public final class MailBoxMessage<T extends Message> {
    private final T message;
    private final ActorRef<T> sender;
    public MailBoxMessage(T msg,ActorRef<T> s){
        message=msg; sender=s;
    }

    public T getMessage(){
        return message;
    }
    public ActorRef<T> getActorRef(){
        return sender;
    }

}
