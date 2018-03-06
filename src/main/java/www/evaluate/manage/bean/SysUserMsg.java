package www.evaluate.manage.bean;

/**
 * 系统用户信息
 * 
 * @author trc
 * @version 1.0 2018年1月7日 改订
 * @since 1.0
 */
public class SysUserMsg {

    private Integer id;
    private String username;
    private String nickname;
    private String roleid;
    
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getRoleid() {
        return roleid;
    }
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
    
}
