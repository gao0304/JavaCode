public class User {
    String name;
    String mobilePhone;
    String officePhone;

    public User(String name, String mobilePhone, String officePhone) {
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.officePhone = officePhone;
    }

    @Override
    public String toString() {
        return  " 手机号是：" + mobilePhone + "  "+ "办公室电话是：" + officePhone;
    }
}

