/*package com.zensar.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.zensar.security.util.JwtUtils;

public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationheader = request.getHeader("Authorization");

		String token = null;

		String username = null;
		System.out.println("doFilterInternal");
		if (authorizationheader != null && authorizationheader.startsWith("Bearar ")) {

			token = authorizationheader.substring(7);

			username = jwtUtils.extractUsername(token);

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UserDetails userDetails = userDetailsService.loadUserByUsername(username);

				if (jwtUtils.validateToken(token, userDetails)) {

					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());

					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

				}
			}

		}

		filterChain.doFilter(request, response);
	
		
	}

}
*/