package MavenDemo.shiroStudy;

import javax.security.auth.Subject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{
 
  
    
    @Test
    public void testHelloWord(){
    	
    	Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini"); 
    	org.apache.shiro.mgt.SecurityManager  securityManager= factory.getInstance();
    	SecurityUtils.setSecurityManager(securityManager);
    	org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
    	UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
    	try{
    		subject.login(token);
    	}catch (AuthenticationException e) {
    		System.out.println("Login Failed");
    	}
    	Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
    	  
        //6、退出  
        subject.logout();  
    
    }
    
}
