package Models;

public class UserTypeModel {

    private int idusertype;
    private String userTypeName;

    public UserTypeModel(int idusertype, String userTypeName) {
        this.idusertype = idusertype;
        this.userTypeName = userTypeName;
    }

    public int getIdusertype() {return idusertype;}
    public String getUserTypeName() { return userTypeName;}

    public String toString() {
        return getUserTypeName();
    }
}
