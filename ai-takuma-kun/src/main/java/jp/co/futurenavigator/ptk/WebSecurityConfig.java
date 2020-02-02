package jp.co.futurenavigator.ptk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Order(1)
@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;
    /**
     * セキュリティ設定を無視するリクエスト設定
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
            "/img/**",
            "/css/**",
            "/js/**",
            "/webjars/**"
            ,"/**"
            );
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**", "/login")
                .permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
//              .failureUrl("/login-error")
                .defaultSuccessUrl("/top")
                .permitAll()
                .and()
            .logout()
                // ログアウトでログインページに戻る
                .logoutSuccessUrl("/login")
                // セッションを破棄する
                .invalidateHttpSession(true)
                .permitAll();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //ＤＢによる独自認証を行う
        auth.userDetailsService(userDetailsService);
    }

}