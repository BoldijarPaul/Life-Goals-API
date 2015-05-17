package com.lifegoals.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.lifegoals.app.entities.Token;
import com.lifegoals.app.service.ServiceLocator;
import com.lifegoals.app.service.interf.ITokenManagement;

public class TokenManagementDemoImpl implements ITokenManagement {

	private static List<Token> tokens = new ArrayList<Token>();

	/* how many time the token is valid , now 60 seconds */

	public TokenManagementDemoImpl() {
		Token token=new Token();
		token.setId(0);
		token.setKey(UUID.randomUUID().toString());
		token.setUserId(1);
	}

	/* creating a token for a user */
	@Override
	public Token addToken(int userId) {
		/*
		 * delete all the tokens for this user, so only one can be logged on one
		 * account
		 */
		ServiceLocator.get().getTokenManagement().deleteUserTokens(userId);

		/* create a new token */
		Token token = new Token();
		token.setId(1);
		if (tokens.size() > 0)
			token.setId(tokens.get(tokens.size() - 1).getId() + 1);
		token.setUserId(userId);

		/* setting a random string key */
		token.setKey(UUID.randomUUID().toString());

		/* adding to the list */
		tokens.add(token);
		return token;

	}

	@Override
	public List<Token> deleteUserTokens(int userId) {
		List<Token> deletedTokens = new ArrayList<Token>();
		for (int i = 0; i < tokens.size(); i++) {
			Token token = tokens.get(i);
			if (token.getUserId() == userId) {
				deletedTokens.add(token);
				tokens.remove(i--);
			}
		}
		return deletedTokens;
	}

	@Override
	public List<Token> getAllTokens() {
		return tokens;
	}

	@Override
	public Token getTokenByHash(String hash) {
		for (Token token : tokens) {
			if (token.getKey().equals(hash)) {
				return token;
			}
		}
		return null;
	}

}
