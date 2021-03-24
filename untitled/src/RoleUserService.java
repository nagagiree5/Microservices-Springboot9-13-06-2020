import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoleUserService {

    List<RoleUser> findByAllRolesUsers(){
        RoleUser r1=new RoleUser();
        r1.setrId(1);
        r1.setUserId(1);
        RoleUser r2=new RoleUser();
        r2.setrId(2);
        r1.setUserId(1);

        List<RoleUser> x=new ArrayList<>();
        x.add(r1);x.add(r2);
        return x;
    }

}
