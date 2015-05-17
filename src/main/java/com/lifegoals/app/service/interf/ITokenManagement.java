package com.lifegoals.app.service.interf;

import java.util.List;

import com.lifegoals.app.entities.Token;
import com.lifegoals.app.entities.User;

public interface ITokenManagement {
	public Token addToken(int userId);

	public List<Token> deleteUserTokens(int userId);

	public List<Token> getAllTokens();
	
	public Token getTokenByHash(String hash);

}
