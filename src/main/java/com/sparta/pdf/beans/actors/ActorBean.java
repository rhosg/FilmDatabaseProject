package com.sparta.pdf.beans.actors;

import com.sparta.pdf.components.Actor;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ConversationScoped
public class ActorBean implements Serializable {

    private Actor activeActor;

//    @Inject
//    FilmActorRetriever filmActorRetriever;

    @Inject
    Conversation conversation;

    public String setActiveActor(Actor actor){
        activeActor = actor;
        if(conversation.isTransient()){
            conversation.begin();
        }
        return "actorDetails";
    }

    public Actor getActiveActor() {
        return activeActor;
    }



}
