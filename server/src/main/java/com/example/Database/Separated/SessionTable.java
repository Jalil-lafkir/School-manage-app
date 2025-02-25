package com.example.Database.Separated;

import java.util.ArrayList;

import com.example.models.Session;

public class SessionTable {

    ArrayList<Session> sessions = new ArrayList<Session>();

    public SessionTable() {}

    public ArrayList<Session> readAllSessions() {
       return sessions;
    }

    public void createSession(Session session) {
        this.sessions.add(session);
    }

    public Session readSession(String id) {
        for (Session session : this.sessions) {
            if (session.getId().equals(id)) {
                return session;
            }
        }
        return null;
    }

    public void updateSession(Session session) {
        for (Session dbsession : this.sessions) {
            if (dbsession.getId().equals(session.getId())) {
                sessions.remove(dbsession);
                sessions.add(session);
                return;
            }
        }
    }

    public void deleteSession(Session session) {
        for (Session dbsession : this.sessions) {
            if (dbsession.getId().equals(session.getId())) {
                sessions.remove(dbsession);
                return;
            }
        }
    }

    
    
}
