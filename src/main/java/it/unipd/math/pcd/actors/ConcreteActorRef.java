package it.unipd.math.pcd.actors;

import it.unipd.math.pcd.actors.exceptions.NoSuchActorException;

/**
 * Created by Simone on 28/01/2016.
 */
public class ConcreteActorRef<T extends Message> implements ActorRef<T> {

    @Override
    public void send(T message, ActorRef to) {
        try{
            Actor actor = ConcreteActorSystem.getInstance().getActor(to);
            ((AbsActor<T>) actor).requestMessage(message, this);
        }
        catch (NoSuchActorException e) {
            throw e;
        }
    }

    @Override
    public int compareTo( ActorRef o) {
        /**
         * @param equals indicates that a reference must be equal to itself
         * @param disequals indicates that a reference must be a different to itself
         */
        final int equals = 0;
        final int disequals = 1;
        return hashCode() == o.hashCode() ? equals : disequals;
    }

}
