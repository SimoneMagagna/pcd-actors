package it.unipd.math.pcd.actors;
/**
 * Created by Simone on 28/01/2016.
 */
public class ConcreteActorSystem extends AbsActorSystem {

    private static final ConcreteActorSystem AC = new ConcreteActorSystem();

    public static ConcreteActorSystem getInstance() {
        return AC;
    }

    @Override
    public ActorRef<? extends Message> actorOf(Class<? extends Actor> actor, ActorMode mode) {
        if(this == AC) {
            return super.actorOf(actor, mode);
        }
        else {
            return AC.actorOf(actor, mode);
        }
    }

    @Override
    public ActorRef<? extends Message> actorOf(Class<? extends Actor> actor) {
        if(this == AC) {
            return super.actorOf(actor, ActorMode.LOCAL);
        }
        else {
            return AC.actorOf(actor, ActorMode.LOCAL);
        }
    }

    @Override
    public void stop(ActorRef<?> actor) {
        if(this == AC) {
            super.stop(actor);
        }
        else {
            AC.stop(actor);
        }
    }

    @Override
    public void stop() {
        if(this == AC) {
            super.stop();
        }
        else {
            AC.stop();
        }
    }

    @Override
    public Actor getActor(ActorRef ref) {
        if(this == AC) {
            return super.getActor(ref);
        }
        else {
            return AC.getActor(ref);
        }
    }

    @Override
    protected ActorRef createActorReference(ActorMode mode) {
        if(this == AC) {
            if(mode == ActorMode.LOCAL)
                return new ConcreteActorRef<>();
            else
                throw new IllegalArgumentException();
        }
        else {
            return AC.createActorReference(mode);
        }
    }
}
