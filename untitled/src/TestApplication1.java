import java.util.*;
import java.util.stream.Collectors;

public class TestApplication1 {
    public static void main(String[] args) {
        //Need to write in boot @Autowired but right now i'm on java code
        RoleService service=new RoleService();
        RoleUserService  userRoleService=new RoleUserService ();



        List<Role> roleList=service.findByAllRoles();
        List<RoleUser> roleUserList=userRoleService.findByAllRolesUsers();

List<RoleUserInfoDTO> roleUserInfoDTOS1=new ArrayList<>();   //list1
        roleList.forEach(a->{
            System.out.println(a.getrId());
            RoleUserInfoDTO roleUserInfoDTO=new RoleUserInfoDTO();
            roleUserInfoDTO.setrId(a.getrId());
            roleUserInfoDTO.setPresent(false);
            roleUserInfoDTO.setrName(a.getrName());
            roleUserInfoDTOS1.add(roleUserInfoDTO);
        });
        System.out.println("=======================");
        roleUserList.forEach(a->{
            System.out.println(a.getrId());
            RoleUserInfoDTO roleUserInfoDTO=new RoleUserInfoDTO();
            roleUserInfoDTO.setrId(a.getrId());
            roleUserInfoDTO.setPresent(true);
            roleUserInfoDTO.setrName("Here get data from dp by calling getSpecifc rid thru roneName");
            roleUserInfoDTOS1.add(roleUserInfoDTO);
        });

        Map<String,Integer> result=roleUserInfoDTOS1.parallelStream().sorted(Comparator.comparingLong(RoleUserInfoDTO::getrId).reversed())
                .collect(Collectors.toMap(
                        RoleUserInfoDTO::getrName,RoleUserInfoDTO::getrId,
                        (oldV,newV)->oldV,
                       LinkedHashMap::new
                ));
        System.out.println("------------------------------------------------------");  //Printing
        roleUserInfoDTOS1.forEach(a->{
            System.out.println(a.getrId()+","+a.getrName()+","+a.getPresent()); });
        System.out.println("------------------------------------------------------");
        List<RoleUserInfoDTO> roleUserInfoDTOS2=new ArrayList<>();
        result.forEach((k,v)->{
            System.out.println(k+"-->"+v);
        });
    }
}
