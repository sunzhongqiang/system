package com.mmk.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

import com.mmk.security.service.impl.DbVoter;

@Configuration
@EnableWebSecurity
@EnableCaching
@EnableScheduling
public class CommonWebSecurity extends WebSecurityConfigurerAdapter {

	@Resource
	private AuthenticationManager authenticationManager;

	// 一票通过投票器
	@Resource
	private AffirmativeBased baseACL;

	@Resource
	private UnanimousBased unanimousBased;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, @Value("${mode}") String mode) throws Exception {
		auth.parentAuthenticationManager(authenticationManager);
		if ("developing".equals(mode)) {
			auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
		}
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/css/**", "/ueditor/**", "/webuploader/**", "/style/**", "/js/**",
				"/api/**","/weixin/**", "/images/**", "/Javascript/**", "/img/**", "/favicon.ico");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().headers().frameOptions().sameOrigin()
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*")).and().authorizeRequests()
				.antMatchers("/resources/**", "/signup", "/about").permitAll() // 匹配允许url
				.anyRequest().authenticated().and().authorizeRequests().accessDecisionManager(unanimousBased).and()
				.formLogin().loginPage("/login").permitAll().and().logout().invalidateHttpSession(true)
				.logoutSuccessUrl("/login?logout").logoutUrl("/logout").permitAll();

	}

	@Bean
	AffirmativeBased getBase(DbVoter voter) {
		List<AccessDecisionVoter<? extends Object>> decisionVoters = new ArrayList<AccessDecisionVoter<? extends Object>>();
		decisionVoters.add(new RoleVoter());
		decisionVoters.add(new WebExpressionVoter());
		decisionVoters.add(new AuthenticatedVoter());
		decisionVoters.add(voter);
		return new AffirmativeBased(decisionVoters);
	}

	@Bean
	UnanimousBased getUnanimousBased(DbVoter voter) {
		List<AccessDecisionVoter<? extends Object>> decisionVoters = new ArrayList<AccessDecisionVoter<? extends Object>>();
		decisionVoters.add(new RoleVoter());
		decisionVoters.add(new WebExpressionVoter());
		decisionVoters.add(new AuthenticatedVoter());
		decisionVoters.add(voter);
		return new UnanimousBased(decisionVoters);
	}

}
