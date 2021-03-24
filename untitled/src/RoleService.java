import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoleService {
List<Role> findByAllRoles(){
    Role r1=new Role();
r1.setrId(1);
r1.setrName("ADMIN");
r1.setInTime(LocalDateTime.now());
    Role r2=new Role();
    r2.setrId(2);
    r2.setrName("G-ADMIN");
    r2.setInTime(LocalDateTime.now());
    Role r3=new Role();
    r3.setrId(3);
    r3.setrName("N-ADMIN");
    r3.setInTime(LocalDateTime.now());
    Role r4=new Role();
    r4.setrId(4);
    r4.setrName("N+1-ADMIN");
    r4.setInTime(LocalDateTime.now());
    Role r5=new Role();
    r5.setrId(5);
    r5.setrName("N+2-ADMIN");
    r5.setInTime(LocalDateTime.now());
    List<Role> x=new ArrayList<>();
    x.add(r1);x.add(r2);x.add(r3);x.add(r4);x.add(r5);
    return x;
}


}
