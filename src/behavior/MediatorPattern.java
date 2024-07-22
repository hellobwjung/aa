package behavior;

import java.util.ArrayList;
import java.util.List;

enum ColleagueType {    
    USER, SYSTEM, ADMIN
} 

abstract class Colleague {
    private Mediator mediator;
    private String message;
    private final String name;
    private final ColleagueType type;
    
    protected Colleague(String name, ColleagueType type) {
        this.name = name;
        this.type = type;    
    }     
    
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;   
    }     
    
    public void setMessage(String message) {
        this.message = message;    
    }     
    
    public Mediator getMediator() {
        return mediator;    
    }     
    
    public String getMessage() {
        return message;    
    }     
     
    public String getName() {        
        return name;    
    }
    
    public ColleagueType getType() {        
        return type;
    }     
    
    public void send() {
        System.out.println(this.name + " send()");
        System.out.println();        
        mediator.mediate(this);    
        }     
    
    public abstract void receive(Colleague colleague); 
}


class UserConcreteColleague extends Colleague {
    public UserConcreteColleague(String name) {
        super(name, ColleagueType.USER);
    }
    @Override    
    public void receive(Colleague colleague) {
        if (ColleagueType.SYSTEM == colleague.getType()) {
            System.out.print("[SYSTEM] ");        
        } else if (ColleagueType.USER == colleague.getType()) {
            System.out.print("[" + colleague.getName() + "] ");
        }        
        System.out.println(colleague.getMessage());    
    }
}

class SystemConcreteColleague extends Colleague {
    public SystemConcreteColleague(String name) {
        super(name, ColleagueType.SYSTEM);
    }     
    @Override
    public void receive(Colleague colleague) {
        System.out.println("System can't receive messages");
    }
}

class AdminConcreteColleague extends Colleague {
    public AdminConcreteColleague(String name) {
        super(name, ColleagueType.ADMIN);    
    }     
    @Override    
    public void receive(Colleague colleague) {
        System.out.println("Admin can't receive messages");    
    }
}
 

interface Mediator {     
    void addColleague(Colleague colleague);     
    void mediate(Colleague colleague);
} 

class ConcreteMediator implements Mediator {
    private List<Colleague> colleagueList;

    public ConcreteMediator() {
        this.colleagueList = new ArrayList<>();
    }

//    public ConcreteMediator(List<Colleague> colleagueList) {
//        this.colleagueList = new ArrayList<>();
//    }

    @Override
    public void addColleague(Colleague colleague) {
        this.colleagueList.add(colleague);
    }

    @Override
    public void mediate(Colleague colleague) {
        for (Colleague receiverColleague : colleagueList) {
            System.out.printf("\t[Mediating " + colleague.getName() + " to " + receiverColleague.getName() + "] ");
            receiverColleague.receive(colleague);
        }
    }
}


 



public class MediatorPattern {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague colleagueUser1 = new UserConcreteColleague("User1");
        Colleague colleagueUser2 = new UserConcreteColleague("User2");
        Colleague colleagueSystem = new SystemConcreteColleague("System");
        Colleague colleagueAdmin = new AdminConcreteColleague("Admin");
//
        colleagueUser1.setMediator(mediator);
        colleagueUser2.setMediator(mediator);
        colleagueSystem.setMediator(mediator);
        colleagueAdmin.setMediator(mediator);

        mediator.addColleague(colleagueUser1);
        mediator.addColleague(colleagueUser2);
        mediator.addColleague(colleagueSystem);
        mediator.addColleague(colleagueAdmin);

        colleagueUser1.setMessage("안녕하세요. User1이 보낸 메시지 입니다.");
        colleagueUser1.send();
//
//        colleagueUser2.setMessage("안녕하세요. User2가 보낸 메시지 입니다.");
//        colleagueUser2.send();
//
//        colleagueSystem.setMessage("잠시 후 20분 뒤에 점검이 있습니다.");
//        colleagueSystem.send();

    }

}
