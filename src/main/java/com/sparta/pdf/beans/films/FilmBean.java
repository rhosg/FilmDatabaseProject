package com.sparta.pdf.beans.films;


import com.sparta.pdf.components.Film;


import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ConversationScoped
public class FilmBean implements Serializable {

    private Film activeFilm;
//    @Inject
//    FilmSearcher filmSearcher;

    @Inject
    Conversation conversation;

    public String setActiveFilm(Film film){
        activeFilm = film;
        if(conversation.isTransient()){
            conversation.begin();
        }
        return "filmDetails";
    }

    public Film getActiveFilm() {
        return activeFilm;
    }




    public String getCategoriesString() {
        String output = "";

        for(int i=0;i<activeFilm.getCategories().size();i++){
            output+=activeFilm.getCategories().get(i).getName();
            if(i<activeFilm.getCategories().size()-1){
                output+="/";
            }

        }
        return output;

    }

}
