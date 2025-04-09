package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Junjie", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId(){
        assertEquals("junjiel123", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_members(){
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Mihir"), "Team should contain Mihir");
        assertTrue(t.getMembers().contains("Andrew"), "Team should contain Andrew");
        assertTrue(t.getMembers().contains("Milad"), "Team should contain Milad");
        assertTrue(t.getMembers().contains("Junjie"), "Team should contain Junjie");
        assertTrue(t.getMembers().contains("Benjamin"), "Team should contain Benjamin");
        assertTrue(t.getMembers().contains("Matthew"), "Team should contain Matthew");
    }

    @Test
    public void getTeam_returns_team_with_correct_name(){
        Team t = Developer.getTeam();
        assertEquals("s25-10", t.getName());
    }
}
