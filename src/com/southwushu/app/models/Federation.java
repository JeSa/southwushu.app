package com.southwushu.app.models;

import java.util.ArrayList;
import java.util.List;

import com.southwushu.app.persistence.PersistenceManager;

public class Federation {
	
	private static Federation instance;
	private List<Team> teams;
		
	private Federation() {};
	
	public static Federation getInstance(){
		if (instance == null)
			instance = new Federation();
		return instance;
	}
	
	public List<Team> getTeams() {
		if (teams == null) {
			teams = new ArrayList<Team>();
			for (Object obj : PersistenceManager.execNamedQuery(Team.GET_ALL))
				teams.add((Team)obj);
		}
		return teams;
	}
}
