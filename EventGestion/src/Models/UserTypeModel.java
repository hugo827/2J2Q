package Models;

public class UserTypeModel {

    private Integer idusertype;
    private String userTypeName;

    public UserTypeModel(Integer idusertype, String userTypeName) {
        this.idusertype = idusertype;
        this.userTypeName = userTypeName;
    }

    public Integer getIdusertype() {return idusertype;}
    public String getUserTypeName() { return userTypeName;}

    public String toString() {
        return getUserTypeName();
    }
}
