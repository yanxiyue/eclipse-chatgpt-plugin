package com.github.gradusnikov.eclipse.assistai.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.inject.Singleton;

import org.eclipse.e4.core.di.annotations.Creatable;

@Creatable
@Singleton
public class Conversation
{
    public List<ChatMessage> conversation = new LinkedList<>();

    public int size()
    {
        return conversation.size();
    }
    
    public void clear()
    {
        conversation.clear();
    }
    
    public void add(ChatMessage message)
    {
        conversation.add(message);
    }
    
    public synchronized ChatMessage newMessage( String role )
    {
        return new ChatMessage( conversation.size(), role );
    }
    
    public Iterable<ChatMessage> messages()
    {
        return conversation;
    }

    public Optional<ChatMessage> removeLastMessage()
    {
        ChatMessage removed = !conversation.isEmpty() ? conversation.remove( conversation.size() - 1 ) : null;
        return Optional.ofNullable( removed );
        
    }
}
