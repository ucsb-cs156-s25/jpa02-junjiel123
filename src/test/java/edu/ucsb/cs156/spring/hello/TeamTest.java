package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.beans.Transient;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   

    @Test
    public void toString_returns_correct_string(){
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equal_returns_true_for_equal_teams(){

        Team t1 = new Team();
        t1.setName("test-team");
        t1.addMember("Mihir");
        t1.addMember("Andrew");
        t1.addMember("Milad");
        t1.addMember("Junjie");
        t1.addMember("Benjamin");
        t1.addMember("Matthew");

        Team clone = t1;
        assert(clone.equals(t1));

        Team nah = new Team();
        assert(!nah.equals(t1));

        String uwu = "uwu";
        assert(!t1.equals(uwu));

        Team t2 = new Team();
        t2.setName("test-team");
        t2.addMember("Mihir");
        t2.addMember("Andrew");
        t2.addMember("Milad");
        t2.addMember("Junjie");
        t2.addMember("Benjamin");
        t2.addMember("Matthew");
        assert(t2.equals(t1));

        Team t3 = new Team();
        t3.setName("test-team");
        t3.addMember("Mihir");
        assert(!t3.equals(t1));

        Team t4 = new Team();
        t4.setName("test-team");
        assert(!t4.equals(t1));

        Team t5 = new Team();
        t5.setName("uwu");
        t5.addMember("Mihir");
        assert(!t5.equals(t1));
    }

    @Test 
    public void check_hashcode(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test 
    public void check_hashcode1(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("uwu");
        t2.addMember("bar");
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }
    
    @Test 
    public void check_hashcode2(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        t2.addMember("yay");
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void check_hashcode3(){
        Team t = new Team();
        t.setName("foo");
        t.addMember("bar");

        int h = t.hashCode();
        assertEquals(h, t.hashCode());
        assertEquals(h, t.hashCode());
    }

    @Test 
    public void check_hashcode4(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("bar");
        t2.addMember("foo");
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test 
    public void check_hashcode5(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        
        Team t2 = new Team();
        t2.setName("faa");
        t2.addMember("bar");
        assertNotEquals(t1.hashCode(), t2.hashCode());
        
    }

    @Test
    public void hashcode_mathMutationKiller() {
        Team t = new Team();
        t.setName("foo");
        t.addMember("faa"); 
        int h = "foo".hashCode();

        ArrayList<String> e = new ArrayList<>();
        e.add("faa");
        int ha = e.hashCode();

        int ex = h | ha;

        assertEquals(ex, t.hashCode());
    }


}
